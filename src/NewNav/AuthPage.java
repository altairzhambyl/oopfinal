package NewNav;

import java.util.HashMap;
import java.util.Map;

public class AuthPage extends Page {
    private Map<String, User> users;
    private UserSession session;

    public AuthPage() {
        users = new HashMap<>();
        session = UserSession.getInstance();
        // Add a default user for testing
        users.put("admin", new User("admin", "admin123"));
    }

    @Override
    public void display() {
        System.out.println("\n=== Authentication Page ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        scanner.nextLine(); // Clear the buffer

        switch(choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                navigate();
        }
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setCurrentUser(user);
            System.out.println("Login successful!");
            new HomePage().start();
        } else {
            System.out.println("Invalid username or password!");
            navigate();
        }
    }

    private void register() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            navigate();
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords don't match!");
            navigate();
            return;
        }

        users.put(username, new User(username, password));
        System.out.println("Registration successful! Please login.");
        navigate();
    }

    public void start() {
        while(!session.isLoggedIn()) {
            display();
            navigate();
        }
    }
}