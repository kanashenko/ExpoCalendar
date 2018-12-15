/**
 * DaoFactoryNew.java
 *
 * @version 1.0
 *
 * @date Oct 8, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package dao;

import daoImpl.DaoExhibition;
import daoImpl.DaoExpoHall;
import daoImpl.DaoPayment;
import daoImpl.DaoTicket;
import daoImpl.DaoVisitor;

public class DaoFactory {
	public static DaoVisitor getDaoVisitor() {
		return DaoVisitor.getInstance();
	}
	public static DaoTicket getDaoTicket() {
		return DaoTicket.getInstance();
	}
	public static DaoExhibition getDaoExhibition() {
		return DaoExhibition.getInstance();
	}
	public static DaoExpoHall getDaoExpoHall() {
		return DaoExpoHall.getInstance();
	}
	public static DaoPayment getDaoPayment() {
		return DaoPayment.getInstance();
	}
}
