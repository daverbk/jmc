package setsmaps.sortedmaps;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {
        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);

        addPurchase("Chuck Cheese", python, 119.99);
        addPurchase("Davey Jones", python, 1339.99);
        addPurchase("Eva East", python, 139.99);
        addPurchase("Fred Forker", python, 139.99);
        addPurchase("Greg Brady", python, 129.99);

        purchases.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("_".repeat(50));
        students.forEach((k, v) -> System.out.println(k + " : " + v));

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();

        for (Purchase p : purchases.values()) {
            datedPurchases.compute(p.purchaseDate(), (pdate, plist) -> {
                List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                list.add(p);
                return list;
            });
        }

        datedPurchases.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void addPurchase(String name, Course course, double price) {

        Student existingStudent = students.get(name);
        if (existingStudent == null) {
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);
        } else {
            existingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1, 5);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);
    }
}
