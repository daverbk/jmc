package finalsectionchallenge.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getYearStarted(), s2.getYearStarted());
    }
}
