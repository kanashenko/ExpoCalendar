/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DaoService;
import entity.Exhibition;
import entity.ExpoHall;
import entity.Visitor;
import local.LocaleHelper;
import manager.Config;

public class LoginButton implements IButton {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginButton.class);
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String LOGIN_ERROR = "LOGIN_ERROR";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
			
		HttpSession session = request.getSession(true);
		String page = null;
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		
		Visitor visitor = DaoService.getVisitor(login, password);
		session.setAttribute("user", visitor);
		
		if(visitor == null) {
			ResourceBundle bundle = LocaleHelper.getBundle(session.getAttribute("language"));
			request.setAttribute("message", bundle.getString(LOGIN_ERROR));
			LOGGER.info("Validation failed");
			return page = Config.getInstance().getProperty(Config.LOGIN);			
		}
	
		if(visitor.isAdmin() == true) {
			LOGGER.info("User " +login+" logged in as administrator");
			session.setAttribute("isAdmin", true);
			page = Config.getInstance().getProperty(Config.ADMIN_PANEL);
			
		}else {
			session.setAttribute("isAdmin", false);
			LOGGER.info("User " +login+" logged in as visitor");
			
			session.setAttribute("exhibitions", DaoService.findAllExhibitions());
			Collection<ExpoHall[]> expoarrays = new ArrayList<ExpoHall[]>();
			Collection<Integer> maxTicketsList = new ArrayList<Integer>();
						
			for (Exhibition item : DaoService.findAllExhibitions()) {
				// fetch expohalls from each exhibition			
				expoarrays.add(DaoService.findExpoHalls(item.getExhibId()).toArray(new ExpoHall[0]));			
				// fetch tickets
				int tickets = DaoService.howManyTickets(item.getExhibId());
				maxTicketsList.add(tickets);
			}
			
			int[] maxTicketsArray = maxTicketsList.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
			session.setAttribute("expohalls", expoarrays);
			session.setAttribute("maxTicketsList", maxTicketsList);
			session.setAttribute("maxTicketsArray", maxTicketsArray);	
			page = Config.getInstance().getProperty(Config.MAIN);
		}
		return page;
	}
}
