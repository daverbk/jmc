import java.util.Random;

public class Student implements Comparable<Student> {
    private static int LAST_ID = 1000;
    private static Random random = new Random();

    private final int id;
    protected final String name;
    protected final double gpa;

    public Student(String name) {
        this.name = name;
        this.id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(id, other.id);
    }
}
