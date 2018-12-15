/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package entity;

public class Visitor {
	
	private int visitorId;
	private String visitorName;
	private String login;
	private String password; 
	private boolean isAdmin;
	
	public Visitor(){};
	
	Visitor(String name, String login){
		visitorName = name;
		this.login = login;
	}
	
	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}
	
	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getName() {
		return visitorName;
	}

	public void setName(String name) {
		this.visitorName = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		int result = 31 * Integer.hashCode(visitorId);
		result = 31 * login.hashCode();
		result = 31 * result + visitorName.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Visitor))
			return false;
		Visitor other = (Visitor) obj;
		return this.visitorId == other.visitorId && this.visitorName == other.visitorName && this.login == other.login;
	}

	@Override
	public String toString() {
		return "Visitor [visitorId=" + visitorId + ", visitorName=" + visitorName + ", login=" + login + ", isAdmin="
				+ isAdmin + "]";
	}

	

	

}
