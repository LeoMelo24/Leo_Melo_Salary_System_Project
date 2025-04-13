package salarySystem;

import java.util.ArrayList;
import java.util.Scanner;

public class SalarySystemApp {

    private static final ArrayList<Employee> employeeList = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n*** Welcome to the Employee Salary Manager ***");
        int choice;

        do {
            showMenu();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> registerEmployee();
                case 2 -> displayAllEmployees();
                case 3 -> showByPosition();
                case 4 -> showByContract();
                case 5 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid input. Please select 1-5.");
            }
        } while (choice != 5);

        input.close();
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add New Employee");
        System.out.println("2. View All Employee Details");
        System.out.println("3. View Employees by Position");
        System.out.println("4. View Employees by Contract Type");
        System.out.println("5. Exit");
        System.out.print("Enter your option: ");
    }

    private static void registerEmployee() {
        System.out.println("\nEmployee Roles:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");
        System.out.println("3. Commission-Based");
        System.out.println("4. Base + Commission");

        System.out.print("Choose role (1-4): ");
        int role = input.nextInt();
        input.nextLine();

        System.out.print("First Name: ");
        String fname = input.nextLine();
        System.out.print("Last Name: ");
        String lname = input.nextLine();
        System.out.print("SSN: ");
        String ssn = input.nextLine();
        System.out.print("Contract Type: ");
        String contract = input.nextLine();

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

    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠ No employee data found.");
            return;
        }

        System.out.println("\n--- Registered Employees ---");
        for (Employee emp : employeeList) {
            System.out.println(emp);
            System.out.println("----------------------------");
        }
    }

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
