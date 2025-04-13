package salarySystem;

class BaseCommissionEmployee extends CommissionEmployee {

    private double basePay;

    public BaseCommissionEmployee(String firstName, String lastName, String ssn, String contract,
                                  double basePay, int numberOfSales, double commissionPerSale) {
        super(firstName, lastName, ssn, contract, numberOfSales, commissionPerSale);
        this.basePay = basePay;
    }

    public BaseCommissionEmployee() {
        super();
        this.basePay = 0.0;
    }

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    @Override
    public double income() {
        return basePay + super.income() + (basePay * 0.10);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBase Pay: " + basePay + " Euro" +
                "\nBonus Rate: 10%" +
                "\nTotal Pay (with Bonus): " + income() + " Euro\n";
    }
}

