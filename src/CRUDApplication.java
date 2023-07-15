import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDApplication {
    private static List<String> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("CRUD Application");
            System.out.println("----------------");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createItem(scanner);
                    break;
                case 2:
                    readItems();
                    break;
                case 3:
                    updateItem(scanner);
                    break;
                case 4:
                    deleteItem(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void createItem(Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after reading the choice
        System.out.print("Enter the item name: ");
        String item = scanner.nextLine();
        items.add(item);
        System.out.println("Item created successfully.");
        System.out.println();
    }

    private static void readItems() {
        System.out.println("Items:");
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (String item : items) {
                System.out.println(item);
            }
        }
        System.out.println();
    }

    private static void updateItem(Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after reading the choice
        System.out.print("Enter the index of the item to update: ");
        int index = scanner.nextInt();
        if (isValidIndex(index)) {
            scanner.nextLine(); // Consume the newline character after reading the index
            System.out.print("Enter the new item name: ");
            String newItem = scanner.nextLine();
            items.set(index, newItem);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Invalid index. Item not found.");
        }
        System.out.println();
    }

    private static void deleteItem(Scanner scanner) {
        scanner.nextLine(); // Consume the newline character after reading the choice
        System.out.print("Enter the index of the item to delete: ");
        int index = scanner.nextInt();
        if (isValidIndex(index)) {
            items.remove(index);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Invalid index. Item not found.");
        }
        System.out.println();
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index < items.size();
    }
}
