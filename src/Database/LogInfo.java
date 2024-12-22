package Database;

import Users.User;

public class LogInfo {
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
		return this.user.toString()+' '+this.log;
	}
}
