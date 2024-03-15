package setsmaps.setchallenge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Task> allTasks = TaskData.getTasks("all");
        sortAndPrint("All tasks", allTasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's tasks", bobsTasks, sortByPriority);

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        sortAndPrint("Carol's tasks", carolsTasks, sortByPriority);

        // Challenge
        Set<Task> allAssignedTasks = getUnion(List.of(annsTasks, bobsTasks, carolsTasks));

        // Full list of tasks
        Set<Task> union = getUnion(List.of(allTasks, annsTasks, bobsTasks, carolsTasks));
        sortAndPrint("Union of all tasks", union, sortByPriority);

        // Which tasks are assigned to at least one of 3 employees
        Set<Task> tasksAssignedToAtLeastOne = getIntersect(allAssignedTasks, allTasks);
        sortAndPrint("Tasks assigned to at least one of Ann, Bob, and Carol", tasksAssignedToAtLeastOne, sortByPriority);

        // Tasks still need to be assigned
        Set<Task> notAssignedTasks = getDifference(allTasks, allAssignedTasks);
        sortAndPrint("Tasks not assigned", notAssignedTasks, sortByPriority);

        // Tasks assigned to multiple employees
        Set<Task> taskAssignedToMultipleEmployees = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(bobsTasks, carolsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Tasks assigned to Ann, Bob, and Carol", taskAssignedToMultipleEmployees, sortByPriority);

        // Tasks assigned to multiple employees for each employee assigned
        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> taskSet : List.of(annsTasks, bobsTasks, carolsTasks)) {
            overlapping.addAll(getIntersect(taskSet, taskAssignedToMultipleEmployees));
        }
        sortAndPrint("Tasks assigned to each Ann, Bob, and Carol", overlapping, sortByPriority);
    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> taskSets) {
        Set<Task> union = new HashSet<>();

        for (Set<Task> taskSet : taskSets) {
            union.addAll(taskSet);
        }

        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);

        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> difference = new HashSet<>(a);
        difference.removeAll(b);

        return difference;
    }
}
