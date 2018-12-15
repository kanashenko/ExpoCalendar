/**
 * DaoPayment.java
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
import java.sql.Statement;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import connection.ConPool;
import daoNew.DaoUtil;
import daoNew.IdaoPayment;
import daoNew.TransactionHelper;
import entity.Payment;

public class DaoPayment implements IdaoPayment {
	private static DaoPayment instance;
	private static final Logger LOGGER = LogManager.getLogger(DaoPayment.class.getName());
		
	private DaoPayment() {}
	
	public static DaoPayment getInstance(){
        if(instance == null){
            instance = new DaoPayment();
        }
        return instance;
    }
	
	public List<Payment> findPaymentByVisitor(int visitorId){
		String SQL = "SELECT * FROM payment WHERE PaymentVisitorId = ?";
		List<Payment> payments = findPaymentsDynamically(SQL, visitorId);
		if(payments.size()>0) {
			return payments;
		}
		return null;
	}
	
	public List<Payment> findPaymentsDynamically(String sql, Object... values){
		return DaoUtil.findDynamically(DaoUtil.ObjectType.Payment,sql,values);
	}
	
	public int addPayment(Payment payment) {
		int newId=0;
		String sql = "INSERT INTO Payment (paymentTime, PaymentVisitorId, total) values (?,?,?)";
		Connection con = null;
		try {
			con = ConPool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setTimestamp(1, payment.getPaymentTime());
			statement.setInt(2, payment.getpaymentVisitorId());
			statement.setInt(3, payment.getTotal());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();			
			if (rs.next()) {
				newId = rs.getInt(1);
			}
			LOGGER.info("new payment has been added");				
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			if (con != null) {
				TransactionHelper.rollback();
            }			
		}
		return newId;
	}
}
