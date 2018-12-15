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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Exhibition;
import manager.Config;

public class CheckoutButton implements IButton {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page;
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<Exhibition> exhibs = (List<Exhibition>)session.getAttribute("exhibitions");
		Collection<Exhibition> choosenexhibs = new ArrayList<>();
		Collection<Integer> choosenTickets = new ArrayList<>();
		Collection<Integer> prices = new ArrayList<>();
		int totalPrice = 0;
		
		for (Exhibition item : exhibs) {
			int numOfTickets = Integer.parseInt(request.getParameter(item.getExhibitionName()));
			if (numOfTickets > 0) {
				choosenTickets.add(numOfTickets);
				choosenexhibs.add(item);
				int oneExhibitionPrice = item.getPrice() * numOfTickets;
				prices.add(oneExhibitionPrice);
				totalPrice = totalPrice + oneExhibitionPrice;
			}
		}
		
		if (totalPrice > 0) {
			session.setAttribute("choosenTickets", choosenTickets);
			session.setAttribute("choosenexhibs", choosenexhibs);
			session.setAttribute("prices", prices);
			session.setAttribute("totalPrice", totalPrice);
			page = Config.getInstance().getProperty(Config.CHECKOUT);
		}
		else {
			page = Config.getInstance().getProperty(Config.MAIN);
		}		
		return page;
	}
}
