package salarySystem;

class FullTimeEmployee extends Employee {

    private double weeklyPay;

    public FullTimeEmployee(String firstName, String lastName, String ssn, String contract, double weeklyPay) {
        super(firstName, lastName, ssn, contract);
        this.weeklyPay = weeklyPay;
    }

    public FullTimeEmployee() {
        super();
        this.weeklyPay = 0.0;
    }

    public double getWeeklyPay() {
        return weeklyPay;
    }

    public void setWeeklyPay(double weeklyPay) {
        this.weeklyPay = weeklyPay;
    }

    @Override
    public double income() {
        return weeklyPay;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPosition: Full-Time" +
                "\nWeekly Payment: " + weeklyPay + " Euro" +
                "\nTotal Earnings: " + income() + " Euro\n";
    }
}

