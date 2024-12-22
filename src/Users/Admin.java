package Users;


import Database.DataBase;
import Database.LogInfo;

public class Admin extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin(String first, String last, String email) {
		super(first, last, email);
	}
	
	public void addUser(User user) {
		try {
			DataBase.getInstance().addUser(user);
			DataBase.getInstance().addLog(new LogInfo(this, String.format("Added new user %s to database", user.toString())));
		} catch (Exception e) {
			System.out.println("Failed to add user");
		}
	}
	
	
	
	public void deleteUser(User user) {
		try {
			DataBase.getInstance().removeUser(user);
			DataBase.getInstance().addLog(new LogInfo(this, String.format("removed user %s from database", user.toString())));
		} catch (Exception e) {
			System.out.println("Failed to remove user");
		}
	}
	
	public void viewLogInfo() {
		try {
		DataBase db = DataBase.getInstance();
		System.out.println("All log files:\n");
		db.getLogs().forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Failed to view log info");
		}
	}
	
	public void blockUser(User user) {
		user.blockUser();
	}
	
	
	
	
	
	
}
