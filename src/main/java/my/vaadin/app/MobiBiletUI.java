package my.vaadin.app;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import viewModel.SkmInteraction;
import viewModel.ZtmInteraction;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MobiBiletUI extends UI {

	private SkmInteraction skmInteraction;
	private ZtmInteraction ztmInteraction;

	private boolean lastInteractionWasSkm;

	private HomePage_4 homePage_4;

	private FirstSkmStationView_5 firstSkmStationView_5;
	private LastSkmStationView_7 lastSkmStationView_7;
	private TypeOfSkmTicketView_9 typeOfSkmTicketView_9;
	private PurchaseSkmTicketView_10 purchaseSkmTicketView_10;
	private TypeOfPaymentView_12 typeOfPaymentView_12;
	private FinalView_13 finalView_13;
	private TypeOfZtmTicketView_15 typeOfZtmTicketView_15;
	private OneTrackTicketView_16 oneTrackTicketView_16;
	private TimeTicketView_17 timeTicketView_17;
	private TicketDiscountView_18 ticketDiscountView_18;
	private PurchaseZtmTicketView_19 purchaseZtmTicketView_19;

	public enum View {
		HOME_PAGE, FIRST_SKM_STATION_VIEW, LAST_SKM_STATION_VIEW, TYPE_OF_SKM_TICKET_VIEW, PURCHASE_SKM_TICKET_VIEW, TYPE_OF_PAYMENT_VIEW, FINAL_VIEW, TYPE_OF_ZTM_TICKET_VIEW, ONE_TRACK_TICKET_VIEW, TIME_TICKET_VIEW, TICKET_DISCOUNT_VIEW, PURCHASE_ZTM_TICKET_VIEW;

	}

	@Override
	// inicjalizacja interfejsu użytkownika
	protected void init(VaadinRequest vaadinRequest) {

		skmInteraction = new SkmInteraction();
		ztmInteraction = new ZtmInteraction();
		homePage_4 = new HomePage_4(this);
		firstSkmStationView_5 = new FirstSkmStationView_5(this);
		lastSkmStationView_7 = new LastSkmStationView_7(this);
		typeOfSkmTicketView_9 = new TypeOfSkmTicketView_9(this);
		purchaseSkmTicketView_10 = new PurchaseSkmTicketView_10(this);
		typeOfPaymentView_12 = new TypeOfPaymentView_12(this);
		finalView_13 = new FinalView_13(this);
		oneTrackTicketView_16 = new OneTrackTicketView_16(this);
		timeTicketView_17 = new TimeTicketView_17(this);
		ticketDiscountView_18 = new TicketDiscountView_18(this);
		purchaseZtmTicketView_19 = new PurchaseZtmTicketView_19(this);

		typeOfZtmTicketView_15 = new TypeOfZtmTicketView_15(this);

		// typeOfPaymentZtmView_12A = new TypeOfPaymentZtmView_12A(this);
		// finalZtmView_13A = new FinalZtmView_13A(this);
		//
		setSizeFull();

		navigateTo(View.HOME_PAGE);

	}

	public void navigateTo(View view) {

		switch (view) {

			case HOME_PAGE:
				setContent(homePage_4);
				break;

			case FIRST_SKM_STATION_VIEW:
				setContent(firstSkmStationView_5);
				lastInteractionWasSkm = true;
				break;

			case LAST_SKM_STATION_VIEW:
				lastSkmStationView_7.refreshListOfSkmStops();
				setContent(lastSkmStationView_7);
				break;

			case TYPE_OF_SKM_TICKET_VIEW:
				typeOfSkmTicketView_9.refreshListOfDiscounts();
				setContent(typeOfSkmTicketView_9);
				break;

			case PURCHASE_SKM_TICKET_VIEW:
				purchaseSkmTicketView_10.refreshAllFields();
				setContent(purchaseSkmTicketView_10);
				break;

			case TYPE_OF_PAYMENT_VIEW:
				setContent(typeOfPaymentView_12);
				break;

			case FINAL_VIEW:
				setContent(finalView_13);
				break;

			case TYPE_OF_ZTM_TICKET_VIEW:
				setContent(typeOfZtmTicketView_15);
				lastInteractionWasSkm = false;
				break;

			case ONE_TRACK_TICKET_VIEW:
				setContent(oneTrackTicketView_16);
				break;

			case TIME_TICKET_VIEW:
				setContent(timeTicketView_17);
				break;

			case TICKET_DISCOUNT_VIEW:
				setContent(ticketDiscountView_18);
				break;

			case PURCHASE_ZTM_TICKET_VIEW:
				purchaseZtmTicketView_19.refreshAllFields();
				setContent(purchaseZtmTicketView_19);
				break;

			// default:
			// break;
		}
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MobiBiletUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

	SkmInteraction getSkmInteraction() {

		return skmInteraction;
	}

	ZtmInteraction getZtmInteraction() {

		return ztmInteraction;
	}

	public boolean isLastInteractionWasSkm() {

		return lastInteractionWasSkm;
	}

}
