/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package entity;

public class Ticket {
	
	private int ticketId;
	private boolean ticketIsSold;
	private int ticket_exhibitionId;
	private int ticket_paymentId;
	
	public Ticket(){		
	}
	
	public Ticket(int ticketId,boolean ticketIsSold,int ticket_exhibitionId,int ticket_paymentId){	
		this.ticketId = ticketId;
		this.ticketIsSold = ticketIsSold;
		this.ticket_exhibitionId = ticket_exhibitionId;
		this.ticket_paymentId = ticket_paymentId;
	}
	
	public Ticket(int ticketId) {
		super();
		this.ticketId = ticketId;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public boolean isTicketIsSold() {
		return ticketIsSold;
	}
	
	public void setTicketIsSold(boolean ticketIsSold) {
		this.ticketIsSold = ticketIsSold;
	}
	
	public int getTicketExhib() {
		return ticket_exhibitionId;
	}
	
	public void setTicketExhib(int ticketExhibId) {
		this.ticket_exhibitionId = ticketExhibId;
	}
	
	public int getTicket_paymentId() {
		return ticket_paymentId;
	}
	
	public void setTicket_paymentId(int ticket_paymentId) {
		this.ticket_paymentId = ticket_paymentId;
	}
	
	@Override
	public int hashCode() {
		int result = 31 * Integer.hashCode(ticketId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ticket))
			return false;
		Ticket other = (Ticket) obj;
		return this.ticketId == other.ticketId;
	}

	@Override
	public String toString() {
		return "Ticket [Id=" + ticketId + ", IsSold=" + ticketIsSold + ", exhibitionId="
				+ ticket_exhibitionId + ", paymentId=" + ticket_paymentId + "]";
	}
}
