/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package tag;

import java.io.IOException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	private String visitorName;

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	
	public int doStartTag() {
		try {
			pageContext.getOut().write("Hello, " + visitorName +"!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
