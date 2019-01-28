package my.vaadin.app;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import dataBases.DiscountDb;
import domain.Discount;
import domain.SkmTicket;
import my.vaadin.app.MobiBiletUI.View;

public class TypeOfSkmTicketView_9 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz rodzaj biletu:</b></u></h3>";

	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();
	final private Label whiteSpaceLabel3 = new Label();
	final private Button normalSkmBiletButton = new Button("Normalny");
	private ComboBox<Discount> discountComboBox = new ComboBox<>("Ulgowy");

	final private Button approveButton = new Button("Zatwierdź");
	private MobiBiletUI mobiBiletUI;

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();

	private List<Discount> discounts = DiscountDb.getDiscountDb();

	public TypeOfSkmTicketView_9(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();
	}

	private void configItems() {

		discountComboBox.setItems(discounts);
		discountComboBox.setItemCaptionGenerator(Discount::getDiscountName);
		discountComboBox.setWidth(50.0f, Unit.PERCENTAGE);

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		returnToLastViewButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.LAST_SKM_STATION_VIEW);

		});

		
		normalSkmBiletButton.addClickListener(e -> {
			//tu
			mobiBiletUI.getSkmInteraction().setDiscount(null);
			//
			mobiBiletUI.navigateTo(View.PURCHASE_SKM_TICKET_VIEW);
		});

		approveButton.addClickListener(e -> {
			mobiBiletUI.getSkmInteraction().setDiscount(discountComboBox.getValue());
			mobiBiletUI.navigateTo(View.PURCHASE_SKM_TICKET_VIEW);

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

		primeVerticalLayout.addComponent(normalSkmBiletButton);
		primeVerticalLayout.addComponent(whiteSpaceLabel2);
		primeVerticalLayout.addComponent(discountComboBox);
		primeVerticalLayout.addComponent(whiteSpaceLabel3);
		primeVerticalLayout.addComponent(approveButton);

		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);

		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);
	}

	public void refreshListOfDiscounts() {

		Discount percent100 = mobiBiletUI.getSkmInteraction().getDiscount();

		List<Discount> listWithoutPercent100 = new ArrayList<>();
		listWithoutPercent100.addAll(discounts);
		for (Discount discount : discounts) {

			if (discount.getDiscountName().equals("100%")) {
				listWithoutPercent100.remove(discount);
			}
		}

		discountComboBox.setItems(listWithoutPercent100);
	}
}
