package Users;


import Database.DB;
import Database.DB;
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
			DB.loadFromFile();
			DB loadeddb = DB.getInstance();
			loadeddb.addUser(user);
			LogInfo log = new LogInfo(this, "Added new user to database");
			//loadeddb.addLog(log);
		} catch (Exception e) {
			System.out.println("Failed to add user");
		}
	}
	
	
	
	public void deleteUser(User user) {
		try {
			DB.loadFromFile();
			DB loadeddb = DB.getInstance();
			loadeddb.removeUser(user);
			loadeddb.addLog(new LogInfo(this, "removed user from database"));
		} catch (Exception e) {
			System.out.println("Failed to remove user");
		}
	}
	
	public void viewLogInfo() {
		try {
		DB db = DB.getInstance();
		db.loadFromFile();
		DB loadeddb = DB.getInstance();
		System.out.println("All log files:\n");
		loadeddb.getLogs().forEach(System.out::println);
		} catch (Exception e) {
			System.out.println("Failed to view log info");
		}
	}
	
	public void blockUser(User user) {
		user.blockUser();
	}
	
	
	
	
	
	
}
