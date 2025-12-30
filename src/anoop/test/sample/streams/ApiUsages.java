package anoop.test.sample.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApiUsages {
    record Employee(int id, String name, String deptId, int salary){}

    private static List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,14,15);
    private static List<String> strings = List.of("a", "b", "c", "d", "ab", "abc", "abcd", "e", "abcde");
    private static List<Employee> records = List.of(
            new Employee(1, "abc", "dept1", 2500),
            new Employee(2, "def", "dept2", 1500),
            new Employee(3, "ghij", "dept3", 5000),
            new Employee(4, "klm", "dept1", 2000),
            new Employee(5, "nop", "dept2", 1500),
            new Employee(6, "qrs", "dept3", 1000),
            new Employee(7, "tuv", "dept1", 3500),
            new Employee(8, "wxyz", "dept2", 4000),
            new Employee(9, "abc", "dept3", 3000),
            new Employee(10, "def", "dept1", 3500)
    );

    public static void main(String[] args) {
        intListProcess();
        stringListProcess();
        recordListProcess();
    }

    private static void intListProcess() {
        //Filter even numbers
        List<Integer> evens = numbers.stream()
                .filter(i -> i%2 == 0)
                .toList();
        System.out.println("Even numbers: " + evens);

        // Count elements > 10
        long count = numbers.stream()
                .filter(i -> i>10)
                .count();
        System.out.println("Count: " + count);

        // sum all numbers
        long sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);

        // Remove duplicates
        List<Integer> distList = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Remove duplicates: " + distList);

        // Find max number
        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("Max: " + max);

        // Find duplicate numbers
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) > 1) // O(N * N)
                .collect(Collectors.toSet());
        System.out.println("Duplicate numbers: " + duplicates);

        Set<Integer> seen = new HashSet<>();
        duplicates = numbers.stream()
                        .filter(n -> !seen.add(n))
                        .collect(Collectors.toSet());
        System.out.println("Duplicate numbers(Using cache): " + duplicates);

        // Group numbers by even and odd
        Map<Integer, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2));
        System.out.println("Group numbers by even and odd: " + evenOddMap);

        // Partition numbers by even and odd
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partition numbers by even and odd: " + evenOddPartition);

        // Second highest number
        int number = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Second highest: " + number);

        // Check if all numbers are positive
        boolean isAllPositive = numbers.stream()
                .allMatch(integer -> integer > 0);
        System.out.println("All positive: " + isAllPositive);
    }

    private static void stringListProcess() {
        // To upper cases
        List<String> upperCases = strings.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Upper cases: " + upperCases);

        // Sort string by length
        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println("Sort string by length: " + sorted);

        // List string first element starting with "a"
        List<String> listWithA = strings.stream()
                .filter(s -> s.startsWith("a"))
                .toList();
        System.out.println("Starting with \"a\":" + listWithA);

        // Group string by length
        Map<Integer, List<String>> grouped = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Group string by length: " + grouped);

        // Join strings with comma
        String allStrings = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Join strings with comma: " + allStrings);
        System.out.println("Join strings with comma(2): " + String.join(", ", strings));

        // Count occurrences of each string
        Map<String, Long> occurrences = strings.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("Occurrences of each string: " + occurrences);
    }

    private static void recordListProcess() {
        // convert list to map id --> name
        Map<Integer, String> listMap = records.stream()
                .collect(Collectors.toMap(Employee::id, Employee::name));
        System.out.println("Convert list to map: " + listMap);

        // Group record by name length
        Map<Integer, List<Employee>> grouped = records.stream()
                .collect(Collectors.groupingBy(o -> o.name.length()));
        System.out.println("Group record by name length: " + grouped);

        // Highest paid employee per department
        Map<String, Optional<Employee>> highestPaid = records.stream()
                .collect(Collectors.groupingBy(
                        Employee::deptId,
                        Collectors.maxBy(
                                Comparator.comparingInt(Employee::salary)
                        )
                )); // Missing one employee where more than one highest salary in one dept
        System.out.println("Highest paid employee per department: " + highestPaid);

        // Count occurrences of each name
        Map<String, Long> occurrences = records.stream()
                .collect(Collectors.groupingBy(
                        Employee::name,
                        Collectors.counting()
                ));
        System.out.println("Occurrences of each name: " + occurrences);

        // Find average salary
        double average = records.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0);
        System.out.println("Average salary: " + average);
    }
}
