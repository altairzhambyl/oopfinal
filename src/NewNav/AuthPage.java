package NewNav;

import java.util.Vector;
import java.util.HashMap;
import Database.*;
import Users.*;
import OfficeRegistrar.Course;
import java.io.*;

public class AuthPage extends Page {
	
	private DB db;
	
    private UserSession session;

    public AuthPage() {
        session = UserSession.getInstance();
        if (new File("data").isFile()) {
            try {
                DB.loadFromFile();
            } catch (Exception e) {
                System.out.println("Failed to load database from file.");
            }
        }
        db = DB.getInstance();
    }

    @Override
    public void display() {
        System.out.println("\n=== Authentication Page ===");
        System.out.println("1. Login");
        System.out.println("2. Say Hi");
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
                sayhi();
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
        User user = db.getUserByUsername(username);
        
        if (user != null && user.logIn(password)) {
            session.setCurrentUser(user);
            new HomePage().start();
        } else {
            System.out.println("Invalid username or password!");
            navigate();
        }
    }

    private void sayhi() {
        System.out.println("HI");
    }

    public void start() {
        while (!session.isLoggedIn()) {
            display();
            navigate();
        }
    }
}
