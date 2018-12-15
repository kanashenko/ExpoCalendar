/**
 * ControllerHelper.java is a Singleton class. 
 * It contains HashMap of commands and corresponding
 * jsp pages names, on which those commands were used.
 * This class used by servlet Controller.
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package servlet;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import commands.AddExhibitionButton;
import commands.AddExpoHallButton;
import commands.BuyButton;
import commands.ChangeLocaleButton;
import commands.CheckoutButton;
import commands.GoToMainPageButton;
import commands.IButton;
import commands.LoginButton;
import commands.LogoutButton;
import commands.MenuAdminButton;
import commands.MissingButton;
import commands.RegisterAdminButton;
import commands.RegisterButton;

public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, IButton> commands = new HashMap<String, IButton>();

    private ControllerHelper() {
        commands.put("login", new LoginButton());
        commands.put("register", new RegisterButton());
        commands.put("registerAdmin", new RegisterAdminButton());
        commands.put("logout", new LogoutButton());
        commands.put("menuAdmin", new MenuAdminButton());
        commands.put("addExhib", new AddExhibitionButton());
        commands.put("addExpo", new AddExpoHallButton());
        commands.put("checkout", new CheckoutButton());
        commands.put("buy", new BuyButton());
        commands.put("changeLocale", new ChangeLocaleButton());    
        commands.put("goToMain", new GoToMainPageButton());      
    }
    
    /**
     * Returns the command <code>IButton</code> from 
     * <code>commands</code> HashMap
     * based on the comand's name obtained from 
     *<code>request</code> parmeter
     *
     * @param request servlet request 
     */
    public IButton getCommand(HttpServletRequest request) {
    	IButton command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new MissingButton();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
