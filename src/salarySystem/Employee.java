package salarySystem;

abstract class Employee {

    private String firstName;
    private String lastName;
    private String socialID;
    private String contractType;

    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.socialID = "";
        this.contractType = "";
    }

    public Employee(String firstName, String lastName, String socialID, String contractType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialID = socialID;
        this.contractType = contractType;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSocialID() { return socialID; }
    public String getContractType() { return contractType; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSocialID(String socialID) { this.socialID = socialID; }
    public void setContractType(String contractType) { this.contractType = contractType; }

    public abstract double income();

    @Override
    public String toString() {
        return "Employee Name: " + firstName + " " + lastName +
                "\nSSN: " + socialID +
                "\nContract: " + contractType;
    }
}

