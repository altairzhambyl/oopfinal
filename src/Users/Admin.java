package Users;

import java.io.IOException;
import java.util.Vector;

import Database.DataBase;

public class Admin extends User {
	
	
	public void addUser(User user) {
		try {
			DataBase.getInstance().addUser(user);
		} catch (Exception e) {
			System.out.println("Failed to add user");
		}
	}
	
	
	
	public void deleteUser(User user) {
		try {
			DataBase.getInstance().removeUser(user);
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
