package dataBases;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// import domain.SkmDistance;
import domain.SkmTicket;
// import domain.SkmTicketPrice;
import logic.SkmTicketLogicalSystem;

public class SkmTicketDb {

	private static List<SkmTicket> skmTicketDb = new ArrayList<SkmTicket>();

	static {

		SkmTicketLogicalSystem.addTicket(1, 6, new BigDecimal("3.20"));
		SkmTicketLogicalSystem.addTicket(7, 12, new BigDecimal("4.20"));
		SkmTicketLogicalSystem.addTicket(13, 18, new BigDecimal("5.50"));
		SkmTicketLogicalSystem.addTicket(19, 24, new BigDecimal("6.50"));
		SkmTicketLogicalSystem.addTicket(25, 30, new BigDecimal("7.50"));
		SkmTicketLogicalSystem.addTicket(31, 40, new BigDecimal("8.50"));
		SkmTicketLogicalSystem.addTicket(41, 50, new BigDecimal("9.50"));
		SkmTicketLogicalSystem.addTicket(51, 60, new BigDecimal("10.50"));
		SkmTicketLogicalSystem.addTicket(61, 70, new BigDecimal("12.50"));
		SkmTicketLogicalSystem.addTicket(71, 80, new BigDecimal("13.50"));
		SkmTicketLogicalSystem.addTicket(81, 90, new BigDecimal("14.50"));
		SkmTicketLogicalSystem.addTicket(91, 100, new BigDecimal("15.50"));
		SkmTicketLogicalSystem.addTicket(101, 120, new BigDecimal("17.50"));
		SkmTicketLogicalSystem.addTicket(121, 140, new BigDecimal("19.50"));
		SkmTicketLogicalSystem.addTicket(141, 160, new BigDecimal("21.50"));
		SkmTicketLogicalSystem.addTicket(161, 180, new BigDecimal("23.50"));
		SkmTicketLogicalSystem.addTicket(181, 200, new BigDecimal("25.50"));
		SkmTicketLogicalSystem.addTicket(201, 220, new BigDecimal("27.50"));

	}

	public static List<SkmTicket> getSkmTicketDb() {

		return skmTicketDb;
	}

	public static void setSkmTicketDb(List<SkmTicket> db) {

		SkmTicketDb.skmTicketDb = db;
	}

	public static void add(SkmTicket skmTicket) {

		Long id = generateId(skmTicket);
		skmTicket.setId(id);

		skmTicketDb.add(skmTicket);

	}

	public static Long generateId(SkmTicket skmTicket) {

		return Long.valueOf("" + (skmTicketDb.size() + 1));
	}

}
