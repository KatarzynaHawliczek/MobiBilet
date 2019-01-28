package domain;

import java.math.BigDecimal;

public class Discount extends Id {

	private BigDecimal percent;
	private String discountName;

	public String getDiscountName() {

		return discountName;
	}

	public void setDiscountName(String name) {

		this.discountName = name;
	}

	public BigDecimal getPercent() {

		return percent;
	}

	public void setPercent(BigDecimal percent) {

		this.percent = percent;
	}

}
