package Users;

public abstract class User {
	private String id;
	private String firstName;
	private String lastName;
	
	private String email;
	private String password;
	
	public int hashCode() {
		return email.hashCode() + 31*password.hashCode();
	}
	
	
	public String toString() {
		return "UserID: " + this.id;
	}
}
