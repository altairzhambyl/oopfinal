package Database;


import java.io.*;
import java.util.Vector;

import Courses.*;
import Notifications.*;
import Research.Research;
import Users.User;

// Define the Database class implementing Serializable
public class DB implements Serializable {

    // Serialization ID for version control
    private static final long serialVersionUID = 1L;

    // Singleton instance
    private static DB instance;

    // Fields to store data
    private Vector<Course> courses = new Vector<>();
    private Vector<User> users = new Vector<>();
    private Vector<LogInfo> logs = new Vector<>();
    private Vector<Message> messages = new Vector<>();
    private Vector<Research> researches = new Vector<>();

    // Private constructor to prevent external instantiation
    private DB() {
        try {
            loadFromFile();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load database from file. Starting with a new instance.");
        }
    }

    // Public method to get the singleton instance
    public static synchronized DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    // Getter for courses
    public Vector<Course> getCourses() {
        return courses;
    }

    // Setter for courses
    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
        autoSave();
    }

    // Getter for users
    public Vector<User> getUsers() {
        return users;
    }
    public User getUserByUsername(String name) {
        for(User u : users) {
        	if(u.getEmail().equals(name)) {
        		return u;
        	}
        }
        return null;
    }

    // Setter for users
    public void setUsers(Vector<User> users) {
        this.users = users;
        autoSave();
    }

    // Getter for logs
    public Vector<LogInfo> getLogs() {
        return logs;
    }

    // Setter for logs
    public void setLogs(Vector<LogInfo> logs) {
        this.logs = logs;
        autoSave();
    }
    
    public Vector<Message> getMessages() {
    	return messages;
    }
    public Vector<Research> getResearches() {
    	return researches;
    }
    // Add a course to the courses vector
    public void addCourse(Course course) {
        this.courses.add(course);
        autoSave();
    }

    // Add a user to the users vector
    public void addUser(User user) {
        this.users.add(user);
        autoSave();
    }

    // Add a log to the logs vector
    public void addLog(LogInfo log) {
        this.logs.add(log);
        autoSave();
    }
    
    public void addMessage(Message message) {
        this.messages.add(message);
        autoSave();
    }
    public void addResearch(Research res) {
        this.researches.add(res);
        autoSave();
    }
    public void removeCourse(Course course) {
        this.courses.remove(course);
        autoSave();
    }

    public void removeUser(User user) {
        this.users.remove(user);
        autoSave();
    }

    public void removeLog(LogInfo log) {
        this.logs.remove(log);
        autoSave();
    }
    
    public void removeMessage(Message message) {
        this.messages.remove(message);
        autoSave();
    }
    public void removeResearch(Research res) {
        this.researches.remove(res);
        autoSave();
    }

    // Method to save the database to a file
    public void saveToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data"))) {
            oos.writeObject(this);
        }
    }

    // Method to load the database from a file
    public static synchronized void loadFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data"))) {
            instance = (DB) ois.readObject();
        }
    }

    private void autoSave() {
        try {
            saveToFile();
        } catch (IOException e) {
            System.err.println("Failed to auto-save the database: " + e.getMessage());
            e.printStackTrace();
        }
    }	
    // Custom toString method for displaying database contents
    @Override
    public String toString() {
        return "DB{" +
                "courses=" + courses +
                ", users=" + users +
                ", logs=" + logs +
                '}';
    }
}