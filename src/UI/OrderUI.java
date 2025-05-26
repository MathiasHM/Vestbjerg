package UI;
import Controllers.OrderController;

import java.util.Scanner;

public class OrderUI {
    Scanner scanner = new Scanner(System.in);
    OrderController orderController = new OrderController();
    public void createOrder() {
        orderController.createOrder();
        System.out.println("Order created successfully.");
    }
    public void openOrderMenu() {
        System.out.println("Order UI started.");
        StringBuilder menu = new StringBuilder();
        menu.append("1. Create Order\n")
            .append("2. View Orders\n")
            .append("3. Update Order\n")
            .append("4. Delete Order\n")
            .append("5. Exit\n");
        while (true) {
            System.out.println(menu.toString());
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Exiting Order UI.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
