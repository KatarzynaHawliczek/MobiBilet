package logic;

import java.math.BigDecimal;

import dataBases.ZtmTicketDb;
import domain.ZtmTicket;
import viewModel.SkmInteraction;
import viewModel.ZtmInteraction;

public class ZtmTicketLogicalSystem {

	public void addZtmTicket(String name, BigDecimal price, boolean jednoprzejazdowy) {

		ZtmTicket ztmTicket = new ZtmTicket();

		ztmTicket.setName(name);
		ztmTicket.setPrice(price);
		ztmTicket.setJednoprzejazdowy(jednoprzejazdowy);
		ZtmTicketDb.add(ztmTicket);

	}

	public static BigDecimal calculateZtmTicketPrice(ZtmInteraction ztmInteraction) {

		BigDecimal normalTicketPrice = ztmInteraction.getZtmTicket().getPrice();
		if (ztmInteraction.isDiscount()) {

			return normalTicketPrice.divide(new BigDecimal("2.0"));
		} else {

			return normalTicketPrice;
		}

	}

}
