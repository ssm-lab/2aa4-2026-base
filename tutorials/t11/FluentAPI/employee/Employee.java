package FluentAPI.employee;

public class Employee {
    private final String name;
    private final String department;
    private final double salary;
    private final String email;

    public Employee(String name, String department, double salary, String email) {
        this.name = name; this.department = department;
        this.salary = salary; this.email = email;
    }

    public String getName() { 
        return name; 
    }
    public String getDepartment() { 
        return department; 
    }
    public double getSalary() { 
        return salary; 
    }
    public String getEmail() { 
        return email; 
    }
}

