package salarySystem;

/**
 * Represents an employee who earns only through commission.
 * This class extends the abstract Employee class and implements
 * the income calculation based on number of sales and commission per sale.
 */
class CommissionEmployee extends Employee {

    // Number of successful sales made by the employee
    private int salesCount;

    // Amount of money earned per each individual sale
    private double ratePerSale;

    /**
     * Parameterized constructor that sets up all the required fields,
     * including the ones from the parent Employee class.
     *
     * @param firstName     The employee's first name
     * @param lastName      The employee's last name
     * @param ssn           The employee's social security number
     * @param contract      Type of employment contract
     * @param salesCount    Total number of sales the employee has made
     * @param ratePerSale   Earnings for each sale
     */
    public CommissionEmployee(String firstName, String lastName, String ssn, String contract,
                              int salesCount, double ratePerSale) {
        super(firstName, lastName, ssn, contract); // initialize common employee data
        this.salesCount = salesCount;
        this.ratePerSale = ratePerSale;
    }

    /**
     * Default constructor that initializes with default values.
     * Useful when creating an empty object to set values later.
     */
    public CommissionEmployee() {
        super();
        this.salesCount = 0;
        this.ratePerSale = 0.0;
    }

    /**
     * Getter method to access the number of sales.
     * This is helpful for retrieving performance metrics.
     */
    public int getSalesCount() {
        return salesCount;
    }

    /**
     * Setter method to update the number of sales made.
     * You might use this if the employee has new performance data.
     */
    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    /**
     * Getter method for the commission amount earned per sale.
     */
    public double getRatePerSale() {
        return ratePerSale;
    }

    /**
     * Setter method to change the earnings per sale value.
     * This might change if the company updates commission policy.
     */
    public void setRatePerSale(double ratePerSale) {
        this.ratePerSale = ratePerSale;
    }

    /**
     * Calculates the total income earned based on sales performance.
     * Formula: income = number of sales × rate per sale.
     */
    @Override
    public double income() {
        return salesCount * ratePerSale;
    }

    /**
     * Returns a human-readable summary of the employee's information,
     * including inherited attributes and commission-specific details.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nPosition: Commission-Based" +
                "\nSales Completed: " + salesCount +
                "\nEarnings per Sale: " + ratePerSale + " Euro" +
                "\nTotal Income: " + income() + " Euro\n";
    }
}
