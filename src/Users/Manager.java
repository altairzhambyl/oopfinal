package Users; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Collections; 
import java.util.Date; 
import Notifications.News; 
import Courses.Course; 
import Enums.ManagerType; 
import Comparators.*;
public class Manager extends Employee { 
    private List<Student> students = new ArrayList<>(); 
    private List<Teacher> teachers = new ArrayList<>(); 
    private List<Course> courses = new ArrayList<>(); 
 // Метод для одобрения регистрации студентов 
	 public void approveStudentsRegistration(String studentId) { 
	        for (Student student : students) { 
	            if (student.getUserId().equals(studentId)) { 
	                System.out.println("Registration for a student " + student + " approved."); 
	                return; 
	            }} 
	        System.out.println("Student with ID " + studentId + " not found."); 
	    }// Добавить курсы для регистрации 
	 public void addCoursesForRegistration (String courseName, String major, int yearOfStudy){ 
	  System.out.println("Course '" + courseName + "' added for major '" + major + "' in year " + yearOfStudy + "."); 
	 } 
 // Присвоить курс учителю 
    public void assignCourseToTeacher(String courseCode, String teacherId) { 
        Course course = findCourseCode(courseCode); 
        Teacher teacher = findTeacherById(teacherId); 
 
        if (course != null && teacher != null) { 
            course.addInstructor(teacher); 
            System.out.println("Course '" + course.getCourseCode() + "' assigned to teacher '" + teacher.getLastName() + " " + teacher.getFirstName() + "'."); 
        } else { 
          throw new IllegalArgumentException("Course or Teacher is not found"); 
        } 
    } 
     
    private Teacher findTeacherById(String teacherId) { 
        for (Teacher teacher : teachers) { 
            if (teacher.getUserId().equals(teacherId)) { 
                return teacher; 
            } 
        } 
        throw new IllegalArgumentException("Teacher " + teacherId + " is not found."); 
    } 
 
    private Course findCourseCode(String courseCode) { 
        for (Course course : courses) { 
            if (course.getCourseCode().equals(courseCode)) { 
                return course; 
            } 
        } 
        throw new IllegalArgumentException("Course " + courseCode + " is not found."); 
    } 
    public ManagerType managertype; 
    // Статистический репорт (сортировка студентов по GPA) 
	 public void createStatisticalReport(){ 
	        if (students.isEmpty()) { 
	            System.out.println("No students available."); 
	            return; 
	        } 
	         
	        Collections.sort(students, new StudentGPAComparator()); 
	 
	        System.out.println("Students sorted by GPA (highest to lowest):"); 
	        for (Student student : students) { 
	            System.out.println("Name: " + student.getLastName() + " " + student.getFirstName() + 
	                               ", GPA: " + student.getGPA()); 
	        }} 
 // Список для хранения новостей 
    private List<News> newsList = new ArrayList<>(); 
    // Метод для добавления новости 
    public void addNews(int newsId, String newsHeadline, String newsContent, Date newsDate, String newsAuthor) { 
        News news = new News(newsId, newsHeadline, newsContent, newsDate, newsAuthor); 
        newsList.add(news); 
        System.out.println("News added: " + newsHeadline); 
    } 
    public void viewAllNews() { 
        if (newsList.isEmpty()) { 
            System.out.println("No news."); 
            return; 
        } 
        System.out.println("All News:"); 
        for (News news : newsList) { 
            System.out.println(news); 
        } 
    } 
    // Метод для просмотра информации о преподавателях и студентах 
    public void viewInfo(List<String> students, List<String> teachers) { 
        System.out.println("Students' list:"); 
        for (String student : students) { 
            System.out.println("- " + student); 
        } 
        System.out.println("Teachers' list:"); 
        for (String teacher : teachers) { 
            System.out.println("- " + teacher); 
        }}}
