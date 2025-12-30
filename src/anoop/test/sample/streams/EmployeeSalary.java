package anoop.test.sample.streams;

import java.util.Comparator;
import java.util.List;

public class EmployeeSalary {

    class Employee {
        String id;
        String name;
        int salary;
    }
    public static void main(String[] args) {
        List<Employee> employees = List.of();
        employees.stream().sorted(Comparator.comparing(employee -> employee.salary));
    }
}
