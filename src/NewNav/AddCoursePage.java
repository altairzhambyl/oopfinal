//package NewNav;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//import Courses.Course;
//import Database.DB;
//import Enums.*;
//import Users.User;
//
//public class AddCoursePage extends Page {
//    private UserSession session;
//    private Map<String, Course> courses;
//
//    public AddCoursePage() {
//        this.session = UserSession.getInstance();
//        
//        if(new File("data").isFile()) {
//        	try {
//        	DB.loadFromFile(); }
//        	catch (Exception e) {
//        		//cry TODO handle exception
//        	}
//        }
//        DB db = DB.getInstance();
//        for (Course c : db.getCourses()) {
//        	if(c.getCourseInstructor().equals(session.getCurrentUser())) {
//        		courses.put(c.getCourseCode(), c);
//        	}
//        }
//    }
//
//    @Override
//    public void display() {
//        if (Page.language == Language.EN) {
//            System.out.println("\n=== Add Course Page ===");
//            System.out.println("Write the data in the following order:");
//            System.out.println("1. Course code");
//            System.out.println("2. Course name");
//            System.out.println("3. Course description");
//            System.out.println("4. Credits in ECTS");
//            System.out.println("5. Credits in KZ");
//            System.out.println("6. Course year");
//            System.out.println("7. Course type: 1.Major, 2.Minor, 3.Elective");
//            
//        } else if (Page.language == Language.RU) {
//            System.out.println("\n=== Add Course Page ===");
//            System.out.println("Write the data in the following order:");
//            System.out.println("1. Course code");
//            System.out.println("2. Course name");
//            System.out.println("3. Course description");
//            System.out.println("4. Credits in ECTS");
//            System.out.println("5. Credits in KZ");
//            System.out.println("6. Course year");
//            System.out.println("7. Course type: 1.Major, 2.Minor, 3.Elective");
//        } else if (Page.language == Language.KZ) {
//            System.out.println("\n=== Add Course Page ===");
//            System.out.println("Write the data in the following order:");
//            System.out.println("1. Course code");
//            System.out.println("2. Course name");
//            System.out.println("3. Course description");
//            System.out.println("4. Credits in ECTS");
//            System.out.println("5. Credits in KZ");
//            System.out.println("6. Course year");
//            System.out.println("7. Course type: 1.Major, 2.Minor, 3.Elective");
//        }
//    }
//
//    @Override
//    public void navigate() {
//    		Scanner sc = new Scanner(System.in);
//    		String code = sc.nextLine();
//    		String name = sc.nextLine();
//    		String desc = sc.nextLine();
//    		int ects = sc.nextInt();
//    		int kz = sc.nextInt();
//    		int year = sc.nextInt();
//    		int type = sc.nextInt();
//    		CourseType ct;
//    		
//    		if(type==1) {
//    			ct = CourseType.MAJOR;
//    		} else if(type==2) {
//    			ct = CourseType.MINOR;
//    		} else {
//    			ct = CourseType.ELECTIVE;
//    		}
//    		
////    		Course c = new Course(code, name, name, name, desc, desc, desc ects, kz, year, ct);
////    		db.addCourse(c);
//    		
//        	new ManageCoursePage().start();
//    }
//
//    @Override
//    public void start() {
//            display();
//            navigate();
//        
//    }
//}