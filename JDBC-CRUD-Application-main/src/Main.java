import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        EmployeeDAO.initializeDatabase();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n====== Employee CRUD Menu ======");
            System.out.println("1. Insert Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee by ID");
            System.out.println("4. Update Employee by Name");
            System.out.println("5. Update Employee by Email");
            System.out.println("6. Delete Employee");
            System.out.println("7. Batch Insert Employees");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Employee Country: ");
                    String country = sc.nextLine();

                    Employee emp = new Employee(0, name, email, country);
                    employeeDAO.insertEmployee(emp);
                    break;

                case 2: // View
                    employeeDAO.printEmployee();
                    break;

                case 3: // Update by ID
                    System.out.print("Enter Employee ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter New Country: ");
                    String newCountry = sc.nextLine();

                    employeeDAO.updateEmployeeById(id, newName, newEmail, newCountry);
                    break;

                case 4: // Update by Name
                    System.out.print("Enter Current Name: ");
                    String oldName = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uName = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String uEmail = sc.nextLine();
                    System.out.print("Enter New Country: ");
                    String uCountry = sc.nextLine();

                    employeeDAO.updateEmployeeByName(oldName, uName, uEmail, uCountry);
                    break;

                case 5: // Update by Email
                    System.out.print("Enter Current Email: ");
                    String oldEmail = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String ueName = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newE = sc.nextLine();
                    System.out.print("Enter New Country: ");
                    String ueCountry = sc.nextLine();

                    employeeDAO.updateEmployeeByEmail(oldEmail, ueName, newE, ueCountry);
                    break;

                case 6: // Delete
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    employeeDAO.deleteEmployee(delId);
                    break;

                case 7: // Batch insert
                    List<Employee> employees = new ArrayList<>();
                    System.out.print("How many employees to insert? ");
                    int count = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter details for Employee " + (i + 1));
                        System.out.print("Name: ");
                        String bName = sc.nextLine();
                        System.out.print("Email: ");
                        String bEmail = sc.nextLine();
                        System.out.print("Country: ");
                        String bCountry = sc.nextLine();
                        employees.add(new Employee(0, bName, bEmail, bCountry));
                    }
                    employeeDAO.batchInsertEmployees(employees);
                    break;

                case 8: // Exit
                    exit = true;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
