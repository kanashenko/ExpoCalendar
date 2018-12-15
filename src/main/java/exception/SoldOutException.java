/**
 * Exception is thrown when there is not enough tickes
 * to obtain during DB query.
 * 
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package exception;

public class SoldOutException extends Exception  {
	
	private static final long serialVersionUID = 1L;
	
	public SoldOutException() {};
	public SoldOutException(String message){		
		super(message);
	}
}
