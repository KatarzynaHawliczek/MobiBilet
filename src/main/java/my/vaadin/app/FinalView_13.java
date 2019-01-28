package my.vaadin.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import domain.PdfUtil;
import my.vaadin.app.MobiBiletUI.View;

public class FinalView_13 extends VerticalLayout {

	final private Button pdfUtilButton = new Button("Pobierz bilet w .pdf");
	final private Button homeButton = new Button("Strona domowa");
	final private Label homeButtonLabel = new Label("Powrót na stronę domową");

	final private Label informationLabel = new Label();
	final private String informationForLabel = "<h2 style=\"color:mediumorchid;\"><b>Zakup biletu zakończony powodzeniem!</b></h2>";

	private VerticalLayout menuVerticalLayout = new VerticalLayout();
	private VerticalLayout primeVerticalLayout = new VerticalLayout();

	private MobiBiletUI mobiBiletUI;
	private PdfUtil pdfUtil;

	public FinalView_13(MobiBiletUI mobiBiletUI) {

		super();
		this.mobiBiletUI = mobiBiletUI;

		configLayout();

		addItems();
		configItems();

	}

	private void configItems() {

		StreamResource streamResource;
		try {
			streamResource = createResource();
			FileDownloader fileDownloader = new FileDownloader(streamResource);
			fileDownloader.extend(pdfUtilButton);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		pdfUtilButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.FINAL_VIEW);

		});

		homeButton.addClickListener(e -> {
			mobiBiletUI.navigateTo(View.HOME_PAGE);

		});

		informationLabel.setContentMode(ContentMode.HTML);
		informationLabel.setValue(informationForLabel);

		menuVerticalLayout.setWidth(100f, Unit.PERCENTAGE);
		menuVerticalLayout.setHeight(50f, Unit.PERCENTAGE);
		menuVerticalLayout.setComponentAlignment(homeButton, Alignment.TOP_CENTER);
		menuVerticalLayout.setComponentAlignment(homeButtonLabel, Alignment.TOP_CENTER);

		primeVerticalLayout.setWidth(100f, Unit.PERCENTAGE);
		primeVerticalLayout.setHeight(50f, Unit.PERCENTAGE);
		primeVerticalLayout.setComponentAlignment(informationLabel, Alignment.MIDDLE_CENTER);
		primeVerticalLayout.setComponentAlignment(pdfUtilButton, Alignment.BOTTOM_CENTER);

	}

	private void configLayout() {

		setMargin(true);
		addStyleName("outlined");
		setSizeFull();
	}

	private void addItems() {

		primeVerticalLayout.addComponent(informationLabel);
		primeVerticalLayout.addComponent(pdfUtilButton);
		menuVerticalLayout.addComponent(homeButtonLabel);
		menuVerticalLayout.addComponent(homeButton);

		addComponent(primeVerticalLayout);
		addComponent(menuVerticalLayout);

		setExpandRatio(menuVerticalLayout, 0.50f);
		setExpandRatio(primeVerticalLayout, 0.50f);

	}

	private StreamResource createResource() {

		return new StreamResource(new StreamSource() {

			@Override
			public InputStream getStream() {

				ByteArrayOutputStream bos;
				try {
					if (mobiBiletUI.isLastInteractionWasSkm()) {
						bos = PdfUtil.createSkmPdf(mobiBiletUI.getSkmInteraction());

					} else {
						bos = PdfUtil.createZtmPdf(mobiBiletUI.getZtmInteraction());

					}
					return new ByteArrayInputStream(bos.toByteArray());
				} catch (Exception e) {
					e.printStackTrace();
					return new ByteArrayInputStream(new byte[0]);
				}

			}
		}, getUniqueFileName());
	}

	private String getUniqueFileName() {

		String ticketName = "Ticket" + new Date() + ".pdf";

		return ticketName;
	}

}
