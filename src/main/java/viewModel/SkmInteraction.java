package viewModel;

import java.math.BigDecimal;

import domain.Discount;
import domain.SkmStop;
import domain.SkmTicket;

public class SkmInteraction {

	private SkmStop firstSkmStop;
	private SkmStop lastSkmStop;
	private SkmTicket skmTicket;
	private Discount discount = null;

	public SkmStop getFirstSkmStop() {

		return firstSkmStop;
	}

	public void setFirstSkmStop(SkmStop firstSkmStop) {

		this.firstSkmStop = firstSkmStop;
	}

	public SkmStop getLastSkmStop() {

		return lastSkmStop;
	}

	public void setLastSkmStop(SkmStop lastSkmStop) {

		this.lastSkmStop = lastSkmStop;
	}

	public SkmTicket getSkmTicket() {

		return skmTicket;
	}

	public void setSkmTicket(SkmTicket skmTicket) {

		this.skmTicket = skmTicket;
	}

	public Discount getDiscount() {

		return discount;
	}

	public void setDiscount(Discount discount) {

		this.discount = discount;
	}

//	public BigDecimal calculateSkmTicketPrice() {
//
//		BigDecimal normalTicketPrice = skmTicket.getPrice();
//		if (discount == null) {
//			return normalTicketPrice;
//		} else {
//			BigDecimal percent = discount.getPercent();
//
//			return normalTicketPrice.multiply(percent);
//		}
//
//	}

}
