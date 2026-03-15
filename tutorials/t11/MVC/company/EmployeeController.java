package company;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void updateSalary(double salary) { model.setSalary(salary); }
    public void transferDepartment(String dept) { model.setDepartment(dept); }

    public void displaySummary() { view.displaySummary(model); }
    public void displayFull() { view.displayFull(model); }

    // Optional
    public static List<Employee> findByDepartment(List<Employee> employees, String dept) {
        return employees.stream()
            .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
            .collect(Collectors.toList());
    }
}