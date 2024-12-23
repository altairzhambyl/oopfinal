package Database;

import java.io.Serializable;

import Users.User;

public class LogInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String log;
	
	public LogInfo(User user, String log) {
		this.user = user;
		this.log = log;
	}
	
	public User getUser() {
		return this.user;
	}
	public String getLog() {
		return this.log;
	}
	
	public String getLogInfo() {
		return this.toString();
	}
	
	public String toString() {
		return this.user.getEmail()+" "+this.log;
	}
}