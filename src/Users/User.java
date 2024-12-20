package Users;

public abstract class User {
	private int id;
	private String firstName;
	private String lastName;
	
	private String email;
	private String password;
	
	
	public String toString() {
		return "UserID: " + this.id;
	}
}
