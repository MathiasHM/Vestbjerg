package UI;
import Controllers.OrderController;
import Enums.Result;

import java.util.Scanner;

public class OrderUI {
    Scanner scanner = new Scanner(System.in);
    public void openOrderMenu() {
        System.out.println("Ordrer UI begyndt.");
        StringBuilder menu = new StringBuilder();
        menu.append("1. Ny Ordrer\n")
            .append("2. Se Order (dummy)\n")
            .append("3. Opdater Ordrer (dummy)\n")
            .append("4. Slet Ordrer (dummy)\n")
            .append("5. Tilbage\n");
        while (true) {
            System.out.println(menu);
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    System.out.println("Funktion ikke implementeret endnu.");
                    break;
                case 3:
                    System.out.println("Funktion ikke implementeret endnu.");
                    break;
                case 4:
                    System.out.println("Funktion ikke implementeret endnu.");
                    break;
                case 5:
                    System.out.println("Går ud af Ordrermenuen.");
                    return;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
    private void createOrder() {
        OrderController orderController = new OrderController();
        orderController.createOrder();
        System.out.println("Ordrer påbegyndt.");
        StringBuilder orderMenu = new StringBuilder();
        orderMenu.append("1. Tilføj Produkt\n")
                 .append("2. Fjern Produkt\n")
                 .append("3. Tilføj Kunde til ordren\n")
                 .append("4. Tilføj Fragtoplysninger\n")
                 .append("5. Ordreroversigt\n")
                 .append("6. Send Ordren Videre\n")
                 .append("7. Tilbage Til Ordrermenuen\n");
        while (true) {
            System.out.println(orderMenu);
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Indtast produkt ID og mængde (eks. \"123, 2\"): ");
                    String addInput = scanner.nextLine();
                    String[] addInputArray = addInput.split(",");
                    if (addInputArray.length == 2) {
                        try {
                            int productId = Integer.parseInt(addInputArray[0].trim());
                            int quantity = Integer.parseInt(addInputArray[1].trim());
                            Result result = orderController.addProductByID(productId, quantity);
                            if (result == Result.QUANTITYSET || result == Result.QUANTITYCHANGED || result == Result.NEWLINECREATED) {
                                System.out.println(quantity + " af produkt ID " + productId + " tilføjet til ordren.");
                            } else if (result == Result.MAXTHRESHOLDEXCEEDED) {
                                System.out.println("Det ønskede antal af produkter er for højt til at hente hjem.");
                            } else if (result == Result.QUANTITYLESSTHANONE) {
                                System.out.println("Tilføj mindst et produkt.");
                            } else {
                                System.out.println("Produkt ikke fundet. Kontroller produkt ID.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ugyldig input. Sørg for at indtaste et gyldigt produkt ID og mængde som tal.");
                        }
                    } else {
                        System.out.println("Ugyldig input format. Brug venligst formatet \"produktID, mængde\".");
                    }
                    break;
                case 2:
                    System.out.print("Indtast produkt ID og mængden som skal fjerne (eks. \"123, 2\"): ");
                    String removeInput = scanner.nextLine();
                    String[] removeInputArray = removeInput.split(",");
                    if (removeInputArray.length == 2) {
                        try {
                            int productId = Integer.parseInt(removeInputArray[0].trim());
                            int quantity = Integer.parseInt(removeInputArray[1].trim());
                            Result result = orderController.removeProductByID(productId, quantity);
                            if (result == Result.QUANTITYSET || result == Result.QUANTITYCHANGED) {
                                System.out.println(quantity + " af produkt ID " + productId + " fjernet fra ordren.");
                            } else if (result == Result.MAXTHRESHOLDEXCEEDED) {
                                System.out.println("Det ønskede antal af produkter er for højt til at fjerne.");
                            } else if (result == Result.QUANTITYLESSTHANONE) {
                                System.out.println("Fjern mindst et produkt.");
                            } else {
                                System.out.println("Produkt ikke fundet. Kontroller produkt ID.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ugyldig input. Sørg for at indtaste et gyldigt produkt ID og mængde som tal.");
                        }
                    } else {
                        System.out.println("Ugyldig input format. Brug venligst formatet \"produktID, mængde\".");
                    }
                    break;
                case 3:
                    System.out.print("Indtast kundens email (indtast \"x\" for at gå tilbage): ");
                    String email = scanner.nextLine();
                    if (email.equalsIgnoreCase("x")) {
                        break;
                    }
                    boolean result = orderController.addCustomerByEmail(email);
                    if (result) {
                        System.out.println("Kunde tilføjet til ordren.");
                        break;
                    }
                    System.out.println("Kunde ikke fundet. Kontroller email.");
                case 4:
                    System.out.print("Indtast leveringsnavn: ");
                    String deliveryName = scanner.nextLine();
                    System.out.print("Indtast leveringsadresse: ");
                    String deliveryAddress = scanner.nextLine();
                    System.out.print("Indtast leveringsemail: ");
                    String deliveryEmail = scanner.nextLine();
                    if (deliveryName.isEmpty() || deliveryAddress.isEmpty() || deliveryEmail.isEmpty()) {
                        System.out.println("Alle felter skal udfyldes.");
                        break;
                    }
                    System.out.println("Er disse oplysninger korrekte?");
                    System.out.println("Navn: " + deliveryName);
                    System.out.println("Adresse: " + deliveryAddress);
                    System.out.println("Email: " + deliveryEmail);
                    System.out.print("Indtast \"ja\" for at bekræfte eller \"nej\" for at annullere: ");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("ja")) {
                        orderController.setShippingInformation(deliveryName, deliveryAddress, deliveryEmail);
                        System.out.println("Fragtoplysninger opdateret.");
                    } else {
                        System.out.println("Fragtoplysninger annulleret.");
                    }
                    break;
                case 5:
                    System.out.println("Ordreroversigt:");
                    System.out.println("Produkter i ordren:");
                    String[] lines = orderController.displayLines();
                    if (lines.length == 0) {
                        System.out.println("Ingen produkter i ordren.");
                    } else {
                        for (String line : lines) {
                            System.out.println(line);
                        }
                    }
                    System.out.println("Total pris: " + orderController.getTotalPrice() + " kr.");
                    System.out.println("tryk på enter for at gå tilbage til menuen.");
                    scanner.nextLine(); // Any input continues the program.
                    break;
                case 6:
                    orderController.setOrderPending();
                    System.out.println("Ordren er nu sat til PENDING.");
                    System.out.println("Ordren afventer kundens bekræftelse.");
                    return; // Exit to main menu
                case 7:
                    return; // Exit to main menu
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
}
