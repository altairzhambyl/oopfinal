package OfficeRegistrar;

import java.io.Serializable;
import java.util.ArrayList;

import Enums.CourseType;
import Enums.School;
import Users.Teacher;

public class Course implements Serializable{
	private final String code;
	private String nameKZ;
	private String nameRU;
	private String nameEN;
	
	private String descKZ;
	private String descRU;
	private String descEN;
	
	private int ECTS;
	private int credit;
	
	private int LAB;
	private int LEC;
	private int PRA;
	
	public Course(String c, String n, String d) {
		code = c;
		nameRU = n;
		descRU = d;
	}
	
	public String toString() {
		return code + " " + nameRU + " " + descRU;
	}
}
