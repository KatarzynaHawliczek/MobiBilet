package my.vaadin.app;

import java.math.RoundingMode;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import logic.SkmTicketLogicalSystem;
import my.vaadin.app.MobiBiletUI.View;
import viewModel.SkmInteraction;

public class PurchaseSkmTicketView_10 extends VerticalLayout {

	private MobiBiletUI mobiBiletUI;

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");
	
	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Podsumowanie:</b></u></h3>";
	
	final private Label informationLabelFrom = new Label();
	final private Label informationLabelTo = new Label();
	final private Label informationLabelType = new Label();
	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();
	final private Label whiteSpaceLabel3 = new Label();

	final private Label priceLabel = new Label();
	final private Button payButton = new Button("Zapłać");

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();

	public PurchaseSkmTicketView_10(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();

	}

	private String getDiscountName() {

		String discountName = "Rodzaj biletu: ";
		if (mobiBiletUI.getSkmInteraction().getDiscount() != null) {

			return discountName += mobiBiletUI.getSkmInteraction().getDiscount().getDiscountName();
		} else {
			return discountName += "normalny";
		}
	}

	private void configItems() {

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		returnToLastViewButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.TYPE_OF_SKM_TICKET_VIEW);

		});
		payButton.addClickListener(e -> {

			/* !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!production */
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
		primeVerticalLayout.addComponent(informationLabelFrom);
		primeVerticalLayout.addComponent(informationLabelTo);
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

	public void refreshAllFields() {

		String from = "Z: " + mobiBiletUI.getSkmInteraction().getFirstSkmStop().getName();
		String to = "Do: " + mobiBiletUI.getSkmInteraction().getLastSkmStop().getName();
		String price = "<b>Cena: " + SkmTicketLogicalSystem.calculateSkmTicketPrice(mobiBiletUI.getSkmInteraction()).setScale(2, RoundingMode.HALF_UP) + "</b>";

		informationLabelFrom.setValue(from);
		informationLabelTo.setValue(to);
		informationLabelType.setValue(getDiscountName());
		priceLabel.setContentMode(ContentMode.HTML);
		priceLabel.setValue(price);

	}

}
