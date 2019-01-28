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

import dataBases.SkmStopDb;
import domain.SkmStop;
import domain.SkmTicket;
import logic.SkmTicketLogicalSystem;
import my.vaadin.app.MobiBiletUI.View;
import viewModel.SkmInteraction;

public class LastSkmStationView_7 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");

	final private Button approveButton = new Button("Zatwierdź");

	private List<SkmStop> skmStops = SkmStopDb.getSkmStopDb();
	private MobiBiletUI mobiBiletUI;
	private ComboBox<SkmStop> select = new ComboBox<>("Wybierz stację końcową:");

	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel = new Label();
	
	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz stację końcową:</b></u></h3>";
	

	public LastSkmStationView_7(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

//		configMenuHorizontalLayout();
//		configPrimeVerticalLayout();
		configLayout();
		addItems();
		configItems();
	}

//	private void configPrimeVerticalLayout() {
//
//		primeVerticalLayout.setHeight(80.0f, Unit.PERCENTAGE);
//
//	}
//
//	private void configMenuHorizontalLayout() {
//
//		menuHorizontalLayout.setSpacing(true);
//		menuHorizontalLayout.setHeight(20.0f, Unit.PERCENTAGE);
//		menuHorizontalLayout.setWidth(180.0f, Unit.PERCENTAGE);
//
//	}

	private void configItems() {

		select.setItems(skmStops);
		select.setItemCaptionGenerator(SkmStop::getName);
		select.setWidth(50.0f, Unit.PERCENTAGE);

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		returnToLastViewButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.FIRST_SKM_STATION_VIEW);

		});

		approveButton.addClickListener(e -> {
			SkmInteraction skmInteraction = mobiBiletUI.getSkmInteraction();
			skmInteraction.setLastSkmStop(select.getValue());
			SkmTicket skmTicket = SkmTicketLogicalSystem.calculateTicketType(skmInteraction.getFirstSkmStop().getDistanceToGdanskSrodmiescie(),
					skmInteraction.getLastSkmStop().getDistanceToGdanskSrodmiescie());
			skmInteraction.setSkmTicket(skmTicket);
			mobiBiletUI.navigateTo(View.TYPE_OF_SKM_TICKET_VIEW);

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
		primeVerticalLayout.addComponent(select);
		primeVerticalLayout.addComponent(whiteSpaceLabel);
		primeVerticalLayout.addComponent(approveButton);

		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);
		
		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);
	}

	public void refreshListOfSkmStops() {

		SkmStop first = mobiBiletUI.getSkmInteraction().getFirstSkmStop();

		List<SkmStop> listWithoutFirstStop = new ArrayList<>();
		listWithoutFirstStop.addAll(skmStops);
		for (SkmStop skmStop : skmStops) {

			if (skmStop.getId().equals(first.getId())) {
				listWithoutFirstStop.remove(skmStop);
			}
		}

		select.setItems(listWithoutFirstStop);
	}
}
