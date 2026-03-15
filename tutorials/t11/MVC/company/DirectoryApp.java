package company;

import java.util.List;

public class DirectoryApp {
    public static void main(String[] args) {
        EmployeeView view = new EmployeeView();

        Employee e1 = new Employee(1, "Alice Chen",  "Engineering", 85000, "alice@corp.com");
        Employee e2 = new Employee(2, "Bob Martin",  "Engineering",   72000, "bob@corp.com");
        Employee e3 = new Employee(3, "Carol White", "Engineering", 91000, "carol@corp.com");

        EmployeeController c1 = new EmployeeController(e1, view);
        EmployeeController c2 = new EmployeeController(e2, view);
        EmployeeController c3 = new EmployeeController(e3, view);

        c1.displaySummary();
        c1.updateSalary(90000);
        c2.transferDepartment("Marketing");

        System.out.println("=== Summaries ===");
        c1.displaySummary(); c2.displaySummary(); c3.displaySummary();

        System.out.println("\n=== Full records ===");
        c1.displayFull(); c2.displayFull(); c3.displayFull();

        // Optional search
        List<Employee> engTeam = EmployeeController.findByDepartment(
            List.of(e1, e2, e3), "Engineering");
        System.out.println("=== Engineering team ===");
        engTeam.forEach(view::displaySummary);
    }
}
