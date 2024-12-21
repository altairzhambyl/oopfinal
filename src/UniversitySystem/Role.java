package UniversitySystem;

public enum Role {
 STUDENT,
 TEACHER,
 ADMIN,
 MANAGER
}


//File: interfaces/StudentInterface.java
package UniversitySystem.interfaces;

public interface StudentInterface {
 void viewGrades();
 void enrollInCourse();
 void viewSchedule();
 void submitAssignment();
}

//File: interfaces/TeacherInterface.java
package UniversitySystem.interfaces;

public interface TeacherInterface {
 void gradeAssignments();
 void createCourse();
 void viewStudentList();
 void scheduleClass();
}

//File: interfaces/AdminInterface.java
package UniversitySystem.interfaces;

public interface AdminInterface {
 void manageUsers();
 void generateReports();
 void manageSystem();
 void handleComplaints();
}

//File: interfaces/ManagerInterface.java
package UniversitySystem.interfaces;

public interface ManagerInterface {
 void manageBudget();
 void hireFaculty();
 void reviewDepartments();
 void approveExpenses();
}

//File: users/Student.java
package UniversitySystem.users;

import UniversitySystem.User;
import UniversitySystem.Role;
import UniversitySystem.interfaces.StudentInterface;

public class Student extends User implements StudentInterface {
 private String major;
 private int year;

 public Student(String username, String password, String name, String id, String major, int year) {
     super(username, password, name, id, Role.STUDENT);
     this.major = major;
     this.year = year;
 }

 @Override
 public void viewGrades() {
     System.out.println("Viewing grades for student: " + getName());
 }

 @Override
 public void enrollInCourse() {
     System.out.println("Enrolling in course...");
 }

 @Override
 public void viewSchedule() {
     System.out.println("Viewing schedule for " + getName());
 }

 @Override
 public void submitAssignment() {
     System.out.println("Submitting assignment...");
 }
}

//File: users/Teacher.java
package UniversitySystem.users;

import UniversitySystem.User;
import UniversitySystem.Role;
import UniversitySystem.interfaces.TeacherInterface;

public class Teacher extends User implements TeacherInterface {
 private String department;
 private String[] subjects;

 public Teacher(String username, String password, String name, String id, String department) {
     super(username, password, name, id, Role.TEACHER);
     this.department = department;
 }

 @Override
 public void gradeAssignments() {
     System.out.println("Grading assignments...");
 }

 @Override
 public void createCourse() {
     System.out.println("Creating new course...");
 }

 @Override
 public void viewStudentList() {
     System.out.println("Viewing student list...");
 }

 @Override
 public void scheduleClass() {
     System.out.println("Scheduling class...");
 }
}

//File: users/Admin.java
package UniversitySystem.users;

import UniversitySystem.User;
import UniversitySystem.Role;
import UniversitySystem.interfaces.AdminInterface;

public class Admin extends User implements AdminInterface {
 private String department;
 private String accessLevel;

 public Admin(String username, String password, String name, String id, String accessLevel) {
     super(username, password, name, id, Role.ADMIN);
     this.accessLevel = accessLevel;
 }

 @Override
 public void manageUsers() {
     System.out.println("Managing users...");
 }

 @Override
 public void generateReports() {
     System.out.println("Generating reports...");
 }

 @Override
 public void manageSystem() {
     System.out.println("Managing system...");
 }

 @Override
 public void handleComplaints() {
     System.out.println("Handling complaints...");
 }
}

//File: users/Manager.java
package UniversitySystem.users;

import UniversitySystem.User;
import UniversitySystem.Role;
import UniversitySystem.interfaces.ManagerInterface;

public class Manager extends User implements ManagerInterface {
 private String department;
 private String level;

 public Manager(String username, String password, String name, String id, String department) {
     super(username, password, name, id, Role.MANAGER);
     this.department = department;
 }

 @Override
 public void manageBudget() {
     System.out.println("Managing budget...");
 }

 @Override
 public void hireFaculty() {
     System.out.println("Hiring faculty...");
 }

 @Override
 public void reviewDepartments() {
     System.out.println("Reviewing departments...");
 }

 @Override
 public void approveExpenses() {
     System.out.println("Approving expenses...");
 }
}

//File: UniversitySystem.java
package UniversitySystem;

import UniversitySystem.users.*;
import java.util.*;

public class UniversitySystem {
 private Map<String, User> users;
 private User currentUser;
 private Scanner scanner;

 public UniversitySystem() {
     users = new HashMap<>();
     scanner = new Scanner(System.in);
     initializeUsers();
 }

 private void initializeUsers() {
     // Add some sample users
     addUser(new Student("john.s", "pass123", "John Smith", "S001", "Computer Science", 2));
     addUser(new Teacher("mary.t", "pass456", "Mary Johnson", "T001", "Computer Science"));
     addUser(new Admin("admin1", "admin123", "Admin User", "A001", "Full Access"));
     addUser(new Manager("manager1", "mgr123", "Manager User", "M001", "IT Department"));
 }

 private void addUser(User user) {
     users.put(user.getUsername(), user);
 }

 public void start() {
     while (true) {
         if (currentUser == null) {
             displayLoginMenu();
         } else {
             displayUserMenu();
         }
     }
 }

 private void displayLoginMenu() {
     System.out.println("\n=== University System Login ===");
     System.out.print("Username: ");
     String username = scanner.nextLine();
     System.out.print("Password: ");
     String password = scanner.nextLine();

     User user = users.get(username);
     if (user != null && user.checkPassword(password)) {
         currentUser = user;
         System.out.println("Welcome, " + user.getName() + "!");
     } else {
         System.out.println("Invalid username or password!");
     }
 }

 private void displayUserMenu() {
     System.out.println("\n=== " + currentUser.getRole() + " Menu ===");
     System.out.println("Logged in as: " + currentUser.getName());

     switch (currentUser.getRole()) {
         case STUDENT:
             displayStudentMenu();
             break;
         case TEACHER:
             displayTeacherMenu();
             break;
         case ADMIN:
             displayAdminMenu();
             break;
         case MANAGER:
             displayManagerMenu();
             break;
     }
 }

 private void displayStudentMenu() {
     StudentInterface student = (StudentInterface) currentUser;
     System.out.println("1. View Grades");
     System.out.println("2. Enroll in Course");
     System.out.println("3. View Schedule");
     System.out.println("4. Submit Assignment");
     System.out.println("5. Logout");

     int choice = scanner.nextInt();
     scanner.nextLine(); // Clear buffer

     switch (choice) {
         case 1: student.viewGrades(); break;
         case 2: student.enrollInCourse(); break;
         case 3: student.viewSchedule(); break;
         case 4: student.submitAssignment(); break;
         case 5: logout(); break;
         default: System.out.println("Invalid choice!");
     }
 }

 private void displayTeacherMenu() {
     TeacherInterface teacher = (TeacherInterface) currentUser;
     System.out.println("1. Grade Assignments");
     System.out.println("2. Create Course");
     System.out.println("3. View Student List");
     System.out.println("4. Schedule Class");
     System.out.println("5. Logout");

     int choice = scanner.nextInt();
     scanner.nextLine(); // Clear buffer

     switch (choice) {
         case 1: teacher.gradeAssignments(); break;
         case 2: teacher.createCourse(); break;
         case 3: teacher.viewStudentList(); break;
         case 4: teacher.scheduleClass(); break;
         case 5: logout(); break;
         default: System.out.println("Invalid choice!");
     }
 }

 private void displayAdminMenu() {
     AdminInterface admin = (AdminInterface) currentUser;
     System.out.println("1. Manage Users");
     System.out.println("2. Generate Reports");
     System.out.println("3. Manage System");
     System.out.println("4. Handle Complaints");
     System.out.println("5. Logout");

     int choice = scanner.nextInt();
     scanner.nextLine(); // Clear buffer

     switch (choice) {
         case 1: admin.manageUsers(); break;
         case 2: admin.generateReports(); break;
         case 3: admin.manageSystem(); break;
         case 4: admin.handleComplaints(); break;
         case 5: logout(); break;
         default: System.out.println("Invalid choice!");
     }
 }

 private void displayManagerMenu() {
     ManagerInterface manager = (ManagerInterface) currentUser;
     System.out.println("1. Manage Budget");
     System.out.println("2. Hire Faculty");
     System.out.println("3. Review Departments");
     System.out.println("4. Approve Expenses");
     System.out.println("5. Logout");

     int choice = scanner.nextInt();
     scanner.nextLine(); // Clear buffer

     switch (choice) {
         case 1: manager.manageBudget(); break;
         case 2: manager.hireFaculty(); break;
         case 3: manager.reviewDepartments(); break;
         case 4: manager.approveExpenses(); break;
         case 5: logout(); break;
         default: System.out.println("Invalid choice!");
     }
 }

 private void logout() {
     currentUser = null;
     System.out.println("Logged out successfully!");
 }

 public static void main(String[] args) {
     UniversitySystem system = new UniversitySystem();
     system.start();
 }
}