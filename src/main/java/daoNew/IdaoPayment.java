/**
 * IdaoPayment.java
 *
 * @version 1.0
 *
 * @date Nov 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoNew;

import java.util.List;
import entity.Payment;

public interface IdaoPayment {
	int addPayment(Payment payment);
	
	List<Payment> findPaymentByVisitor(int visitorId);
	List<Payment> findPaymentsDynamically(String sql, Object... values);
}
