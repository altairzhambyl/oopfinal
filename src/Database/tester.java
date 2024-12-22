package Database;

import java.util.ArrayList;

import OfficeRegistrar.Course;
import Users.Teacher;


public class tester {
<<<<<<< HEAD

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Teacher t = new Teacher("First", "Last", "324@kbtu.kz");
			Course course = new Course(
				    "notcode", "АДС", "НЕТ ОПИСАНИЯ"
				);
			
			
			DataBase.getInstance();
			
			DataBase.INSTANCE.addUser(t);
			DataBase.INSTANCE.addCourse(course); // Use INSTANCE safely after the fix
	        DataBase.writeData(); // Save to file
       
	        
	        // Read and display courses
	        System.out.println("Courses in the database:");
	        DataBase.INSTANCE.getCourses().forEach(System.out::println);
	        System.out.println("Users in the database:");
	        DataBase.INSTANCE.getUsers().forEach(System.out::println);
	    } catch (Exception e) {
	        System.err.println("Error in Main: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

=======
    public static void main(String[] args) {
        try {
            Teacher t = new Teacher("First", "Last", "324@kbtu.kz");
            Course course = new Course("notcode", "АДС", "НЕТ ОПИСАНИЯ");
            
            DataBase db = DataBase.getInstance();
            db.addUser(t);
            db.addCourse(course);
            
            // Display courses and users
            System.out.println("Courses in the database:");
            db.getCourses().forEach(System.out::println);
            System.out.println("Users in the database:");
            db.getUsers().forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error in Main: " + e.getMessage());
            e.printStackTrace();
        }
    }
>>>>>>> 72688a717f77500995ce0d31d80296cdee44f99a
}
