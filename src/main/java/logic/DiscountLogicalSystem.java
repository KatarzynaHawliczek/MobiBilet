package logic;

import java.math.BigDecimal;

import dataBases.DiscountDb;
import domain.Discount;

public class DiscountLogicalSystem {


	public void addDiscount(String discountName, BigDecimal percent) {

		Discount discount = new Discount();
		discount.setDiscountName(discountName);
		discount.setPercent(percent);
		DiscountDb.add(discount);

	}

}
