/**
 * Singleton class
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package manager;

import java.util.ResourceBundle;

public class Config {
	
	private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "config";
    public static final String ADMINKEY = "ADMINKEY";
    public static final String DRIVER = "DRIVER";
    public static final String URL = "URL";
    public static final String MAIN = "MAIN";
    public static final String ERROR = "ERROR";
    public static final String LOGIN = "LOGIN";
    public static final String REGISTER = "REGISTER";
    public static final String ADMIN_REGISTER = "ADMIN_REGISTER";
    public static final String ADMIN_PANEL = "ADMIN_PANEL";
    public static final String EXHIBS = "EXHIBS";
    public static final String EXPOS = "EXPOS";
    public static final String TICKETS = "TICKETS";
    public static final String PAYMENTS = "PAYMENTS";
    public static final String CHECKOUT = "CHECKOUT";
    public static final String CONTROLLER = "CONTROLLER";
    public static final String RESULT = "RESULT";
        
    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
