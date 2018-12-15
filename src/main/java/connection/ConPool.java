/**
 * It is a Singleton class which provides DB Connection Pool
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.TransactionHelper;

public class ConPool {

	private static DataSource dataSource;
	private static final Logger LOGGER = LogManager.getLogger(ConPool.class);

	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/dsExpo");
		} catch (NamingException e) {
			LOGGER.error(e,e);
		} 
	}
	
	public static DataSource getDataSource(){
        return dataSource;
    }
	
	public static Connection getConnection(){

        if(TransactionHelper.isTransactional()){
            return TransactionHelper.getConnection();
        }else {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
            	LOGGER.error(e.getMessage());
            }
            return connection;
        }
    }
}
