package Courses ;
import java.util.*;

import Enums.AttendanceStatus;
import Enums.LessonType;
import Users.Student;
import Users.Teacher;

public class Lesson {
    private int week;
    private String topic;
    private ArrayList<Student> students;
    private HashMap<Student, AttendanceStatus> lessonAttendance;
    private HashMap<Student, Integer> lessonGrade;
    private Course lessonCourse;
    private Teacher lessonTeacher;
    private Date lessonDate;
    private String lessonRoom;
    private LessonType lessonType; //lecture, practice, lab
    private String lessonBeginTime;
    private String lessonEndTime;
    private String lessonDuration;

    public Lesson(){
    }

    public Lesson(int week, String topic, ArrayList<Student> students, HashMap<Student, AttendanceStatus> attendance, HashMap<Student, Integer> grade, Course course, Teacher teacher, Date date, String room, LessonType type, String beginTime, String endTime, String duration){
        this.week = week;
        this.topic = topic;
        this.students = students;
        this.lessonAttendance = attendance;
        this.lessonGrade = grade;
        this.lessonCourse = course;
        this.lessonTeacher = teacher;
        this.lessonDate = date;
        this.lessonRoom = room;
        this.lessonType = type;
        this.lessonBeginTime = beginTime;
        this.lessonEndTime = endTime;
        this.lessonDuration = duration;
    }

    public int getWeek(){
        return this.week;
    }
    public void setWeek(int week){
        this.week = week;
    }
    public String getTopic(){
        return this.topic;
    }
    public void setTopic(String topic){
        this.topic = topic;
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }
    public HashMap<Student, AttendanceStatus> getLessonAttendance(){
        return this.lessonAttendance;
    }
    public void setLessonAttendance(HashMap<Student, AttendanceStatus> attendance){
        this.lessonAttendance = attendance;
    }
    public HashMap<Student, Integer> getLessonGrade(){
        return this.lessonGrade;
    }
    public void setLessonGrade(HashMap<Student, Integer> grade){
        this.lessonGrade = grade;
    }
    public Course getLessonCourse(){
        return this.lessonCourse;
    }
    public void setLessonCourse(Course course){
        this.lessonCourse = course;
    }
    public Teacher getLessonTeacher(){
        return this.lessonTeacher;
    }
    public void setLessonTeacher(Teacher teacher){
        this.lessonTeacher = teacher;
    }
    public Date getLessonDate(){
        return this.lessonDate;
    }
    public void setLessonDate(Date date){
        this.lessonDate = date;
    }
    public String getLessonRoom(){
        return this.lessonRoom;
    }
    public void setLessonRoom(String room){
        this.lessonRoom = room;
    }
    public LessonType getLessonType(){
        return this.lessonType;
    }
    public void setLessonType(LessonType type){
        this.lessonType = type;
    }
    public String getLessonBeginTime(){
        return this.lessonBeginTime;
    }
    public void setLessonBeginTime(String beginTime){
        this.lessonBeginTime = beginTime;
    }
    public String getLessonEndTime(){
        return this.lessonEndTime;
    }
    public void setLessonEndTime(String endTime){
        this.lessonEndTime = endTime;
    }
    public String getLessonDuration(){
        return this.lessonDuration;
    }
    public void setLessonDuration(String duration){
        this.lessonDuration = duration;
    }
    @Override
    public int hashCode() {
        return Objects.hash(lessonAttendance, lessonBeginTime, lessonCourse, lessonDate, lessonDuration, lessonEndTime, lessonGrade, lessonRoom, lessonTeacher, lessonType, students, topic, week);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lesson other = (Lesson) obj;
        return Objects.equals(lessonAttendance, other.lessonAttendance) && Objects.equals(lessonBeginTime, other.lessonBeginTime)
                && Objects.equals(lessonCourse, other.lessonCourse) && Objects.equals(lessonDate, other.lessonDate)
                && Objects.equals(lessonDuration, other.lessonDuration) && Objects.equals(lessonEndTime, other.lessonEndTime)
                && Objects.equals(lessonGrade, other.lessonGrade) && Objects.equals(lessonRoom, other.lessonRoom)
                && Objects.equals(lessonTeacher, other.lessonTeacher) && lessonType == other.lessonType
                && Objects.equals(students, other.students) && Objects.equals(topic, other.topic) && week == other.week;
    }
    @Override
    public String toString() {
        return "Lesson [lessonAttendance=" + lessonAttendance + ", lessonBeginTime=" + lessonBeginTime + ", lessonCourse="
                + lessonCourse + ", lessonDate=" + lessonDate + ", lessonDuration=" + lessonDuration + ", lessonEndTime="
                + lessonEndTime + ", lessonGrade=" + lessonGrade + ", lessonRoom=" + lessonRoom + ", lessonTeacher="
                + lessonTeacher + ", lessonType=" + lessonType + ", students=" + students + ", topic=" + topic + ", week="
                + week + "]";
    }
}