package UniversitySystem;

public abstract class User {
	protected String username;
	protected String password;
	protected Role role;
	protected String name;
	protected String id;

	public User(String username, String password, String name, String id, Role role) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.id = id;
		this.role = role;
	}


	public String getUsername() { return username; }
	public String getName() { return name; }
	public String getId() { return id; }
	public Role getRole() { return role; }
	public boolean checkPassword(String password) { return this.password.equals(password); }
}
