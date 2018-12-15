/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package entity;
import java.sql.Timestamp;
public class Payment {
	
	private int paymentId;
	private Timestamp paymentTime; 
	private int paymentVisitorId;
	private int total;
	
	public int getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public Timestamp getPaymentTime() {
		return paymentTime;
	}
	
	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}
	
	public int getpaymentVisitorId() {
		return paymentVisitorId;
	}
	
	public void setpaymentVisitorId(int paymentVisitorId) {
		this.paymentVisitorId = paymentVisitorId;
	}	
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	public int hashCode() {
		int result = 31 * Integer.hashCode(paymentId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Payment))
			return false;
		Payment other = (Payment) obj;
		return this.paymentId == other.paymentId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentTime=" + paymentTime + ", paymentVisitorId="
				+ paymentVisitorId + ", total=" + total + "]";
	}
	
	
}
