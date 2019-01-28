package my.vaadin.app;

import java.util.List;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import dataBases.ZtmTicketDb;
import domain.ZtmTicket;
import my.vaadin.app.MobiBiletUI.View;

public class TimeTicketView_17 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Bilet czasowy:</b></u></h3>";
	
	final private List<ZtmTicket> ztmTimeTickets = ZtmTicketDb.getZtmTickets(false);

	private MobiBiletUI mobiBiletUI;

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();

	public TimeTicketView_17(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();

	}

	private void configItems() {

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		returnToLastViewButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.TYPE_OF_ZTM_TICKET_VIEW);

		});
		
		informationLabel.setContentMode(ContentMode.HTML);
		informationLabel.setValue(informationForLabel);
		
		menuHorizontalLayout.setWidth(100f, Unit.PERCENTAGE);
		menuHorizontalLayout.setComponentAlignment(homeButton, Alignment.TOP_RIGHT);

	}

	private void configLayout() {

		setMargin(true);
		addStyleName("outlined");
		setSizeFull();
	}

	private void addItems() {

		menuHorizontalLayout.addComponent(returnToLastViewButton);
		menuHorizontalLayout.addComponent(homeButton);
		primeVerticalLayout.addComponent(informationLabel);
		primeVerticalLayout.addComponent(whiteSpaceLabel1);
		for (ZtmTicket ztmTicket : ztmTimeTickets) {
			Button timeTicketButton = new Button("Bilet " + ztmTicket.getName());
			primeVerticalLayout.addComponent(timeTicketButton);

			timeTicketButton.addClickListener(e -> {
				mobiBiletUI.getZtmInteraction().setZtmTicket(ztmTicket);
				mobiBiletUI.navigateTo(View.TICKET_DISCOUNT_VIEW);
			});

		}
		primeVerticalLayout.addComponent(whiteSpaceLabel2);

		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);
		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);

	}

}
