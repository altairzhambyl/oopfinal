package NewNav;

import java.io.File;
import java.util.*;


import exceptions.*;
import Database.DB;
import Enums.CourseType;
import Enums.School;
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
                System.out.println("Select course by Course code");
                Scanner sc = new Scanner(System.in);
                String code = sc.nextLine();
                try {
                    if (courses == null) {
                        throw new NullMapException("The provided HashMap is null.");
                    }
                	Course c = courses.get(code);
                	System.out.println("Decide changes");
                	System.out.println("1. Change code");
                	System.out.println("2. Change name EN");
                	System.out.println("3. Change name RU");
                	System.out.println("4. Change name KZ");
                	System.out.println("5. Change description");
                	System.out.println("6. Change credits ECTS");
                	System.out.println("7. Change credits KZ");
                	System.out.println("8. Add instructor");
                	System.out.println("9. Remove instructor");
                	System.out.println("10. Change course semester");
                	System.out.println("11. Change course year");
                	System.out.println("12. Change course type");
                	System.out.println("13. Change course school");
                	int choice2 = getUserChoice();
                	switch(choice2) {
                		case 1:
                			System.out.println("Enter the code");
                			String newcode = sc.nextLine();
                			c.setCourseCode(newcode);
                		case 2:
                			System.out.println("Enter the name EN");
                			String newnameEN = sc.nextLine();
                			c.setCourseNameEng(newnameEN);
                		case 3:
                			System.out.println("Enter the name RU");
                			String newnameRU = sc.nextLine();
                			c.setCourseNameRus(newnameRU);
                		case 4:
                			System.out.println("Enter the name KZ");
                			String newnameKZ = sc.nextLine();
                			c.setCourseNameKaz(newnameKZ);
                		case 5:
                			System.out.println("Enter new description");
                			String newdesc = sc.nextLine();
                			c.setCourseDescription(newdesc);
                		case 6:
                			System.out.println("Enter the name RU");
                			int ects = getUserChoice();
                			c.setCourseCreditECTS(ects);
                		case 7:
                			System.out.println("Enter the name RU");
                			int kz = getUserChoice();
                			c.setCourseCreditKZ(kz);
                		case 8:
                			System.out.println("Enter the Instructor's email:");
                			String username = scanner.nextLine();
                	        User u = users.get(username);
                	        if (u != null && u instanceof Teacher teacher) {	
                	        	c.addInstructor(teacher);              	        	
                	        } else {
                	        	System.out.println("Enter the Instructor's firstname:");
                	        	String fn = sc.nextLine();
                	        	System.out.println("Enter the Instructor's lastname:");
                	        	String ln = sc.nextLine();
                	        	Teacher t = new Teacher(fn, ln, username);
                	        	c.addInstructor(t);
                	        }
                		case 9:
                			System.out.println("Enter the Instructor's email:");
                			String uname = scanner.nextLine();
                	        User ii = users.get(uname);
                	        if (ii != null && ii instanceof Teacher teachr && c.getCourseInstructor().contains(ii)) {
                	        	c.removeInstructor(teachr);              	        	
                	        } else {
                	        	System.out.println("The instructor does not exist");
                	        }
                		case 10:
                			System.out.println("Enter the new course semester:");
                			String sem = scanner.nextLine();
                	        c.setCourseSemester(sem);
                		case 11:
                			System.out.println("Enter the new course year:");
                			String y = scanner.nextLine();
                	        c.setCourseYear(y);
                		case 12:
                			System.out.println("Enter the new course type:");
                			System.out.println("1. Major");
                			System.out.println("2. Minor");
                			System.out.println("3. Elective");
                			CourseType ctt;
                			int ct = getUserChoice();
                			switch(ct) {
                				case 1:
                					ctt = CourseType.MAJOR;
                				case 2:
                					ctt = CourseType.MINOR;
                				default:
                					ctt = CourseType.ELECTIVE;
                			}
                			c.setCourseType(ctt);
                		case 13:
                			System.out.println("Enter the new course school:");
                			System.out.println("1. SITE");
                			System.out.println("2. BS");
                			System.out.println("3. LSE");
                			School ttt;
                			int tt = getUserChoice();
                			switch(tt) {
                				case 1:
                					ttt = School.SITE;
                				case 2:
                					ttt = School.BS;
                				default:
                					ttt = School.SITE;
                			}
                			c.setCourseSchool(ttt);
                	}
                  } catch (NullMapException e) {
                	System.out.println("No courses available");
                }
                
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