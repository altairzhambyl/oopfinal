package Database;

import java.io.*;
import java.util.ArrayList;

import OfficeRegistrar.Course;

public class DataBase implements Serializable {
    private static final long serialVersionUID = 1L;
    public static DataBase INSTANCE;
    private ArrayList<Course> courses = new ArrayList<>();
    
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
