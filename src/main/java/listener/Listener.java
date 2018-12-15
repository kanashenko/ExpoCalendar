/**
 * @version 1.0
 *
 * @date Sep 3, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	private static final Logger LOGGER = LogManager.getLogger(Listener.class);
   
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    	LOGGER.info("Servlet context is initialized - " + sce);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is called when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    	LOGGER.info("Session is created. Session id = "+ se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    	LOGGER.info("Session is destroyed. Session id = "+ se.getSession().getId());

    }
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    	LOGGER.info("Attribute " + sbe.getName() + " is added to a session (id = " + sbe.getSession().getId() + ")");
    }

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {				
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {		
	}

 
}