package Database;


import java.io.File;
import java.io.IOException;

import Users.*;


public class tester {

    public static void main(String[] args) {
    	try {
            Teacher t = new Teacher("Second", "Last", "567@kbtu.kz");
            Admin a = new Admin("Admin", "admin", "admin@kbtu.kz");
            
            
            if (new File("data").isFile()) {
            	DB.loadFromFile();
            }
            DB loadeddb = DB.getInstance();

//			LogInfo log = new LogInfo(t, "Added new user to database");
//			System.out.println(log);
//			loadeddb.addLog(log);
//            loadeddb.addUser(a);
//            a.addUser(t);
            
            System.out.println(loadeddb);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
