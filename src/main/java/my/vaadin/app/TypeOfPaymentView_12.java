package my.vaadin.app;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import my.vaadin.app.MobiBiletUI.View;

public class TypeOfPaymentView_12 extends VerticalLayout {

	final private Button payPalButton = new Button("PayPal");
	final private Button creditCardButton = new Button("Karta kredytowa");

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz metodę płatności:</b></u></h3>";

	private MobiBiletUI mobiBiletUI;

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();

	final private Label whiteSpaceLabel = new Label();

	public TypeOfPaymentView_12(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();

	}

	private void configItems() {

		payPalButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.FINAL_VIEW);

		});

		creditCardButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.FINAL_VIEW);

		});

		informationLabel.setContentMode(ContentMode.HTML);
		informationLabel.setValue(informationForLabel);

		menuHorizontalLayout.setWidth(65f, Unit.PERCENTAGE);
		menuHorizontalLayout.setHeight(50f, Unit.PERCENTAGE);
		menuHorizontalLayout.setComponentAlignment(payPalButton, Alignment.MIDDLE_CENTER);
		menuHorizontalLayout.setComponentAlignment(creditCardButton, Alignment.MIDDLE_RIGHT);

	}

	private void configLayout() {

		setMargin(true);
		addStyleName("outlined");
		setSizeFull();
	}

	private void addItems() {

		primeVerticalLayout.addComponent(informationLabel);
		menuHorizontalLayout.addComponent(whiteSpaceLabel);
		menuHorizontalLayout.addComponent(payPalButton);
		menuHorizontalLayout.addComponent(creditCardButton);

		addComponent(primeVerticalLayout);
		addComponent(menuHorizontalLayout);

		setExpandRatio(menuHorizontalLayout, 0.90f);
		setExpandRatio(primeVerticalLayout, 0.10f);

	}

}
