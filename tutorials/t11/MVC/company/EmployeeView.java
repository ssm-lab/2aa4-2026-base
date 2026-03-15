package company;

public class EmployeeView {
    public void displaySummary(Employee e) {
        System.out.println(e.getName() + " | " + e.getDepartment() + " | $" + e.getSalary());
    }

    public void displayFull(Employee e) {
        System.out.println("ID:         " + e.getEmployeeId());
        System.out.println("Name:       " + e.getName());
        System.out.println("Department: " + e.getDepartment());
        System.out.println("Salary:     $" + e.getSalary());
        System.out.println("Email:      " + e.getEmail());
        System.out.println("---");
    }
}

