package domain;

import java.math.BigDecimal;

public class SkmTicket extends Id implements IHaveId {

	private BigDecimal price;
	private Integer from;
	private Integer to;

	public BigDecimal getPrice() {

		return price;
	}

	public void setPrice(BigDecimal price) {

		this.price = price;
	}

	public Integer getFrom() {

		return from;
	}

	public void setFrom(Integer from) {

		this.from = from;
	}

	public Integer getTo() {

		return to;
	}

	public void setTo(Integer to) {

		this.to = to;
	}

}
