package Comparators;

import java.util.Comparator;

import Courses.Course; 
 
public class CourseCreditComparator implements Comparator<Course> { 
 @Override 
    public int compare(Course c1, Course c2) { 
        int creditComparison = Integer.compare(c1.getCourseCreditECTS(), c2.getCourseCreditECTS()); 
        if (creditComparison != 0) { 
            return creditComparison;  
        } 
        return c1.getCourseNameEng().compareTo(c2.getCourseNameEng()); // Если кредиты равны, сравниваем по имени 
    } 
}