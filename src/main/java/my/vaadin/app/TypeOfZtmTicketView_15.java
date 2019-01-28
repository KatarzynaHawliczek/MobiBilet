package my.vaadin.app;

import java.util.List;

import org.jsoup.safety.Whitelist;

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
import viewModel.ZtmInteraction;

public class TypeOfZtmTicketView_15 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");

	final private Button oneTrackTicketButton = new Button("Jednoprzejazdowy");

	final private Button timeTicketButton = new Button("Czasowy");

	final private Label informationForOneTrackTicketButton = new Label("Bilet na jeden środek transportu");
	final private Label informationForTimeTicketButton = new Label("Bilet na dowolną ilość środków transportu (przejazd w określonym czasie)");

	private MobiBiletUI mobiBiletUI;

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel1 = new Label();
	final private Label whiteSpaceLabel2 = new Label();
	
	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz typ biletu:</b></u></h3>";
	

	public TypeOfZtmTicketView_15(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();
		addItems();
		configItems();

	}

	private void configItems() {

		oneTrackTicketButton.addClickListener(e -> {
			ZtmInteraction ztmInteraction = mobiBiletUI.getZtmInteraction();
			//
			mobiBiletUI.navigateTo(View.ONE_TRACK_TICKET_VIEW);

		});

		timeTicketButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.TIME_TICKET_VIEW);

		});

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		returnToLastViewButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

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
		primeVerticalLayout.addComponents(oneTrackTicketButton, informationForOneTrackTicketButton);
		primeVerticalLayout.addComponent(whiteSpaceLabel2);
		primeVerticalLayout.addComponents(timeTicketButton, informationForTimeTicketButton);

		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);
		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);

	}

}
