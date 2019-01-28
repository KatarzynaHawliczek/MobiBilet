package my.vaadin.app;

import java.math.RoundingMode;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import logic.SkmTicketLogicalSystem;
import logic.ZtmTicketLogicalSystem;
import my.vaadin.app.MobiBiletUI.View;

public class PurchaseZtmTicketView_19 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");
	final private Label priceLabel = new Label("Cena: ");

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Podsumowanie:</b></u></h3>";
	
	
	final private Label informationLabelTicketName = new Label();
	final private Label informationLabelType = new Label();

	final private Button payButton = new Button("Zapłać");

	private MobiBiletUI mobiBiletUI;

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();
	final private Label whiteSpaceLabel3 = new Label();

	public PurchaseZtmTicketView_19(MobiBiletUI mobiBiletUI) {

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
			mobiBiletUI.navigateTo(View.TICKET_DISCOUNT_VIEW);

		});

		payButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.TYPE_OF_PAYMENT_VIEW);

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
		primeVerticalLayout.addComponent(informationLabelTicketName);
		primeVerticalLayout.addComponent(informationLabelType);
		primeVerticalLayout.addComponent(whiteSpaceLabel2);
		primeVerticalLayout.addComponent(whiteSpaceLabel3);
		primeVerticalLayout.addComponent(priceLabel);
		primeVerticalLayout.addComponent(payButton);

		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);

		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);
	}

	private String getDiscountName() {

		String discountName = "Rodzaj biletu: ";
		if (mobiBiletUI.getZtmInteraction().isDiscount() == true) {

			return discountName += "ulga 50%";
		} else {
			return discountName += "brak ulgi";
		}

	}

	public void refreshAllFields() {

		String name = "Rodzaj biletu: " + mobiBiletUI.getZtmInteraction().getZtmTicket().getName();
		String price = "<b>Cena: " + ZtmTicketLogicalSystem.calculateZtmTicketPrice(mobiBiletUI.getZtmInteraction()).setScale(2, RoundingMode.HALF_UP) + "</b>";

		informationLabelTicketName.setValue(name);
		informationLabelType.setValue(getDiscountName());
		priceLabel.setContentMode(ContentMode.HTML);
		priceLabel.setValue(price);

	}

}
