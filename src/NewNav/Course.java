package NewNav;
import java.io.Serializable;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L; // Для сериализации
    private String name;
    private String instructor;
    private int durationInHours;

    public Course(String name, String instructor, int durationInHours) {
        this.name = name;
        this.instructor = instructor;
        this.durationInHours = durationInHours;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }
}
