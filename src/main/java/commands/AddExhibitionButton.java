/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DaoService;
import entity.Exhibition;
import local.LocaleHelper;
import manager.Config;

public class AddExhibitionButton implements IButton {
	
	private static final Logger LOGGER = LogManager.getLogger(AddExhibitionButton.class);
	private static final String NAME = "name";
	private static final String PRICE = "price";
	private static final String STARTDATE = "startDate";
	private static final String ENDDATE = "endDate";
	private static final String INPUT_ERROR = "REGISTER_ERROR";
	private static final String ADD_EXHIB_SUCCESS = "ADD_EXHIB_SUCCESS";	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page;
		HttpSession session = request.getSession(true);
		ResourceBundle bundle = LocaleHelper.getBundle(session.getAttribute("language"));
		String name = request.getParameter(NAME);
			
		if(name =="" || request.getParameter(PRICE) == "" || request.getParameter(STARTDATE) == "" || request.getParameter(ENDDATE) == "") {
			request.setAttribute("message", bundle.getString(INPUT_ERROR));
		}else {		
			int price = Integer.parseInt(request.getParameter(PRICE));
			LocalDate startDate = LocalDate.parse((request.getParameter(STARTDATE)), formatter);
			LocalDate endDate = LocalDate.parse((request.getParameter(ENDDATE)), formatter);
			Exhibition exhibition = new Exhibition();
			exhibition.setExhibitionName(name);
			exhibition.setPrice(price);
			exhibition.setExhibStart(startDate);		
			exhibition.setExhibEnd(endDate);
			DaoService.addExhibition(exhibition);
			request.setAttribute("message", name + bundle.getString(ADD_EXHIB_SUCCESS));
			LOGGER.info("new "+ request.getParameter(NAME)+" exhibition was added");			
		}
		page = Config.getInstance().getProperty(Config.EXHIBS);
		return page;
	}
}
