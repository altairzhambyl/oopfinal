package Database;


import java.io.IOException;

import Users.*;


public class tester {

    public static void main(String[] args) {
            Teacher t = new Teacher("Second", "Last", "567@kbtu.kz");
            Admin a = new Admin("Admin", "admin", "admin@kbtu.kz");
            
            DataBase db = null;
			try {
				db = DataBase.getInstance();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            db.addUser(t);
            a.addUser(a);
            a.viewLogInfo();
            
            
            // Display courses and users
            System.out.println("Courses in the database:");
            db.getCourses().forEach(System.out::println);
            System.out.println("Users in the database:");
            db.getUsers().forEach(System.out::println);
    }
}
