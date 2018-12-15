/**
 * /*
 * @classname NoCacheFilter.java
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(servletNames = "Controller", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private static final Logger LOGGER = LogManager.getLogger(AuthenticationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		boolean loggedIn = session != null && session.getAttribute("user") != null;
        String uri = req.getRequestURI();
        String contextPath = request.getServletContext().getContextPath();
		
        if (loggedIn) {
			if (uri.equals(contextPath+"/login.jsp")|| uri.equals(contextPath+"/register.jsp")|| uri.equals(contextPath+"/adminRegister.jsp") || uri.equals(contextPath+"/")){	
				if ((boolean) session.getAttribute("isAdmin")) {
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/adminPanel.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/main.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			if (uri.equals(contextPath+"/main.jsp")|| uri.equals(contextPath+"/checkout.jsp")|| uri.equals(contextPath+"/result.jsp") || uri.equals(contextPath+"/adminPanel.jsp") || uri.equals(contextPath+"/expohalls.jsp")){		
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("AuthenticationFilter init");
	}

	@Override
	public void destroy() {
		LOGGER.info("AuthenticationFilter destroy");
	}
}
