import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println("Employee ID already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);

        employeeList.add(emp);

        System.out.println("Employee Added Successfully.");
    }

    static void viewEmployees() {

        if (employeeList.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        for (Employee emp : employeeList) {
            emp.displayEmployee();
        }
    }

    static void searchEmployee() {

        if (employeeList.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employeeList) {

            if (emp.getId() == id) {

                System.out.println("Employee Found");
                emp.displayEmployee();
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    static void updateEmployee() {

        if (employeeList.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        System.out.print("Enter Employee ID to Update: ");
        int id = sc.nextInt();

        sc.nextLine();

        for (Employee emp : employeeList) {

            if (emp.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Department: ");
                String department = sc.nextLine();

                System.out.print("Enter New Salary: ");
                double salary = sc.nextDouble();

                emp.setName(name);
                emp.setDepartment(department);
                emp.setSalary(salary);

                System.out.println("Employee Updated Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    static void deleteEmployee() {

        if (employeeList.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        for (Employee emp : employeeList) {

            if (emp.getId() == id) {

                employeeList.remove(emp);

                System.out.println("Employee Deleted Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }
}