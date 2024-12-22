package Comparators;

import java.util.Comparator;

import Users.Student; 
 
public class StudentGPAComparator implements Comparator<Student> { 
    @Override 
    public int compare(Student s1, Student s2) { 
      
        return Double.compare(s2.getGPA(), s1.getGPA()); 
    } 
}
