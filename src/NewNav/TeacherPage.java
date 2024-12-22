package NewNav;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


import exceptions.*;
import Database.DB;
import Users.*;
import Courses.*;

public class TeacherPage extends Page {
    private Map<String, User> users;
    private Map<String, Course> courses;
    private UserSession session;
    
    public TeacherPage(){
        users = new HashMap<>();
        session = UserSession.getInstance();
        
        if(new File("data").isFile()) {
        	try {
        	DB.loadFromFile(); }
        	catch (Exception e) {
        		//cry TODO handle exception
        	}
        }
        DB db = DB.getInstance();
        for (User u : db.getUsers()) {
            users.put(u.getEmail(), u);
        }
        for (Course c : db.getCourses()) {
        	if(c.getCourseInstructor().equals(session.getCurrentUser())) {
        		courses.put(c.getCourseCode(), c);
        	}
        }
    }
    
    @Override
    public void display() {
        System.out.println("\n=== Teacher Page ===");
        System.out.println("1. View Courses");
        System.out.println("2. Manage Courses");
        System.out.println("3. View Students info");
        System.out.println("4. Put Marks");
        System.out.println("5. Send Message");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
    }

    @Override
    public void navigate() {
        int choice = getUserChoice();
        
        switch(choice) {
            case 1:
                System.out.println("Viewing courses...");
                try {
                    if (courses == null) {
                        throw new NullMapException("The provided HashMap is null.");
                    }
                	courses.forEach((key, course) -> {
                		System.out.println(course.toString());
                	});
                } catch (NullMapException e) {
                	System.out.println("No courses available");
                }
                break;
            case 2:
                System.out.println("Managing courses...");
                new ManageCoursePage().start();
                break;
            case 3:
                new HomePage().start();
                break;
            case 4:
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                navigate();
        }
    }

    public void start() {
        while(true) {
            display();
            navigate();
        }
    }
}