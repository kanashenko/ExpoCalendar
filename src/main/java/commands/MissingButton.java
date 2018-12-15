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

import manager.Config;

public class MissingButton implements IButton {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        return Config.getInstance().getProperty(Config.LOGIN);
    }
}
