// Base class representing an employee
public abstract class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public abstract double calculateWeeklySalary();

    public abstract void displayEmployeeDetails();

    public abstract double calculateBonus();
    // Method to calculate the annual earnings, combining weekly salary and bonus
    public double calculateAnnualEarnings() {
        return calculateWeeklySalary() * 52 + calculateBonus();
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    // Method to calculate the weekly salary for an hourly employee
    @Override
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Employee Name: " + getEmployeeName());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Hourly Rate: " + getHourlyRate());
        System.out.println("Hours Worked: " + getHoursWorked());
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
    // Method to calculate the bonus for an hourly employee
    @Override
    public double calculateBonus() {
        return 0; // No bonus for hourly employees
    }
}
// Class representing a salaried employee, extending the Employee class
class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Employee Name: " + getEmployeeName());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Monthly Salary: " + getMonthlySalary());
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
    // Method to calculate the bonus for a salaried employee
    @Override
    public double calculateBonus() {
        return monthlySalary * 0.1; // 10% of monthly salary as bonus
    }
}

// Class representing an executive employee, extending the SalariedEmployee class
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }
    // Method to calculate the bonus for an executive employee
    @Override
    public double calculateBonus() {
        return super.calculateBonus() * bonusPercentage;
    }

    @Override
    public double calculateWeeklySalary() {
        // Adjusted weekly salary for executives (considering bonus)
        return super.calculateWeeklySalary() + calculateBonus() / 4;
    }
}

// Main class for testing
class Main {
    public static void main(String[] args) {
        Employee hourlyEmployee = new HourlyEmployee(1, "prabu", "Hourly Employee", 10, 40);
        hourlyEmployee.displayEmployeeDetails();
        System.out.println("Annual Earnings: " + hourlyEmployee.calculateAnnualEarnings());

        Employee salariedEmployee = new SalariedEmployee(2, "senthiLnathan", "Salaried Employee", 5000);
        salariedEmployee.displayEmployeeDetails();
        System.out.println("Annual Earnings: " + salariedEmployee.calculateAnnualEarnings());

        Employee executiveEmployee = new ExecutiveEmployee(3, "helen", "Executive Employee", 8000, 0.15);
        executiveEmployee.displayEmployeeDetails();
        System.out.println("Annual Earnings: " + executiveEmployee.calculateAnnualEarnings());
    }
}
