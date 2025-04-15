package salarySystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application class that runs the employee salary management system.
 * It handles user interaction via a console menu and allows for adding,
 * listing, and grouping employees based on their role or contract type.
 */
public class SalarySystemApp {

    // A list to store all employees, regardless of their type
    private static final ArrayList<Employee> employeeList = new ArrayList<>();

    // Scanner is used for reading user input from the console
    private static final Scanner input = new Scanner(System.in);

    /**
     * Entry point of the application.
     * This method displays the menu and handles user selections in a loop until the user exits.
     */
    public static void main(String[] args) {
        System.out.println("\n*** Welcome to the Employee Salary Manager ***");
        int choice;

        do {
            showMenu();                        // Show menu options
            choice = input.nextInt();          // Get user selection
            input.nextLine();                  // Clear buffer

            // Use switch-case to handle the selected menu option
            switch (choice) {
                case 1 -> registerEmployee();          // Add a new employee
                case 2 -> displayAllEmployees();       // Show all employee details
                case 3 -> showByPosition();            // Group by employee type
                case 4 -> showByContract();            // Group by contract type
                case 5 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid input. Please select 1-5.");
            }
        } while (choice != 5);  // Repeat until user chooses to exit

        input.close();  // Close scanner when the application ends
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add New Employee");
        System.out.println("2. View All Employee Details");
        System.out.println("3. View Employees by Position");
        System.out.println("4. View Employees by Contract Type");
        System.out.println("5. Exit");
        System.out.print("Enter your option: ");
    }

    /**
     * Registers a new employee based on their role.
     * Uses a switch-case to differentiate between Full-Time, Part-Time, Commission, and Base + Commission types.
     * The appropriate employee object is created and added to the list.
     */
    private static void registerEmployee() {
        System.out.println("\nEmployee Roles:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");
        System.out.println("3. Commission-Based");
        System.out.println("4. Base + Commission");

        System.out.print("Choose role (1-4): ");
        int role = input.nextInt();
        input.nextLine(); // Clear buffer

        // Gather common information for all employees
        System.out.print("First Name: ");
        String fname = input.nextLine();
        System.out.print("Last Name: ");
        String lname = input.nextLine();
        System.out.print("SSN: ");
        String ssn = input.nextLine();
        System.out.print("Contract Type: ");
        String contract = input.nextLine();

        // Create the appropriate employee object based on the selected role
        switch (role) {
            case 1 -> {
                System.out.print("Weekly Salary: ");
                double weekly = input.nextDouble();
                input.nextLine();
                employeeList.add(new FullTimeEmployee(fname, lname, ssn, contract, weekly));
            }
            case 2 -> {
                System.out.print("Hours Worked: ");
                int hrs = input.nextInt();
                System.out.print("Hourly Rate: ");
                double rate = input.nextDouble();
                input.nextLine();
                employeeList.add(new PartTimeEmployee(fname, lname, ssn, contract, hrs, rate));
            }
            case 3 -> {
                System.out.print("Number of Sales: ");
                int sales = input.nextInt();
                System.out.print("Commission per Sale: ");
                double cps = input.nextDouble();
                input.nextLine();
                employeeList.add(new CommissionEmployee(fname, lname, ssn, contract, sales, cps));
            }
            case 4 -> {
                System.out.print("Base Salary: ");
                double base = input.nextDouble();
                System.out.print("Sales Count: ");
                int count = input.nextInt();
                System.out.print("Rate per Sale: ");
                double rps = input.nextDouble();
                input.nextLine();
                employeeList.add(new BaseCommissionEmployee(fname, lname, ssn, contract, base, count, rps));
            }
            default -> System.out.println("Invalid role selected.");
        }

        System.out.println("✔ Employee successfully added!");
    }

    /**
     * Displays the details of all employees currently registered in the system.
     * If the list is empty, it shows a warning message instead.
     */
    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠ No employee data found.");
            return;
        }

        System.out.println("\n--- Registered Employees ---");
        for (Employee emp : employeeList) {
            System.out.println(emp); // Calls the overridden toString() method from each employee class
            System.out.println("----------------------------");
        }
    }

    /**
     * Groups and displays employees by their job role (FullTime, PartTime, etc.).
     * It determines the role by analyzing the class name of the object.
     */
    private static void showByPosition() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠ No employees to show.");
            return;
        }

        System.out.println("\n--- Employees Grouped by Position ---");
        for (Employee emp : employeeList) {
            String role = emp.getClass().getSimpleName().replace("Employee", "");
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " - " + role);
        }
    }

    /**
     * Groups and displays employees by their contract type.
     * The contract type is retrieved using a getter method from the base class.
     */
    private static void showByContract() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠ No employee data available.");
            return;
        }

        System.out.println("\n--- Employees Grouped by Contract ---");
        for (Employee emp : employeeList) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName() + " - " + emp.getContractType());
        }
    }
}
