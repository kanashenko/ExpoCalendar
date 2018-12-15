/**
 * 
 * Is a "Service layer" class that provides
 * wrapper DAO's methods for commands.
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package service;

import java.util.List;
import daoNew.DaoFactory;
import entity.Exhibition;
import entity.ExpoHall;
import entity.Visitor;

public class DaoService {
	
	public static Visitor getVisitor(String login, String pass) {
		Visitor visitorFromDB = DaoFactory.getDaoVisitor().findVisitorbyLogin(login);
		if (visitorFromDB != null && visitorFromDB.getPass().equals(pass)) {
			return visitorFromDB;
		}
		return null;
	}
	
	public static void addVisitor(Visitor visitor) {
		DaoFactory.getDaoVisitor().addVisitor(visitor);
	}

	public static List<Exhibition> findAllExhibitions() {
		return DaoFactory.getDaoExhibition().findAllExhibitions();
	}
	
	public static Exhibition findExhibitionbyName(String name) {
		return DaoFactory.getDaoExhibition().findExhibitionbyName(name);
	}
	
	public static void addExhibition(Exhibition exhibition) {
		DaoFactory.getDaoExhibition().addExhibition(exhibition);
	}

	public static List<ExpoHall> findExpoHalls(int exhibId) {
		return DaoFactory.getDaoExpoHall().findExpoHallsbyId(exhibId);
	}
	
	public static void addExpoHall(ExpoHall expoHall) {
		DaoFactory.getDaoExpoHall().addExpoHall(expoHall);
	}

	public static int howManyTickets(int exhibId) {
		return DaoFactory.getDaoTicket().howManyTickets(exhibId);
	}
}
