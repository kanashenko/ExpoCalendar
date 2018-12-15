/**
 * 
 * Contains primary keys of Payment and Ticket entities
 * as DB relation many-to-many.
 *
 * @version 1.0
 *
 * @date 12 рту. 2018 у.
 *
 * Copyright by Mykyta Kanashchenko
 */
package entity;

public class PaymentTicket {
	
	private int paymentTicketId;
	private int payTicket_PaymentId;
	private int payTicket_TicketId;
	
	public PaymentTicket() {
	}
		
	public PaymentTicket(int payTicket_PaymentId, int payTicket_TicketId) {
		super();
		this.payTicket_PaymentId = payTicket_PaymentId;
		this.payTicket_TicketId = payTicket_TicketId;		
	}
	
	public int getPaymentTicketId() {
		return paymentTicketId;
	}

	public void setPaymentTicketId(int paymentTicketId) {
		this.paymentTicketId = paymentTicketId;
	}

	public int getPayTicket_TicketId() {
		return payTicket_TicketId;
	}

	public void setPayTicket_TicketId(int payTicket_TicketId) {
		this.payTicket_TicketId = payTicket_TicketId;
	}

	public int getPayTicket_PaymentId() {
		return payTicket_PaymentId;
	}

	public void setPayTicket_PaymentId(int payTicket_PaymentId) {
		this.payTicket_PaymentId = payTicket_PaymentId;
	}

	@Override
	public int hashCode() {
		int result = 31 * Integer.hashCode(paymentTicketId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PaymentTicket))
			return false;
		PaymentTicket other = (PaymentTicket) obj;
		return this.paymentTicketId == other.paymentTicketId;
	}
	
	@Override
	public String toString() {
		return "PaymentTicket [paymentTicketId=" + paymentTicketId + ", payTicket_TicketId=" + payTicket_TicketId
				+ ", payTicket_PaymentId=" + payTicket_PaymentId + "]";
	}
	
	
}
