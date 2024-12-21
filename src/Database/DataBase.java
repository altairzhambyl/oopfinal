package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import OfficeRegistrar.Course;
import Users.*;

public class DataBase implements Serializable {

    private static final long serialVersionUID = 1L;
    public static DataBase INSTANCE;
    private Vector<Course> courses = new Vector<Course>();
    private Vector<User> users = new Vector<User>();
    
    static {
        try {
            if (new File("data").exists()) {
                INSTANCE = readData();
            } else {
                INSTANCE = new DataBase();
            }
        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
            INSTANCE = new DataBase(); // Ensure INSTANCE is always initialized
        }
    }
    
    private DataBase() {
        // Private constructor to enforce singleton pattern
    }
    
    public static DataBase getInstance() throws ClassNotFoundException, IOException {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataBase();
                } else {
                }
            }
        }
        INSTANCE = readData();
        return INSTANCE;
    }
    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized Vector<User> getUsers() {
        return (Vector<User>) users.clone(); // Return a copy to avoid external modification
        
    }
    public synchronized void addCourse(Course course) {
        courses.add(course);
    }
    public synchronized Vector<Course> getCourses() {
        return (Vector<Course>) courses.clone(); // Return a copy to avoid external modification
    }
    public static synchronized void writeData() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data"))) {
            oos.writeObject(INSTANCE);
        }
    }
    private static DataBase readData() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data"))) {
            return (DataBase) ois.readObject();
        }
    }
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE; // Ensure singleton on deserialization
    }
    
   

    
    
    
}
