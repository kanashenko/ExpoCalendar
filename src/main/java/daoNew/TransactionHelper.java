/**
 * TransactionHelper.java
 *
 * @version 1.0
 *
 * @date Nov 29, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoNew;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import connection.ConPool;

public class TransactionHelper {
	private static final Logger LOGGER = LogManager.getLogger(TransactionHelper.class);
    private static Connection connection;
    private static boolean isTransaction = false;

    public static void startTransaction() {
        try {
        	LOGGER.info("Transaction started");
            connection = ConPool.getDataSource().getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
        	LOGGER.error(e.getMessage());
        }
        isTransaction = true;
    }

    public static void rollback() {
        isTransaction = false;
        if (connection !=null) {
            try {
                connection.rollback();
                LOGGER.info("Transaction rolled back");
            } catch (SQLException e) {
            	LOGGER.error(e.getMessage());
            }
            connection = null;
        }
    }

    public static void endTransaction() {

        isTransaction = false;
        try {
            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
        	LOGGER.error(e.getMessage());
        }
        connection = null;
        LOGGER.info("Transaction ended");
    }

    public static Connection getConnection() {
        return connection;
    }

    public static boolean isTransactional() {
        return isTransaction;
    }
}
