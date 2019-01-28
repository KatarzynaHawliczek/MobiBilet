package my.vaadin.app;

import java.util.List;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import dataBases.SkmStopDb;
import domain.SkmStop;
import my.vaadin.app.MobiBiletUI.View;

public class FirstSkmStationView_5 extends VerticalLayout {

	final private Button homeButton = new Button("Strona domowa");
	final private Button returnToLastViewButton = new Button("Cofnij");
	final private Button approveButton = new Button("Zatwierdź");

	private ComboBox<SkmStop> select = new ComboBox<>();
	private MobiBiletUI mobiBiletUI;

	private List<SkmStop> skmStops = SkmStopDb.getSkmStopDb();

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h3 style=\"color:black;\"><u><b>Wybierz stację początkową:</b></u></h3>";
	
	private HorizontalLayout menuHorizontalLayout = new HorizontalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();
	final private Label whiteSpaceLabel = new Label();

	public FirstSkmStationView_5(MobiBiletUI mobiBiletUI) {

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
//		//primeVerticalLayout.setHeight(80.0f, Unit.PERCENTAGE);
//
//	}
//
//	private void configMenuHorizontalLayout() {
//
////		menuHorizontalLayout.setSpacing(true);
////		menuHorizontalLayout.setHeight(20.0f, Unit.PERCENTAGE);
////		menuHorizontalLayout.setWidth(180.0f, Unit.PERCENTAGE);
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
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		approveButton.addClickListener(e -> {
			mobiBiletUI.getSkmInteraction().setFirstSkmStop(select.getValue());
			mobiBiletUI.navigateTo(View.LAST_SKM_STATION_VIEW);

		});
		
		informationLabel.setContentMode(ContentMode.HTML);
		informationLabel.setValue(informationForLabel);

		menuHorizontalLayout.setWidth(100f, Unit.PERCENTAGE);
		menuHorizontalLayout.setComponentAlignment(homeButton, Alignment.TOP_RIGHT);
	}

	private void configLayout() {

		setMargin(true);
		addStyleName("outlined");
		setWidth(100.0f, Unit.PERCENTAGE);
		setHeight(100.0f, Unit.PERCENTAGE);
		

	}

	private void addItems() {

//		menuLayout.addComponent(returnToLastViewButton);
//		menuLayout.addComponent(homeButton);
		menuHorizontalLayout.addComponent(returnToLastViewButton);
		menuHorizontalLayout.addComponent(homeButton);

		primeVerticalLayout.addComponent(informationLabel);
		primeVerticalLayout.addComponent(select);
		primeVerticalLayout.addComponent(whiteSpaceLabel);
		primeVerticalLayout.addComponent(approveButton);

//		addComponent(menuLayout);
		addComponent(menuHorizontalLayout);
		addComponent(primeVerticalLayout);
//		setExpandRatio(menuLayout, 0.20f);
		setExpandRatio(menuHorizontalLayout, 0.20f);
		setExpandRatio(primeVerticalLayout, 0.80f);

	}

}
