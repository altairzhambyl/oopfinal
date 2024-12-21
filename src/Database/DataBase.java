package Database;

import java.io.*;
import java.util.ArrayList;

import OfficeRegistrar.Course;
import Users.*;

public class DataBase implements Serializable {
    private static final long serialVersionUID = 1L;
    public static DataBase INSTANCE;
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    
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
    
    public static DataBase getInstance() {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataBase();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized void addCourse(Course course) {
        courses.add(course);
    }

    public synchronized ArrayList<Course> getCourses() {
        return new ArrayList<>(courses); // Return a copy to avoid external modification
    }
    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized ArrayList<User> getUsers() {
        return new ArrayList<>(users); // Return a copy to avoid external modification
    }
    public static synchronized void writeData() throws IOException {
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data"))) {
            oos.writeObject(INSTANCE);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
            throw e;
        }
    }

    private static DataBase readData() throws IOException, ClassNotFoundException {
    	System.out.println("Attempting to read data from file...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data"))) {
            DataBase db = (DataBase) ois.readObject();
            System.out.println("Data successfully loaded from file.");
            return db;
        } catch (FileNotFoundException e) {
            System.out.println("No existing data file found.");
            return new DataBase();
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE; // Ensure singleton on deserialization
    }
}
