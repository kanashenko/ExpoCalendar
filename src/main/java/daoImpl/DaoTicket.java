/**
 * DaoTicket.java
 *
 * @version 1.0
 *
 * @date Nov 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import connection.ConPool;
import daoNew.DaoUtil;
import daoNew.IdaoTicket;
import entity.Ticket;
import exception.SoldOutException;

public class DaoTicket implements IdaoTicket {
	private static DaoTicket instance;
	private static final Logger LOGGER = LogManager.getLogger(DaoTicket.class.getName());
	
	private DaoTicket() {}
	
	public static DaoTicket getInstance(){
        if(instance == null){
            instance = new DaoTicket();
        }
        return instance;
    }
	
	@Override
	public void addTicket(Ticket ticket) {
		String SQL = "INSERT INTO ticket (ticketId, ticketIsSold, ticket_exhibitionId, ticket_paymentId) values (?,?,?,?)";
		updateTicketDynamically(SQL, ticket.getTicketId(), ticket.isTicketIsSold(), ticket.getTicketExhib(), ticket.getTicket_paymentId());
	}
	
	@Override
	public void makeTicketSold(int ticketId, int paymentId){
		String SQL = "UPDATE Ticket set Ticket.ticketIsSold = true, Ticket.ticket_paymentId = ? where Ticket.ticketId =?";
		updateTicketDynamically(SQL,paymentId, ticketId);
	}
	
	@Override
	public void updateTicketDynamically(String sql, Object... values) {
		DaoUtil.updateDynamically(sql, values);
	}
	
	@Override
	public Ticket findTicketById(int exhibId)throws SoldOutException{
		String SQL = "SELECT * FROM ticket WHERE ticketId = ?";
		List<Ticket> tickets = findTicketsDynamically(SQL, exhibId);
		if(tickets.size()>0) {
			return tickets.get(0);
		}else {
			throw new SoldOutException("tickets are soldout");
		}	
	}
	
	@Override
	public List<Ticket> findAmountofTicketsById(int exhibId, int amount)throws SoldOutException{
		String SQL = "SELECT * FROM ticket WHERE ticket_exhibitionId = ? AND ticketIsSold =false";
		List<Ticket> tickets = findTicketsDynamically(SQL, exhibId);
		if(tickets.size()>=amount) {
			return tickets.subList(0, amount);
		}else {
			throw new SoldOutException("tickets are soldout");
		}
	}
	
	@Override
	public List<Ticket> findTicketsDynamically(String sql, Object... values){
		return DaoUtil.findDynamically(DaoUtil.ObjectType.Ticket,sql,values);
	}
	
	@Override
	public int howManyTickets(int exhibId) {
		int result=0;
		String sql = "select count(*) from( select *from Ticket where ticketIsSold = false and ticket_exhibitionId = ?) as subquery";
		try (Connection con = ConPool.getConnection(); PreparedStatement statement = con.prepareStatement(sql)){
			statement.setInt(1, exhibId);					
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			result = resultSet.getInt(1);		
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());			
		}
		return result;
	}
}
