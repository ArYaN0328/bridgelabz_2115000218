
  import java.io.*;
import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

public class EmployeeGrouper {
    public static void main(String[] args) {
        // Sample employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR"),
            new Employee("Dave", "Finance")
        );

        // Group employees by department
        Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        // Print the grouped employees
        groupedByDepartment.forEach((dept, empList) ->
            System.out.println(dept + ": " + empList)
        );
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee employee : employees) {
            grouped.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }

        return grouped;
    }
}


