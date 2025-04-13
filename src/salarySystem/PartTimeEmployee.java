package salarySystem;

class PartTimeEmployee extends Employee {

    private int workedHours;
    private double payPerHour;

    public PartTimeEmployee(String firstName, String lastName, String ssn, String contract,
                            int workedHours, double payPerHour) {
        super(firstName, lastName, ssn, contract);
        this.workedHours = workedHours;
        this.payPerHour = payPerHour;
    }

    public PartTimeEmployee() {
        super();
        this.workedHours = 0;
        this.payPerHour = 0.0;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    @Override
    public double income() {
        return workedHours * payPerHour;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPosition: Part-Time" +
                "\nWorked Hours: " + workedHours +
                "\nHourly Wage: " + payPerHour + " Euro" +
                "\nTotal Pay: " + income() + " Euro\n";
    }
}

