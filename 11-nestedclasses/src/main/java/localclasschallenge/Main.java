package localclasschallenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Minnie", "Mouse", "01/02/2015"),
                new Employee("Mickie", "Mouse", "05/08/2000"),
                new Employee("Daffy", "Duck", "11/02/2011"),
                new Employee("Daisy", "Duck", "05/03/2013"),
                new Employee("Goofy", "Dog", "23/07/2020")
        ));

        System.out.println("Sorted by full name");
        printOrderedList(employees, "name");
        System.out.println("Sorted by years worked");
        printOrderedList(employees, "yearsWorked");
    }

    public static void printOrderedList(List<Employee> employees, String sortedField) {
        int currentYear = LocalDate.now().getYear();

        class WrappedEmployee {
            private Employee originalEmployee;
            private String fullName;
            private int yearsWorked;

            public WrappedEmployee(Employee originalEmployee) {
                this.originalEmployee = originalEmployee;
                this.fullName = String.join(" ", originalEmployee.first(), originalEmployee.second());
                this.yearsWorked = currentYear - Integer.parseInt(originalEmployee.hireDate().split("/")[2]);
            }

            @Override
            public String toString() {
                return "%s has benn an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<WrappedEmployee> wrappedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            wrappedEmployees.add(new WrappedEmployee(employee));
        }

        wrappedEmployees.sort((o1, o2) -> {
            if (sortedField.equalsIgnoreCase("name")) {
                return o1.fullName.compareTo(o2.fullName);
            }
            return Integer.compare(o1.yearsWorked, o2.yearsWorked);
        });

        for (WrappedEmployee wrappedEmployee : wrappedEmployees) {
            System.out.println(wrappedEmployee);
        }
    }
}
