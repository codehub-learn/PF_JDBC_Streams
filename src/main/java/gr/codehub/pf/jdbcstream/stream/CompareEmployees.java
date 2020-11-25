package gr.codehub.pf.jdbcstream.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompareEmployees {

    private static void showEmp(String text, List<Employee> employees) {
        System.out.println("\n=========== " + text + " ============");
        employees.forEach(e -> System.out.println(e.toString()));
    }

    private static void showStr(String text, String value) {
        System.out.println("\n=========== " + text + " ============");
        System.out.println(value);
    }

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("eve2", 1000, 21, today.minusMonths(3));
        employees[1] = new Employee("carol2", 999, 23, today.minusDays(6));
        employees[2] = new Employee("alice2", 1001, 25, today.minusWeeks(7));
        employees[3] = new Employee("bob2", 950, 25, today.minusYears(1));
        employees[4] = new Employee("dave2", 930, 20, today.minusMonths(3).minusYears(1));

        List<Employee> employeeList = Arrays.asList(employees);
        showEmp("Employees", employeeList);

        //sort
        List<Employee> sortedEmployeesBySalary1 = employeeList
                .stream()
                .sorted(Comparator.comparing(e -> e.getSalary()))
                .collect(Collectors.toList());
        showEmp("sortedEmployeesBySalary1", sortedEmployeesBySalary1);

        // another way to write the comparator
        List<Employee> sortedEmployeesBySalary2 = employeeList
                .stream()
                .sorted(Comparator
                        .comparing(Employee::getSalary)
                        .thenComparing(Comparator.comparing(Employee::getAge)))
                .collect(Collectors.toList());
        showEmp("sortedEmployeesBySalary2", sortedEmployeesBySalary2);

        // reverse sort employees
        List<Employee> sortedEmployeesByAgeReversed = employeeList
                .stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .collect(Collectors.toList());
        showEmp("sortedEmployeesByAgeReversed", sortedEmployeesByAgeReversed);

    }
}
