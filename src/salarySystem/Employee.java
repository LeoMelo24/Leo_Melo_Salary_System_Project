package salarySystem;

/**
 * Abstract base class that defines the common attributes and behavior
 * shared by all types of employees in the salary system.
 * 
 * This class is meant to be extended by specific employee types (e.g., FullTimeEmployee).
 */
abstract class Employee {

    // These fields store the employee's personal and contract-related details
    private String firstName;      // Employee's first name
    private String lastName;       // Employee's last name
    private String socialID;       // Unique identifier (e.g., Social Security Number)
    private String contractType;   // Type of contract (e.g., Full-Time, Part-Time)

    /**
     * Default constructor that initializes all attributes to empty strings.
     * Used when we want to create an empty employee object and set the data later.
     */
    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.socialID = "";
        this.contractType = "";
    }

    /**
     * Constructor that allows us to immediately assign values when creating the object.
     * Useful when we already know the employee's information at the time of creation.
     */
    public Employee(String firstName, String lastName, String socialID, String contractType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialID = socialID;
        this.contractType = contractType;
    }

    // ----------- GETTERS -----------

    /**
     * A getter is a public method that allows us to access private data from outside the class.
     * This method returns the employee's first name.
     */
    public String getFirstName() { return firstName; }

    /**
     * Returns the employee's last name.
     */
    public String getLastName() { return lastName; }

    /**
     * Returns the employee's social security number (SSN).
     */
    public String getSocialID() { return socialID; }

    /**
     * Returns the type of contract this employee has.
     */
    public String getContractType() { return contractType; }

    // ----------- SETTERS -----------

    /**
     * A setter is a public method that lets us safely update the value of a private field.
     * This method sets a new first name for the employee.
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Updates the employee's last name.
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Updates the employee's social ID (SSN).
     */
    public void setSocialID(String socialID) { this.socialID = socialID; }

    /**
     * Updates the contract type of the employee.
     */
    public void setContractType(String contractType) { this.contractType = contractType; }

    /**
     * Abstract method that must be implemented in all subclasses.
     * Each type of employee will have its own logic for calculating income,
     * depending on whether they are full-time, part-time, commission-based, etc.
     */
    public abstract double income();

    /**
     * Converts the employee object into a readable string format.
     * This helps when printing employee information to the screen.
     * It uses the fields already stored in the object.
     */
    @Override
    public String toString() {
        return "Employee Name: " + firstName + " " + lastName +
               "\nSSN: " + socialID +
               "\nContract: " + contractType;
    }
}
