package logic;

import java.math.BigDecimal;
import java.util.List;

import dataBases.SkmTicketDb;
import domain.Discount;
import domain.SkmTicket;
import viewModel.SkmInteraction;

public class SkmTicketLogicalSystem {

	public static void addTicket(Integer from, Integer to, BigDecimal price) {

		SkmTicket skmTicket = new SkmTicket();

		skmTicket.setFrom(from);
		skmTicket.setTo(to);
		skmTicket.setPrice(price);
		SkmTicketDb.add(skmTicket);

	}

	public static BigDecimal calculateSkmTicketPrice(SkmInteraction skmInteraction) {

		BigDecimal normalTicketPrice = skmInteraction.getSkmTicket().getPrice();
		if (skmInteraction.getDiscount() == null) {
			return normalTicketPrice;
		} else {
			BigDecimal percent = skmInteraction.getDiscount().getPercent();

			return normalTicketPrice.multiply(percent);
		}

	}

	public static SkmTicket calculateTicketType(Integer firstSkmStation, Integer lastSkmStation) {

		Integer skmDistance = calculateSkmStopsDistance(firstSkmStation, lastSkmStation);
		List<SkmTicket> stationList = SkmTicketDb.getSkmTicketDb();
		for (SkmTicket skmTicket : stationList) {
			if (skmDistance >= skmTicket.getFrom() && skmDistance <= skmTicket.getTo()) {
				return skmTicket;
			}
		}
		return null;

	}

	private static Integer calculateSkmStopsDistance(Integer firstSkmStation, Integer lastSkmStation) {

		Integer distance = lastSkmStation - firstSkmStation;
		if (distance < 0) {
			distance *= -1;
		}
		return distance;
	}

}
