/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.Visitor;
import manager.Config;

public class LogoutButton implements IButton {

	private static final Logger LOGGER = LogManager.getLogger(LogoutButton.class);
	private static final String USER = "user";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String page;
		String login = ((Visitor) request.getSession().getAttribute(USER)).getLogin();
		LOGGER.info("User "+login+" logged out");
		request.getSession().invalidate();
		page = Config.getInstance().getProperty(Config.LOGIN);	
		return page;
	}
}
