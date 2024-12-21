package Database;

import java.util.ArrayList;

import OfficeRegistrar.Course;
import Users.Teacher;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    ArrayList<Teacher> teaches = new ArrayList<Teacher>();
			teaches.add(new Teacher());
			Course course = new Course(
				    "code", "ООП", "да"
				);
			
			

			DataBase.INSTANCE.addCourse(course); // Use INSTANCE safely after the fix
	        DataBase.writeData(); // Save to file
	        System.out.println("Data written to file successfully.");

	        // Read and display courses
	        System.out.println("Courses in the database:");
	        DataBase.INSTANCE.getCourses().forEach(System.out::println);
	    } catch (Exception e) {
	        System.err.println("Error in Main: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
