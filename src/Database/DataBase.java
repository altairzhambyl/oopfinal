package Database;

import java.io.*;
import java.util.ArrayList;

import OfficeRegistrar.Course;

public class DataBase<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static DataBase INSTANCE;
    private ArrayList<T> arrayList = new ArrayList<>();
 
    
    protected DataBase() {
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

    public synchronized void addToList(T data) {
        arrayList.add((T) data);
    }

    public synchronized ArrayList<T> getList() {
        return new ArrayList<T>(arrayList); // Return a copy to avoid external modification
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
