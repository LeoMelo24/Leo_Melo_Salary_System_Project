package salarySystem;

class CommissionEmployee extends Employee {

    private int salesCount;
    private double ratePerSale;

    public CommissionEmployee(String firstName, String lastName, String ssn, String contract,
                              int salesCount, double ratePerSale) {
        super(firstName, lastName, ssn, contract);
        this.salesCount = salesCount;
        this.ratePerSale = ratePerSale;
    }

    public CommissionEmployee() {
        super();
        this.salesCount = 0;
        this.ratePerSale = 0.0;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public double getRatePerSale() {
        return ratePerSale;
    }

    public void setRatePerSale(double ratePerSale) {
        this.ratePerSale = ratePerSale;
    }

    @Override
    public double income() {
        return salesCount * ratePerSale;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPosition: Commission-Based" +
                "\nSales Completed: " + salesCount +
                "\nEarnings per Sale: " + ratePerSale + " Euro" +
                "\nTotal Income: " + income() + " Euro\n";
    }
}

