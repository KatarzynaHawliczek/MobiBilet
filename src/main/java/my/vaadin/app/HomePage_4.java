package my.vaadin.app;

import java.math.RoundingMode;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import domain.ZtmTicket;
import logic.ZtmTicketLogicalSystem;
import my.vaadin.app.MobiBiletUI.View;
import viewModel.ZtmInteraction;

public class HomePage_4 extends VerticalLayout {

	private Button buttonSkm = new Button("SKM Trójmiasto");

	private Button buttonZtm = new Button("ZTM Trójmiasto");

	final private Label welcomeLabel = new Label();
	final private String welcome = "<h2 style=\"color:mediumvioletred;\"><b>Witaj w aplikacji MobiBilet</b></h2>";
	
	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz środek transportu</b></u></h3>";
	
	final private Label informationForButtonSKM = new Label("Kolejka");
	final private Label informationForButtonZTM = new Label("Autobus, tramwaj");

	private MobiBiletUI mobiBiletUI;

	private VerticalLayout informationLayout = new VerticalLayout();
	private VerticalLayout verticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();
	final private Label whiteSpaceLabel3 = new Label();
	final private Label whiteSpaceLabel4 = new Label();

	public HomePage_4(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();

	}

	private void configItems() {

		buttonSkm.addClickListener(e -> {

			mobiBiletUI.navigateTo(View.FIRST_SKM_STATION_VIEW);

		});

		buttonZtm.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.TYPE_OF_ZTM_TICKET_VIEW);

		});
		
		
		welcomeLabel.setContentMode(ContentMode.HTML);
		welcomeLabel.setValue(welcome);
		
		informationLabel.setContentMode(ContentMode.HTML);
		informationLabel.setValue(informationForLabel);

	}

	private void configLayout() {

		setMargin(true);
		addStyleName("outlined");
		setSizeFull();
	}

	private void addItems() {

		informationLayout.addComponent(welcomeLabel);
		informationLayout.addComponent(whiteSpaceLabel1);
		informationLayout.addComponent(informationLabel);
		
		verticalLayout.addComponent(whiteSpaceLabel2);
		verticalLayout.addComponents(buttonSkm, informationForButtonSKM);
		verticalLayout.addComponent(whiteSpaceLabel3);
		verticalLayout.addComponents(buttonZtm, informationForButtonZTM);

		addComponent(informationLayout);
		addComponent(verticalLayout);
		setExpandRatio(informationLayout, 0.15f);
		setExpandRatio(verticalLayout, 0.850f);

	}

}
