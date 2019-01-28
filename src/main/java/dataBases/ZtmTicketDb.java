package dataBases;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.ZtmTicket;
import logic.ZtmTicketLogicalSystem;

public class ZtmTicketDb {

	private static List<ZtmTicket> ztmTicketDb = new ArrayList<ZtmTicket>();
	private static ZtmTicketLogicalSystem ztmTicketLogicalSystem = new ZtmTicketLogicalSystem();

	/**
	 * spis biletów ZTM
	 */
	static {

		/* BILETY NA JEDEN PRZEJAZD */

		// na linie zwykłe
		ztmTicketLogicalSystem.addZtmTicket("zwykły jednoprzejazdowy", new BigDecimal("3.20"), true);
		//ztmTicketLogicalSystem.addZtmTicket("Ulgowy jednoprzejazdowy", new BigDecimal("1.60"), true);

		// na linie nocna, pospieszne, specjalne
		ztmTicketLogicalSystem.addZtmTicket("specjalny (nocny) jednoprzejazdowy", new BigDecimal("4.20"), true);
		//ztmTicketLogicalSystem.addZtmTicket("Specjalny ulgowy jednoprzejazdowy", new BigDecimal("2.10"), true);

		/* BILETY CZASOWE */

		// 1-godzinny na linie zwykłe
		ztmTicketLogicalSystem.addZtmTicket("zwykły godzinny", new BigDecimal("3.60"), false);
		//ztmTicketLogicalSystem.addZtmTicket("Ulgowy godzinny", new BigDecimal("1.90"), false);

		// 1-godzinny na linie nocne, pospieszne, specjalne
		ztmTicketLogicalSystem.addZtmTicket("specjalny (nocny) godzinny", new BigDecimal("4.80"), false);
		//ztmTicketLogicalSystem.addZtmTicket("Specjalny ulgowy godzinny", new BigDecimal("2.40"), false);

		// 24-godzinny
		ztmTicketLogicalSystem.addZtmTicket("24-godzinny", new BigDecimal("13.00"), false);
		//ztmTicketLogicalSystem.addZtmTicket("24-godzinny ulgowy", new BigDecimal("6.50"), false);

	}

	public static List<ZtmTicket> getZtmTicketDb() {

		return ztmTicketDb;
	}

	public static void setSkmTicketDb(List<ZtmTicket> db) {

		ZtmTicketDb.ztmTicketDb = db;
	}

	public static void add(ZtmTicket ztmTicket) {

		Long id = generateId(ztmTicket);
		ztmTicket.setId(id);

		ztmTicketDb.add(ztmTicket);

	}

	public static Long generateId(ZtmTicket skmTicket) {

		return Long.valueOf("" + (ztmTicketDb.size() + 1));
	}

	public static List<ZtmTicket> getZtmTickets(boolean oneTrackTicket) {

		List<ZtmTicket> listOfTickets = new ArrayList<ZtmTicket>();
		for (ZtmTicket ztmTicket : ztmTicketDb) {
			if (ztmTicket.isJednoprzejazdowy() == oneTrackTicket) {
				listOfTickets.add(ztmTicket);

			}
		}
		return listOfTickets;

	}
}
