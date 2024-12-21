package Driver;
import OfficeRegistrar.*;
import Users.*;
import OfficeRegistrar.Course;
import Pages.Navigation;
import Users.*;
import Courses.*;
import Database.DataBase;
import Enums.*;

import java.io.IOException;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		TestUserBase u = TestUserBase.getInstance();
		Student s = new Student("A", "B", "abc");
		u.addUser(s);
		u.printUsers();
		Navigation nav = new Navigation();
	}
}
