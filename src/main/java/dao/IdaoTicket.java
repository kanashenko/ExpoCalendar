/**
 * IdaoTicket.java
 *
 * @version 1.0
 *
 * @date Nov 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package dao;

import java.util.List;
import entity.Ticket;
import exception.SoldOutException;

public interface IdaoTicket {
	void addTicket(Ticket ticket);
	void makeTicketSold(int ticketId, int paymentId);	
	void updateTicketDynamically(String sql, Object... values);
	
	Ticket findTicketById(int exhibId)throws SoldOutException;	
	List<Ticket> findAmountofTicketsById(int exhibId, int amount) throws SoldOutException;	
    List<Ticket> findTicketsDynamically(String sql, Object... values);
    
    int howManyTickets(int exhibId);

	//String getTableName();		
}
