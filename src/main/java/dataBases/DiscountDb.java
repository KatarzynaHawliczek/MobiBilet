package dataBases;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.Discount;
import logic.DiscountLogicalSystem;

public class DiscountDb {

	private static List<Discount> discountDb = new ArrayList<Discount>();
	private static DiscountLogicalSystem discountLogicalSystem = new DiscountLogicalSystem();

	static {

		discountLogicalSystem.addDiscount("100%", new BigDecimal("1.0"));
		discountLogicalSystem.addDiscount("25% - osoby powyżej 60 lat", new BigDecimal("0.75"));
		discountLogicalSystem.addDiscount("33% - nauczyciele", new BigDecimal("0.67"));
		discountLogicalSystem.addDiscount("37% - Karta Dużej Rodziny, Dzieci i młodzież w wieku 4-24 lata, Inwalidzi, Niewidomi ", new BigDecimal("0.63"));
		discountLogicalSystem.addDiscount("49% - osoby niezdolne do samodzielnej egzystencji", new BigDecimal("0.51"));
		discountLogicalSystem.addDiscount("50% - ulga wykupiona przez pracodawcę", new BigDecimal("0.50"));
		discountLogicalSystem.addDiscount("51% - kombatanci, studenci do lat 26, doktoranci do lat 35", new BigDecimal("0.49"));
		discountLogicalSystem.addDiscount("78% - żołnierze, dzieci i młodzież niepełnosprawne, inwalidzi wojenni", new BigDecimal("0.22"));
		discountLogicalSystem.addDiscount("93% - osoby niewidome niezdolne do samodzielnej egzystencji", new BigDecimal("0.07"));
		discountLogicalSystem.addDiscount("95% - przewodnicy inwalidów I grupy", new BigDecimal("0.05"));
		discountLogicalSystem.addDiscount("100% - dzieci do lat 4", new BigDecimal("0.00"));

	}

	public static List<Discount> getDiscountDb() {

		return discountDb;
	}

	public static void setDiscountDb(List<Discount> db) {

		DiscountDb.discountDb = db;
	}

	public static void add(Discount discount) {

		Long id = generateId(discount);
		discount.setId(id);

		discountDb.add(discount);

	}

	public static Long generateId(Discount discount) {

		return Long.valueOf("" + (discountDb.size() + 1));
	}

}
