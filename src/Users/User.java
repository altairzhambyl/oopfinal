package Users;

public abstract class User {
	private int id;
	private String firstName;
	private String lastName;
	
	
	public String toString() {
		return "UserID: " + this.id;
	}
}
