package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import OfficeRegistrar.Course;
import Users.*;

public class DataBase implements Serializable {

    private static final long serialVersionUID = 1L;
    public static DataBase INSTANCE = null;
    private Vector<Course> courses = new Vector<Course>();
    private Vector<User> users = new Vector<User>();
    
    static {
        try {
            File dataFile = new File("data");
            if (dataFile.exists()) {
                INSTANCE = readData();
            } else {
                INSTANCE = new DataBase();
            }
        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
            INSTANCE = new DataBase();
        }
    }

    
    private DataBase() {
        // Private constructor to enforce singleton pattern
    }
    
    public static DataBase getInstance() throws ClassNotFoundException, IOException {
        if (INSTANCE == null) {
        	INSTANCE = new DataBase();
        }
<<<<<<< HEAD
        INSTANCE = readData();
=======
        System.out.println(new File("data").getAbsolutePath());

>>>>>>> 72688a717f77500995ce0d31d80296cdee44f99a
        return INSTANCE;
    }
    public synchronized void addUser(User user) {
        users.add(user);
        try {
            writeData();
        } catch (IOException e) {
            System.err.println("Failed to write data after adding user: " + e.getMessage());
        }
    }

    public synchronized Vector<User> getUsers() {
        return (Vector<User>) users.clone(); // Return a copy to avoid external modification
        
    }
    public synchronized void addCourse(Course course) {
        courses.add(course);
        try {
            writeData();
        } catch (IOException e) {
            System.err.println("Failed to write data after adding course: " + e.getMessage());
        }
    }
    public synchronized Vector<Course> getCourses() {
        return (Vector<Course>) courses.clone(); // Return a copy to avoid external modification
    }
    public static synchronized void writeData() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data"))) {
            oos.writeObject(INSTANCE);
        }
    }
    public static DataBase readData() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data"))) {
            return (DataBase) ois.readObject();
        }
    }
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE; // Ensure singleton on deserialization
    }
    
   

    
    
    
}
