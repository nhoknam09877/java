package java;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CRMProgram {

    private static Map<String, Customer> customers = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    findCustomer(scanner);
                    break;
                case 3:
                    displayAllCustomers();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println();
        } while (option != 4);
    }

    private static void printMenu() {
        System.out.println("Customer Relationship Management");
        System.out.println("1. Add new customer");
        System.out.println("2. Find by name");
        System.out.println("3. Display all");
        System.out.println("4. Exit");
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.next();
        System.out.print("Enter customer email: ");
        String email = scanner.next();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.next();

        Customer customer = new Customer(name, email, phone);
        customers.put(name, customer);

        System.out.println("Customer added successfully.");
    }

    private static void findCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.next();

        if (customers.containsKey(name)) {
            Customer customer = customers.get(name);
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void displayAllCustomers() {
        System.out.println("All Customers:");
        for (Customer customer : customers.values()) {
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
            System.out.println();
        }
    }
}

