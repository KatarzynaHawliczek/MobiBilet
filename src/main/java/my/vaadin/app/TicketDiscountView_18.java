package my.vaadin.app;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import my.vaadin.app.MobiBiletUI.View;

public class TicketDiscountView_18 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz rodzaj zniżki:</b></u></h3>";
	
	
	final private Button normalTicketButton = new Button("Bilet normalny");

	final private Button reducedFareTicketButton = new Button("Bilet ulgowy");

	final private Label informationForNormalTicketButton = new Label("Bez zniżki (100% ceny)");
	final private Label informationForReducedFareTicketButton = new Label("Ze zniżki 50% mogą skorzystać:");
	
	final private Label informationItem1 = new Label("- kombatanci, studenci szkół wyższych i wyższych szkół zawodowych bez względu na wiek,");
	final private Label informationItem2 = new Label(
			"- słuchacze kolegiów nauczycielskich, kolegiów nauczycielskich języków obcych oraz kolegiów pracowników służb społecznych,");
	final private Label informationItem3 = new Label("- weterani poszkodowani,");
	final private Label informationItem4 = new Label(
			"- uczniowie szkół podstawowych, gimnazjów, ponadpodstawowych i ponadgimnazjalnych nie będący uprawnieni do korzystania z Gdańskiej Karty Mieszkańca,");
	final private Label informationItem5 = new Label("- uczniowie szkół policealnych o uprawnieniach szkół publicznych do ukończenia 24 roku życia.");

	private MobiBiletUI mobiBiletUI;

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();

	public TicketDiscountView_18(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();

	}

	private void configItems() {

		normalTicketButton.addClickListener(e -> {
			mobiBiletUI.getZtmInteraction().setDiscount(false);

			mobiBiletUI.navigateTo(View.PURCHASE_ZTM_TICKET_VIEW);

		});

		reducedFareTicketButton.addClickListener(e -> {
			mobiBiletUI.getZtmInteraction().setDiscount(true);
			mobiBiletUI.navigateTo(View.PURCHASE_ZTM_TICKET_VIEW);

		});

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		returnToLastViewButton.addClickListener(e -> {
			if (mobiBiletUI.getZtmInteraction().getZtmTicket().isJednoprzejazdowy() == true) {
				mobiBiletUI.navigateTo(View.ONE_TRACK_TICKET_VIEW);

			} else {

				mobiBiletUI.navigateTo(View.TIME_TICKET_VIEW);
			}

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
		primeVerticalLayout.addComponents(normalTicketButton, informationForNormalTicketButton);
		primeVerticalLayout.addComponent(whiteSpaceLabel2);
		primeVerticalLayout.addComponents(reducedFareTicketButton, informationForReducedFareTicketButton);
		primeVerticalLayout.addComponents(informationItem1, informationItem2, informationItem3, informationItem4, informationItem5);

		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);
		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);
	}

}
