/**
 * In order to change language on web page,
 * provides <code>ResourceBundle</code> based on <code>Locale</code>.
 * Utilized by commands.
 *
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package local;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleHelper {
	
	private static Locale loc;
	private static ResourceBundle bundle;

	public static ResourceBundle getBundle(Object locale) {
		if (locale instanceof Locale) {
			Locale local = (Locale) locale;
			bundle = ResourceBundle.getBundle("MyBundle", local);
		} else {
			loc = new Locale((String) locale);
			bundle = ResourceBundle.getBundle("MyBundle", loc);
		}
		return bundle;
	}
}
