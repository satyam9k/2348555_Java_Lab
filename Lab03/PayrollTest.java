public class PayrollTest {
    public static void main(String[] args) {
        // Test HourlyEmployee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "prabu", "Hourly Worker", 15.0, 40);
        hourlyEmployee.displayEmployeeDetails();
        System.out.println("Weekly Salary: " + hourlyEmployee.calculateWeeklySalary());
        System.out.println("Bonus: " + hourlyEmployee.calculateBonus());
        System.out.println("Annual Earnings: " + hourlyEmployee.calculateAnnualEarnings());
        System.out.println();

        // Test SalariedEmployee
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "senthilnathan", "Manager", 6000.0);
        salariedEmployee.displayEmployeeDetails();
        System.out.println("Weekly Salary: " + salariedEmployee.calculateWeeklySalary());
        System.out.println("Bonus: " + salariedEmployee.calculateBonus());
        System.out.println("Annual Earnings: " + salariedEmployee.calculateAnnualEarnings());
        System.out.println();

        // Test ExecutiveEmployee
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "helen", "Executive", 10000.0, 0.15);
        executiveEmployee.displayEmployeeDetails();
        System.out.println("Weekly Salary: " + executiveEmployee.calculateWeeklySalary());
        System.out.println("Bonus: " + executiveEmployee.calculateBonus());
        System.out.println("Annual Earnings: " + executiveEmployee.calculateAnnualEarnings());
        System.out.println();

        // Display total payroll
        displayTotalPayroll(hourlyEmployee, salariedEmployee, executiveEmployee);
    }

    // Display total payroll for all employees
    private static void displayTotalPayroll(Employee... employees) {
        double totalPayroll = 0;
        for (Employee employee : employees) {
            totalPayroll += employee.calculateAnnualEarnings();
        }
        System.out.println("Total Payroll: " + totalPayroll);
    }
}
