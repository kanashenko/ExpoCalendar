/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package servlet;

import commands.IButton;
import commands.LoginButton;
import local.LocaleHelper;
import manager.Config;

import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "Controller", urlPatterns = { "/Controller" })
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SERVLET_EXECPTION = "SERVLET_EXCEPTION";
	private static final String IO_EXCEPTION = "IO_EXCEPTION";
	private ControllerHelper controllerHelper = ControllerHelper.getInstance();
	private static final Logger LOGGER = LogManager.getLogger(LoginButton.class);

	public Controller() {
		super();
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = null;
		HttpSession session = request.getSession(true);
		ResourceBundle bundle = LocaleHelper.getBundle(session.getAttribute("language"));
		try {
			IButton command = controllerHelper.getCommand(request);
			page = command.execute(request, response);
		} catch (ServletException e) {
			page = catchHelper(e, request, bundle.getString(SERVLET_EXECPTION));
		} catch (IOException e) {
			page = catchHelper(e, request, bundle.getString(IO_EXCEPTION));
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	private String catchHelper(Exception e, HttpServletRequest request, String message) {
		LOGGER.error(e, e);
		request.setAttribute("error", message);
		return Config.getInstance().getProperty(Config.ERROR);
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
