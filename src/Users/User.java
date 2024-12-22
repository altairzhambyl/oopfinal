package Users;

import java.io.File;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Database.DB;

public abstract class User implements Serializable{
public static int userCount = 0;
	
	private final String userId;
	private String userFirstName;
	private String userLastName;
	private String email;
	private String passwordHash;
	private boolean isBlocked = false;
	
	private boolean isLoggedIn;
	
	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}
	
	// Hashing method
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found", e);
        }
    }
	
	
	
	 
	
	public boolean logIn(String password) {
		if (hashPassword(password).equals(this.passwordHash)) {
			this.isLoggedIn = false;
			System.out.println("Login successful!");
			return true;
		} else {
			System.out.println("Man you must've forgor your password *skull emoji*");
			return false;
		}
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (hashPassword(oldPassword).equals(this.passwordHash)) {
			changePassword(newPassword);
			if(new File("data").isFile()) {
	        	try {
	        	DB.loadFromFile(); }
	        	catch (Exception e) {
	        		//cry TODO handle exception
		        	System.err.println("Didnt load database");
	        	}
	        }
	        DB db = DB.getInstance();
	        try {
	        	db.saveToFile();
	        } catch (Exception e) {
        		//cry TODO handle exception
	        	System.err.println("Didnt save new password");
	        }
		} else {
			System.out.println("Man you must've forgor your password *skull emoji*");
		}
	}
	public void changePassword(String newPassword) {
		this.passwordHash = hashPassword(newPassword);
	}
	 
	
	public String getUserId() {
		return this.userId;
	}
	
	
	
	public String getFirstName() {
		return this.userFirstName;	
	}
	
	
	public void setFirstName(String firstname) {
		this.userFirstName = firstname;
	}
	
	
	
	public String getLastName() {
		return this.userLastName;	
	}
	 
	
	public void setLastName(String lastname) {
		this.userLastName = lastname;
	}
	 
	
	public String getEmail() {
		return this.email;	
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean equals(User b) {
		return b.userId == this.userId;
	}
	public static boolean equals(User a, User b) {
		return a.userId == b.userId;
	}
	
	protected void blockUser() {
		this.isBlocked = true;
	}
	protected void unblockUser() {
		this.isBlocked = false;
	}
	
	
	public User(String userFirstName,String userLastName, String email) {
		this();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.email = email;
		this.passwordHash = this.hashPassword("1234");
	}
	public User() {
		User.userCount++;
		this.userId = "2024ID"+User.userCount;	
		//implements DataBase and serialization;
	}
	
	public String toString() {
		return this.userFirstName + ' ' + this.userLastName + ' ' + this.email;
	}
}
