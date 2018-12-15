/**
 * LogoutButtonTest.java
 *
 * @version 1.0
 *
 * @date Sep 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package commands;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import entity.Visitor;

public class LogoutButtonTest {

	final HttpServletResponse response = mock(HttpServletResponse.class);
	final HttpServletRequest request = mock(HttpServletRequest.class);
	final HttpSession session = mock(HttpSession.class);
	final Visitor visitor = mock(Visitor.class);

	@Test
	public void TestLogoutButtonExecute() throws Exception {
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("user")).thenReturn(visitor);
		when(visitor.getLogin()).thenReturn("user");
		String result = new LogoutButton().execute(request, response);	
		verify(request, times(2)).getSession();
		verify(session, times(1)).getAttribute("user");
		verify(session, times(1)).invalidate();
		assertEquals("/login.jsp", result);
	}

}
