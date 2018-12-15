/**
 * Interface for all commands 
 *
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

public interface IButton {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
