package domain;

import java.math.BigDecimal;

public class ZtmTicket extends Id implements IHaveId {

	private String name;
	private BigDecimal price;
	private boolean jednoprzejazdowy;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public BigDecimal getPrice() {

		return price;
	}

	public void setPrice(BigDecimal price) {

		this.price = price;
	}

	public boolean isJednoprzejazdowy() {

		return jednoprzejazdowy;
	}

	public void setJednoprzejazdowy(boolean jednoprzejazdowy) {

		this.jednoprzejazdowy = jednoprzejazdowy;
	}

}
