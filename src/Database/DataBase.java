package Database;

import java.io.*;
import java.util.Vector;

import OfficeRegistrar.Course;
import Users.*;

public class DataBase implements Serializable {

    private static final long serialVersionUID = 1L;
    public static DataBase INSTANCE = null;
    private Vector<Course> courses = new Vector<Course>();
    private Vector<User> users = new Vector<User>();
    private Vector<LogInfo> logs = new Vector<LogInfo>();
    
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
        INSTANCE = readData();

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
    public synchronized void removeUser(User user) {
    	users.remove(user);
        try {
            writeData();
        } catch (IOException e) {
            System.err.println("Failed to write data after removing user: " + e.getMessage());
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
    public synchronized void removeCourse(Course course) {
    	courses.remove(course);

        try {
            writeData();
        } catch (IOException e) {
            System.err.println("Failed to write data after removing course: " + e.getMessage());
        }
    }
    public synchronized Vector<Course> getCourses() {
        return (Vector<Course>) courses.clone(); // Return a copy to avoid external modification
    }
    public synchronized void addLog(LogInfo log) {
        logs.add(log);
        try {
            writeData();
        } catch (IOException e) {
            System.err.println("Failed to write data after adding log info: " + e.getMessage());
        }
    }
    public synchronized void removeLog(LogInfo log) {
    	logs.remove(log);

        try {
            writeData();
        } catch (IOException e) {
            System.err.println("Failed to write data after removing log info: " + e.getMessage());
        }
    }
    public synchronized Vector<Course> getLogs() {
        return (Vector<Course>) logs.clone(); // Return a copy to avoid external modification
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
