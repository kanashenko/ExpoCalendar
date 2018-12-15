/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */

package commands;

import java.util.Arrays;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DaoService;
import entity.ExpoHall;
import local.LocaleHelper;
import manager.Config;

public class AddExpoHallButton implements IButton {
	
	private static final String INPUT_ERROR = "REGISTER_ERROR";		
	private static final Logger LOGGER = LogManager.getLogger(AddExpoHallButton.class);
	private static final String NAMES = "names";
	private static final String EXHIBITION = "exhibName";
	private static final String ADD_EXPO_SUCCESS = "ADD_EXPO_SUCCESS";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page;
		HttpSession session = request.getSession(true);
		ResourceBundle bundle = LocaleHelper.getBundle(session.getAttribute("language"));
		String exhibition = request.getParameter(EXHIBITION);
		String names = request.getParameter(NAMES);	
		
		if(exhibition =="" || names =="") {
			request.setAttribute("message", bundle.getString(INPUT_ERROR));
		}else {	
			String[] expoHalls =  names.split(",");
			
			for(int i = 0; i < expoHalls.length; i++ ) {
				ExpoHall expoHall = new ExpoHall();
				expoHall.setExpoHallName(expoHalls[i]);		
				expoHall.setExpo_exhibitionId(DaoService.findExhibitionbyName(exhibition).getExhibId());
				DaoService.addExpoHall(expoHall);
			}
			request.setAttribute("message", Arrays.toString(expoHalls) + bundle.getString(ADD_EXPO_SUCCESS));
			LOGGER.info("Expo Halls "+names+" were added for "+exhibition+" exhibition");
		}		
		page = Config.getInstance().getProperty(Config.EXPOS);
		return page;
	}
}
