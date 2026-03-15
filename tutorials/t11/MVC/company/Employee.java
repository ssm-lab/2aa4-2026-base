package company;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double salary;
    private String email;

    public Employee(int employeeId, String name, String department, double salary, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public int getEmployeeId() { 
        return employeeId; 
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
    public void setSalary(double salary) { 
        this.salary = salary; 
    }
    public void setDepartment(String department) { 
        this.department = department; 
    }
}
