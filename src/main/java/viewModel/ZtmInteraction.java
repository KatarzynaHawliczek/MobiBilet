package viewModel;

import domain.ZtmTicket;

public class ZtmInteraction {

	ZtmTicket ztmTicket;
	boolean discount;

	public boolean isDiscount() {

		return discount;
	}

	public void setDiscount(boolean discount) {

		this.discount = discount;
	}

	public ZtmTicket getZtmTicket() {

		return ztmTicket;
	}

	public void setZtmTicket(ZtmTicket ztmTicket) {

		this.ztmTicket = ztmTicket;
	}

}
