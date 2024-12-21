package Courses;

import java.util.*;

import Enums.CourseType;
import Enums.School;
import Users.Teacher;

public class Course {
    private String courseCode;
    private String courseNameEng;
    private String courseNameRus;
    private String courseNameKaz;
    private String courseDescription;
    private int courseCreditECTS;
    private int courseCreditKZ;
    private ArrayList<Teacher> courseInstructor;
    private String courseSemester;
    private String courseYear;
    private CourseType courseType;
    private School courseSchool;

    public Course(){
    }

    public Course(String code, String nameEng, String nameRus, String nameKaz, String description, int creditECTS, int creditKZ, ArrayList<Teacher> instructor, String semester, String year, CourseType type, School school){
        this.courseCode = code;
        this.courseNameEng = nameEng;
        this.courseNameRus = nameRus;
        this.courseNameKaz = nameKaz;
        this.courseDescription = description;
        this.courseCreditECTS = creditECTS;
        this.courseCreditKZ = creditKZ;
        this.courseInstructor = instructor;
        this.courseSemester = semester;
        this.courseYear = year;
        this.courseType = type;
        this.courseSchool = school;
    }

    public String getCourseCode(){
        return this.courseCode;
    }
    public void setCourseCode(String code){
        this.courseCode = code;
    }
    public String getCourseNameEng(){
        return this.courseNameEng;
    }
    public void setCourseNameEng(String name){
        this.courseNameEng = name;
    }
    public String getCourseNameRus(){
        return this.courseNameRus;
    }
    public void setCourseNameRus(String name){
        this.courseNameRus = name;
    }
    public String getCourseNameKaz(){
        return this.courseNameKaz;
    }
    public void setCourseNameKaz(String name){
        this.courseNameKaz = name;
    }
    public String getCourseDescription(){
        return this.courseDescription;
    }
    public void setCourseDescription(String description){
        this.courseDescription = description;
    }
    public int getCourseCreditECTS(){
        return this.courseCreditECTS;
    }
    public void setCourseCreditECTS(int credit){
        this.courseCreditECTS = credit;
    }
    public int getCourseCreditKZ(){
        return this.courseCreditKZ;
    }
    public void setCourseCreditKZ(int credit){
        this.courseCreditKZ = credit;
    }
    public ArrayList<Teacher> getCourseInstructor(){
        return this.courseInstructor;
    }
    public void setCourseInstructor(ArrayList<Teacher> instructor){
        this.courseInstructor = instructor;
    }
    public String getCourseSemester(){
        return this.courseSemester;
    }
    public void setCourseSemester(String semester){
        this.courseSemester = semester;
    }
    public String getCourseYear(){
        return this.courseYear;
    }
    public void setCourseYear(String year){
        this.courseYear = year;
    }
    public CourseType getCourseType(){
        return this.courseType;
    }
    public void setCourseType(CourseType type){
        this.courseType = type;
    }
    public School getCourseSchool(){
        return this.courseSchool;
    }

    public void setCourseSchool(School school){
        this.courseSchool = school;
    }

    public void addInstructor(Teacher teacher){
        this.courseInstructor.add(teacher);
    }
    public void removeInstructor(Teacher teacher){
        this.courseInstructor.remove(teacher);
    }
    public void clearInstructors(){
        this.courseInstructor.clear();
    }
    public void printInstructors(){
        for (Teacher t : this.courseInstructor){
            System.out.println(t.getFirstName());
        }
    }
    //tostring, equals, hashcode
    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseNameEng, courseNameRus, courseNameKaz, courseDescription, courseCreditECTS, courseCreditKZ, courseInstructor, courseSemester, courseYear, courseType, courseSchool);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        return Objects.equals(courseCode, other.courseCode) && courseCreditECTS == other.courseCreditECTS
                && courseCreditKZ == other.courseCreditKZ && Objects.equals(courseDescription, other.courseDescription)
                && Objects.equals(courseInstructor, other.courseInstructor)
                && Objects.equals(courseNameEng, other.courseNameEng) && Objects.equals(courseNameKaz, other.courseNameKaz)
                && Objects.equals(courseNameRus, other.courseNameRus) && Objects.equals(courseSchool, other.courseSchool)
                && Objects.equals(courseSemester, other.courseSemester) && Objects.equals(courseType, other.courseType)
                && Objects.equals(courseYear, other.courseYear);
    }
    @Override
    public String toString() {
        return "Course [courseCode=" + courseCode + ", courseCreditECTS=" + courseCreditECTS + ", courseCreditKZ="
                + courseCreditKZ + ", courseDescription=" + courseDescription + ", courseInstructor=" + courseInstructor
                + ", courseNameEng=" + courseNameEng + ", courseNameKaz=" + courseNameKaz + ", courseNameRus="
                + courseNameRus + ", courseSchool=" + courseSchool + ", courseSemester=" + courseSemester + ", courseType="
                + courseType + ", courseYear=" + courseYear + "]";
    }
}