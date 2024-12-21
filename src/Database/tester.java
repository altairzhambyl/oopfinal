package Database;

import java.util.ArrayList;

import OfficeRegistrar.Course;
import Users.Teacher;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Teacher t = new Teacher("First", "Last", "324@kbtu.kz");
			Course course = new Course(
				    "notcode", "АДС", "НЕТ ОПИСАНИЯ"
				);
			
			
			UserBase.getInstance();
			UserBase.INSTANCE.addToList(t);
			///DataBase.INSTANCE.addCourse(course); // Use INSTANCE safely after the fix
	        UserBase.writeData(); // Save to file
	        System.out.println("Data written to file successfully.");

	        // Read and display courses
	        System.out.println("Courses in the database:");
	        UserBase.INSTANCE.getList().forEach(System.out::println);
	    } catch (Exception e) {
	        System.err.println("Error in Main: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
