package FluentAPI.employee;

import java.util.*;

public class EmployeePipelineApp {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "Engineering", 95000,  "alice@corp.com"),
            new Employee("Bob",   "Marketing",   55000,  "bob@corp.com"),
            new Employee("Carol", "Engineering", 82000,  "carol@corp.com"),
            new Employee("Dave",  "Engineering", 110000, "dave@corp.com"),
            new Employee("Eve",   "HR",          48000,  "eve@corp.com")
        );

        // a. Names earning > $60k, sorted alphabetically
        List<String> result1 = DataPipeline.from(employees)
            .filter(e -> e.getSalary() > 60000)
            .sortBy(Comparator.comparing(Employee::getName))
            .map(Employee::getName)
            .toList();
        System.out.println("a: " + result1);

        // b. Emails of top 3 highest-paid in Engineering
        List<String> result2 = DataPipeline.from(employees)
            .filter(e -> e.getDepartment().equals("Engineering"))
            .sortBy(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .map(Employee::getEmail)
            .toList();
        System.out.println("b: " + result2);

        // c. First 2 employee names, any department
        List<String> result3 = DataPipeline.from(employees)
            .limit(2)
            .map(Employee::getName)
            .toList();
        System.out.println("c: " + result3);
    }
}
