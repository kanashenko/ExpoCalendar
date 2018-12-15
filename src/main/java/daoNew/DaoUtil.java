/**
 * DaoUtil.java
 *
 * @version 1.0
 *
 * @date Oct 8, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoNew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import connection.ConPool;
import entity.Exhibition;
import entity.ExpoHall;
import entity.Payment;
import entity.Ticket;
import entity.Visitor;

public class DaoUtil {

	private static final Logger LOGGER = LogManager.getLogger(DaoUtil.class.getName());
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void updateDynamically(String sql, Object... values) {
		Connection connection = null;
		try {
			connection = ConPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; values != null && i < values.length; i++) {
				statement.setObject(i + 1, values[i]);
			}
			statement.executeUpdate();			
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			if (connection != null) {
				TransactionHelper.rollback();
            }
		}
		
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> findDynamically(ObjectType objectType, String sql, Object... values) {
		List<T> result = new ArrayList<>();
		try (Connection con = ConPool.getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
			for (int i = 0; values != null && i < values.length; i++) {
				statement.setObject(i + 1, values[i]);
			}
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				switch (objectType) {
				case Visitor:
					result.add((T) getVisitorFromResultSet(resultSet));
					break;
				case Ticket:
					result.add((T) getTicketFromResultSet(resultSet));
					break;				
				case Exhibition:
					result.add((T) getExhibitionFromResultSet(resultSet));
					break;
				case ExpoHall:
					result.add((T) getExpoHallFromResultSet(resultSet));
					break;
				case Payment:
					result.add((T) getPaymentFromResultSet(resultSet));
					break;
				}
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return result;
	}

	private static Visitor getVisitorFromResultSet(ResultSet resultSet) throws SQLException {
		Visitor visitor = new Visitor();
		visitor.setVisitorId(resultSet.getInt("visitorId"));	
		visitor.setName(resultSet.getString("visitorName"));
		visitor.setLogin(resultSet.getString("login"));		
		visitor.setPass(resultSet.getString("password"));
		visitor.setIsAdmin(resultSet.getBoolean("isAdmin"));
		return visitor;
	}
	
	private static Ticket getTicketFromResultSet(ResultSet resultSet) throws SQLException {
		Ticket ticket = new Ticket();
		ticket.setTicketId(resultSet.getInt("ticketId"));
		ticket.setTicketIsSold(resultSet.getBoolean("ticketIsSold"));
		ticket.setTicketExhib(resultSet.getInt("ticket_exhibitionId")); 
		return ticket;
	}
	
	private static Exhibition getExhibitionFromResultSet(ResultSet resultSet) throws SQLException {
		Exhibition exhibition = new Exhibition();
		exhibition.setExhibId(resultSet.getInt("exhibitionId"));
		exhibition.setExhibitionName(resultSet.getString("exhibitionName"));
		exhibition.setPrice(resultSet.getInt("price"));
		exhibition.setExhibStart(LocalDate.parse(resultSet.getString("exhibStart"), formatter)); 
		exhibition.setExhibEnd(LocalDate.parse(resultSet.getString("exhibEnd"), formatter));  		
		return exhibition;
	}
	
	private static ExpoHall getExpoHallFromResultSet(ResultSet resultSet) throws SQLException {
		ExpoHall expoHall = new ExpoHall();
		expoHall.setExpoHallId(resultSet.getInt("expoHallId"));
		expoHall.setExpoHallName(resultSet.getString("expoHallName"));
		expoHall.setExpo_exhibitionId(resultSet.getInt("expo_exhibitionId"));
		return expoHall;
	}
	
	private static Payment getPaymentFromResultSet(ResultSet resultSet) throws SQLException {
		Payment payment = new Payment();
		payment.setPaymentId(resultSet.getInt("paymentId"));
		payment.setPaymentTime(resultSet.getTimestamp("paymentTime"));
		payment.setpaymentVisitorId(resultSet.getInt("paymentVisitorId"));
		payment.setTotal(resultSet.getInt("paymentVisitorId"));
		return payment;
	}

	public enum ObjectType {
		Visitor,
		Ticket,
		Exhibition,
		ExpoHall,
		Payment;
	}
}
