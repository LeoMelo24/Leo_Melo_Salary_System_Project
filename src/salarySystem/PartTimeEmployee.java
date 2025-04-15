package salarySystem;

/**
 * Represents an employee who works part-time and is paid based on the number of hours worked.
 * This class extends the abstract Employee class and includes logic for calculating
 * income using an hourly wage model.
 */
class PartTimeEmployee extends Employee {

    // Total number of hours the employee has worked
    private int workedHours;

    // Hourly wage the employee earns
    private double payPerHour;

    /**
     * Parameterized constructor to create a part-time employee with full details.
     * Calls the parent constructor to set shared fields and then sets its own.
     *
     * @param firstName     The employee's first name
     * @param lastName      The employee's last name
     * @param ssn           The employee's social security number
     * @param contract      Type of contract (e.g., Part-Time)
     * @param workedHours   Total number of hours worked
     * @param payPerHour    Wage paid per hour of work
     */
    public PartTimeEmployee(String firstName, String lastName, String ssn, String contract,
                            int workedHours, double payPerHour) {
        super(firstName, lastName, ssn, contract); // Initialize shared employee data
        this.workedHours = workedHours;
        this.payPerHour = payPerHour;
    }

    /**
     * Default constructor that initializes values to zero.
     * This allows creating an object that can be filled later.
     */
    public PartTimeEmployee() {
        super(); // Call default constructor of Employee
        this.workedHours = 0;
        this.payPerHour = 0.0;
    }

    /**
     * Getter for the number of hours the employee worked.
     * Useful for salary calculations or reporting.
     */
    public int getWorkedHours() {
        return workedHours;
    }

    /**
     * Setter to update the number of hours worked.
     * Can be changed when time logs are updated.
     */
    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    /**
     * Getter for the hourly wage.
     * Returns how much the employee earns per hour.
     */
    public double getPayPerHour() {
        return payPerHour;
    }

    /**
     * Setter to modify the hourly wage.
     * Can be adjusted if wage policy changes.
     */
    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    /**
     * Calculates total income for this part-time employee.
     * Formula: income = hours worked × wage per hour.
     */
    @Override
    public double income() {
        return workedHours * payPerHour;
    }

    /**
     * Generates a descriptive string with all relevant details for this employee.
     * Combines inherited data with part-time specific fields like worked hours and hourly wage.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nPosition: Part-Time" +
                "\nWorked Hours: " + workedHours +
                "\nHourly Wage: " + payPerHour + " Euro" +
                "\nTotal Pay: " + income() + " Euro\n";
    }
}
