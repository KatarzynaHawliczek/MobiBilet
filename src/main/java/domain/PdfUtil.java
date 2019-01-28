package domain;

import java.io.ByteArrayOutputStream;
import java.math.RoundingMode;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import logic.SkmTicketLogicalSystem;
import logic.ZtmTicketLogicalSystem;
import viewModel.SkmInteraction;
import viewModel.ZtmInteraction;

public class PdfUtil {

	public static ByteArrayOutputStream createSkmPdf(SkmInteraction skmInteraction) throws Exception {

		// Creating a PdfWriter
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(output);

		// Creating a PdfDocument
		PdfDocument pdf = new PdfDocument(writer);

		// Creating a Document
		Document document = new Document(pdf);

		String title = "BILET NA PRZEJAZD";
		String from = "Stacja poczatkowa: " + skmInteraction.getFirstSkmStop();
		String to = "Stacja koncowa: " + skmInteraction.getLastSkmStop();
		String discountName = "Rodzaj biletu: ";
		if (skmInteraction.getDiscount() != null) {

			discountName += skmInteraction.getDiscount().getDiscountName();
		} else {
			discountName += "normalny";
		}

		
		String price = "Cena: " + (SkmTicketLogicalSystem.calculateSkmTicketPrice(skmInteraction)).setScale(2, RoundingMode.HALF_UP);
		
		// Creating Paragraphs

		Paragraph paragraph0 = new Paragraph(title);
		Paragraph paragraph1 = new Paragraph(from);
		Paragraph paragraph2 = new Paragraph(to);
		Paragraph paragraph3 = new Paragraph(discountName);
		Paragraph paragraph4 = new Paragraph(price);

		// Adding paragraphs to document
		document.add(paragraph0);
		document.add(paragraph1);
		document.add(paragraph2);
		document.add(paragraph3);
		document.add(paragraph4);

		// Closing the document
		document.close();

		return output;
	}

	public static ByteArrayOutputStream createZtmPdf(ZtmInteraction ztmInteraction) throws Exception {

		// Creating a PdfWriter
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PdfWriter writer = new PdfWriter(output);

		// Creating a PdfDocument
		PdfDocument pdf = new PdfDocument(writer);

		// Creating a Document
		Document document = new Document(pdf);

		String title = "BILET NA PRZEJAZD";

		String name = "Nazwa: " + ztmInteraction.getZtmTicket().getName();
		String discountTicket;
		if (ztmInteraction.isDiscount() == true) {
			discountTicket = "Ulga: 50%";

		} else {
			discountTicket = "Ulga: 100%";
		}
		String price = "Cena: " + (ZtmTicketLogicalSystem.calculateZtmTicketPrice(ztmInteraction)).setScale(2, RoundingMode.HALF_UP);
		// Creating Paragraphs

		Paragraph paragraph0 = new Paragraph(title);
		Paragraph paragraph1 = new Paragraph(name);
		Paragraph paragraph2 = new Paragraph(discountTicket);
		Paragraph paragraph3 = new Paragraph(price);

		// Adding paragraphs to document
		document.add(paragraph0);
		document.add(paragraph1);
		document.add(paragraph2);
		document.add(paragraph3);

		// Closing the document
		document.close();

		return output;
	}
}