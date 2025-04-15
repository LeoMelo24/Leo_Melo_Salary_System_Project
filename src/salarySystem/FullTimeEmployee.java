package salarySystem;

/**
 * Represents an employee who earns a fixed salary each week.
 * This class extends the abstract Employee class and defines
 * the logic specific to full-time salaried workers.
 */
class FullTimeEmployee extends Employee {

    // The amount of money the employee earns weekly, regardless of hours worked
    private double weeklyPay;

    /**
     * Parameterized constructor that sets all values during object creation.
     * It uses 'super' to initialize common fields from the Employee class,
     * and assigns the weekly salary unique to this class.
     *
     * @param firstName   First name of the employee
     * @param lastName    Last name of the employee
     * @param ssn         Social security number (unique identifier)
     * @param contract    Type of contract (e.g., Full-Time)
     * @param weeklyPay   Fixed weekly salary
     */
    public FullTimeEmployee(String firstName, String lastName, String ssn, String contract, double weeklyPay) {
        super(firstName, lastName, ssn, contract); // Initialize common employee attributes
        this.weeklyPay = weeklyPay;
    }

    /**
     * Default constructor that sets salary to 0.0.
     * This allows the object to be created with no predefined values.
     */
    public FullTimeEmployee() {
        super(); // Call the default constructor of Employee
        this.weeklyPay = 0.0;
    }

    /**
     * Getter method that returns the weekly salary.
     * Useful for displaying or using the value in calculations.
     */
    public double getWeeklyPay() {
        return weeklyPay;
    }

    /**
     * Setter method to update the weekly salary.
     * You might use this if the employee receives a raise.
     */
    public void setWeeklyPay(double weeklyPay) {
        this.weeklyPay = weeklyPay;
    }

    /**
     * Implements the abstract income method from Employee.
     * For full-time employees, their income is simply the fixed weekly salary.
     */
    @Override
    public double income() {
        return weeklyPay;
    }

    /**
     * Returns a formatted string with both inherited and role-specific info.
     * Includes the position title, weekly payment, and total income.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nPosition: Full-Time" +
                "\nWeekly Payment: " + weeklyPay + " Euro" +
                "\nTotal Earnings: " + income() + " Euro\n";
    }
}
