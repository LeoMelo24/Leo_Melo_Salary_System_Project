package salarySystem;

/**
 * This class represents an employee who earns a base salary plus commission.
 * It extends the CommissionEmployee class to reuse the commission-related logic,
 * and adds new logic for base pay and a 10% bonus on that base pay.
 */
class BaseCommissionEmployee extends CommissionEmployee {

    // This field represents the fixed base salary before commission and bonus
    private double basePay;

    /**
     * Constructor that initializes all fields, including those inherited from the parent class.
     * It calls the constructor of CommissionEmployee using 'super' to set the inherited fields.
     * Then it sets its own unique field, basePay.
     *
     * @param firstName         First name of the employee
     * @param lastName          Last name of the employee
     * @param ssn               Social Security Number (unique identifier)
     * @param contract          Type of contract (e.g., Full-Time, Freelance)
     * @param basePay           The fixed base salary of the employee
     * @param numberOfSales     Number of successful sales made
     * @param commissionPerSale The commission earned per sale
     */
    public BaseCommissionEmployee(String firstName, String lastName, String ssn, String contract,
                                  double basePay, int numberOfSales, double commissionPerSale) {
        super(firstName, lastName, ssn, contract, numberOfSales, commissionPerSale);
        this.basePay = basePay;
    }

    /**
     * Default constructor which sets default values.
     * Calls the default constructor from the parent class and sets basePay to 0.
     */
    public BaseCommissionEmployee() {
        super(); // calls CommissionEmployee's no-argument constructor
        this.basePay = 0.0;
    }

    /**
     * Getter method to access the basePay value.
     * Useful when retrieving the base salary for calculations or display.
     */
    public double getBasePay() {
        return basePay;
    }

    /**
     * Setter method to update the basePay value.
     * Useful when modifying the salary of an existing employee object.
     */
    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    /**
     * Calculates the total income for this employee.
     * It includes:
     * - The fixed base pay
     * - The commission (handled by the parent class via super.income())
     * - A 10% bonus on the base pay
     */
    @Override
    public double income() {
        return basePay + super.income() + (basePay * 0.10);  // total = base + commission + bonus
    }

    /**
     * Returns a formatted string representation of the employee.
     * This includes information from the CommissionEmployee class and adds:
     * - The base salary
     * - The bonus rate (10%)
     * - The total income after combining all components
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nBase Pay: " + basePay + " Euro" +
                "\nBonus Rate: 10%" +
                "\nTotal Pay (with Bonus): " + income() + " Euro\n";
    }
}
