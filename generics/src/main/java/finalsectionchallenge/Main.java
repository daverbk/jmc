package finalsectionchallenge;

import finalsectionchallenge.model.LPAStudent;
import finalsectionchallenge.model.Student;
import finalsectionchallenge.model.StudentComparator;
import finalsectionchallenge.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered:");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Query ordered by year started:");
        var queryResult = queryList
                .getMatches("PercentComplete", "50.00")
                .getMatches("Course", "Python");
        queryResult.sort(new StudentComparator());
        printList(queryResult);

        System.out.println("Ordered:");
        queryResult.sort(Comparator.naturalOrder());
        printList(queryResult);
    }

    public static void printList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
