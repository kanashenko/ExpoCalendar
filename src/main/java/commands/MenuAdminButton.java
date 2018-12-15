/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.Config;

public class MenuAdminButton implements IButton {
	
	private static final String OPTION = "radios";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;

		switch (request.getParameter(OPTION)) {
		case "Exhibitions":
			page = Config.getInstance().getProperty(Config.EXHIBS);
			break;
		case "ExpoHalls":
			page = Config.getInstance().getProperty(Config.EXPOS);
			break;
		case "Tickets":
			page = Config.getInstance().getProperty(Config.TICKETS);
			break;
		case "Payments":
			page = Config.getInstance().getProperty(Config.PAYMENTS);
			break;
		}
		return page;
	}
}
