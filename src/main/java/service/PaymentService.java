/**
 * Performs a transaction as a result of tickets purchase
 * Makes <code>Ticket</code> sold and adds new <code>Payment</code> and
 *  <code>PaymentTicket</code> entries to DB.
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import daoImpl.DaoTicket;
import daoNew.DaoFactory;
import daoNew.TransactionHelper;
import entity.Exhibition;
import entity.Payment;
import entity.Ticket;
import exception.SoldOutException;

public class PaymentService {

	private static final Logger LOGGER = LogManager.getLogger(PaymentService.class.getName());

	public static boolean performTransaction(int visitorId, int totalPrice, Collection<Exhibition> exhibitions,
			Collection<Integer> choosenTickets) {
		
		
		DaoTicket ticketdao = DaoFactory.getDaoTicket();		
		Integer[] amountTickets = new Integer[exhibitions.size()];
		choosenTickets.toArray(amountTickets);
		int counter = 0;
		List<List<Ticket>> allEventTickets = new ArrayList<>();
		
		for (Exhibition item : exhibitions) {
			int exhibId = item.getExhibId();
			int amountTicket = amountTickets[counter];
			List<Ticket> oneEventTickets = null;
			try {			
				oneEventTickets = ticketdao.findAmountofTicketsById(exhibId, amountTicket);		
				allEventTickets.add(oneEventTickets);
				
			}catch(SoldOutException e) {
				LOGGER.error(e.getMessage());
				return false;
			}
			counter++;
		}
	
		TransactionHelper.startTransaction();		
		Payment payment = new Payment();
		payment.setpaymentVisitorId(visitorId);
		Date date = new Date();
		Timestamp paymentTime = new Timestamp(date.getTime());
		payment.setPaymentTime(paymentTime);
		payment.setTotal(totalPrice);
		int newID = DaoFactory.getDaoPayment().addPayment(payment);
		
		for (List<Ticket> oneEventTickets : allEventTickets) {
			for (Ticket ticket : oneEventTickets) {
				ticketdao.makeTicketSold(ticket.getTicketId(), newID);
				LOGGER.info("ticket "+ticket.getTicketId()+" was sold");	
			}
		}
		
		TransactionHelper.endTransaction();
		return true;
	}
}
