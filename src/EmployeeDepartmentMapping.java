import java.util.*;

public class EmployeeDepartmentMapping {
    private HashMap<String, String> employeeDepartmentMap;

    public EmployeeDepartmentMapping() {
        employeeDepartmentMap = new HashMap<>();
    }

    // Method to add a new employee and their department
    public void addEmployee(String name, String department) {
        employeeDepartmentMap.put(name, department);
    }

    // Method to get the department of a specific employee
    public String getDepartment(String name) {
        return employeeDepartmentMap.getOrDefault(name, "Employee not found.");
    }

    // Method to list all employees in a given department
    public List<String> listEmployeesInDepartment(String department) {
        List<String> employeesInDepartment = new ArrayList<>();
        for (Map.Entry<String, String> entry : employeeDepartmentMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(department)) {
                employeesInDepartment.add(entry.getKey());
            }
        }
        return employeesInDepartment;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDepartmentMapping mapping = new EmployeeDepartmentMapping();

        // Input loop for adding employees
        System.out.println("Enter employee names and their departments. Type 'exit' to stop.");
        while (true) {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter department for " + name + ": ");
            String department = scanner.nextLine();
            mapping.addEmployee(name, department);
        }

        // Input loop for getting department or listing employees
        while (true) {
            System.out.print("Enter '1' to get department of an employee, '2' to list employees in a department, or 'exit' to quit: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            if (choice.equals("1")) {
                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.println("Department of " + name + ": " + mapping.getDepartment(name));
            } else if (choice.equals("2")) {
                System.out.print("Enter department name: ");
                String department = scanner.nextLine();
                List<String> employees = mapping.listEmployeesInDepartment(department);
                if (employees.isEmpty()) {
                    System.out.println("No employees found in department: " + department);
                } else {
                    System.out.println("Employees in " + department + ": " + employees);
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
