/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package commands;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.Config;

public class ChangeLocaleButton implements IButton{
	
	private static final String LOCALE = "locale";
	private static Locale locale;

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page;
		HttpSession session = request.getSession(true);	
		
		switch (request.getParameter(LOCALE)) {
		case "en":
			locale = new Locale("en", "US");
			ResourceBundle loc_en = ResourceBundle.getBundle("manager/MyBundle", locale);
			session.setAttribute("locale", loc_en);
			break;
		case "ru":
			locale = new Locale("ru", "RU");
			ResourceBundle loc_ru = ResourceBundle.getBundle("manager/MyBundle_ru", locale);
			session.setAttribute("locale", loc_ru);
			break;
		}
		
		page = Config.getInstance().getProperty(Config.LOGIN);
		return page;
	}
}
