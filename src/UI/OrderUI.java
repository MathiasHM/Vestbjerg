/*
 * OrderUI.java
 *
 * This class is a user interface for managing orders. Currently, it allows users to create orders,
 * during which they can add and remove products, associate customers, set shipping information,
 * view order details, and send orders for confirmation.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package UI;

import Controllers.OrderController;
import Enums.Result;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class OrderUI {
    Scanner scanner = new Scanner(System.in);
    public void createOrder() {
        OrderController orderController = new OrderController();
        orderController.createOrder();
        System.out.println("Ordrer påbegyndt.");
        StringBuilder orderMenu = new StringBuilder();
        orderMenu.append("1. Tilføj Produkt\n").append("2. Fjern Produkt\n")
                .append("3. Tilføj Kunde til ordren\n")
                .append("4. Tilføj Fragtoplysninger\n")
                .append("5. Ordreroversigt\n").append("6. Send Ordren Videre\n")
                .append("0. Tilbage Til Ordrermenuen\n");
        while (true) {
            System.out.print('\u000C');
            System.out.println(orderMenu);
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print('\u000C');
                    System.out.println(
                            "Indtast produkt ID og mængde som skal tilføjes (eks. \"123, 2\"");
                    System.out.println(
                            "eller indtast \"x\" for at gå tilbage til ordrermenuen: ");
                    String addInput = scanner.nextLine();
                    if (addInput.equalsIgnoreCase("x")) {
                        break;
                    }
                    String[] addInputArray = addInput.split(",");
                    if (addInputArray.length == 2) {
                        try {
                            int productId =
                                    Integer.parseInt(addInputArray[0].trim());
                            int quantity =
                                    Integer.parseInt(addInputArray[1].trim());
                            Result result =
                                    orderController.addProductByID(productId,
                                            quantity);
                            if (result == Result.QUANTITYSET ||
                                    result == Result.QUANTITYCHANGED ||
                                    result == Result.NEWLINECREATED) {
                                System.out.println(
                                        quantity + " af produkt ID " +
                                                productId +
                                                " tilføjet til ordren.");
                                System.out.println(
                                        "Tryk på x for at gå tilbage til ordrermenuen eller en anden tast for at fortsætte.");
                                if (scanner.nextLine().equalsIgnoreCase("x")) {
                                    break; // Exit to main menu
                                }
                            } else if (result == Result.MAXTHRESHOLDEXCEEDED) {
                                System.out.println(
                                        "Det ønskede antal af produkter er for højt til at hente hjem.");
                                scanner.nextLine();
                            } else if (result == Result.QUANTITYLESSTHANONE) {
                                System.out.println("Tilføj mindst et produkt.");
                                scanner.nextLine();
                            } else {
                                System.out.println(
                                        "Produkt ikke fundet. Kontroller produkt ID.");
                                scanner.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(
                                    "Ugyldig input. Sørg for at indtaste et gyldigt produkt ID og mængde som tal.");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println(
                                "Ugyldig input format. Brug venligst formatet \"produktID, mængde\".");
                        scanner.nextLine();
                    }
                    continue;
                case 2:
                    System.out.print('\u000C');
                    System.out.println(
                            "Indtast produkt ID og mængde som skal fjernes (eks. \"123, 2\"");
                    System.out.println(
                            "eller indtast \"x\" for at gå tilbage til ordrermenuen: ");
                    String removeInput = scanner.nextLine();
                    if (removeInput.equalsIgnoreCase("x")) {
                        break;
                    }
                    String[] removeInputArray = removeInput.split(",");
                    if (removeInputArray.length == 2) {
                        try {
                            int productId = Integer.parseInt(
                                    removeInputArray[0].trim());
                            int quantity = Integer.parseInt(
                                    removeInputArray[1].trim());
                            Result result =
                                    orderController.removeProductByID(productId,
                                            quantity);
                            if (result == Result.QUANTITYSET ||
                                    result == Result.QUANTITYCHANGED) {
                                System.out.println(
                                        quantity + " af produkt ID " +
                                                productId +
                                                " fjernet fra ordren.");
                                System.out.println(
                                        "Tryk på x for at gå tilbage til ordrermenuen eller en anden tast for at fortsætte.");
                                if (scanner.nextLine().equalsIgnoreCase("x")) {
                                    break; // Exit to main menu
                                }
                            } else if (result == Result.MAXTHRESHOLDEXCEEDED) {
                                System.out.println(
                                        "Det ønskede antal af produkter er for højt til at fjerne.");
                                scanner.nextLine();
                            } else if (result == Result.QUANTITYLESSTHANONE) {
                                System.out.println("Fjern mindst et produkt.");
                                scanner.nextLine();
                            } else {
                                System.out.println(
                                        "Produkt ikke fundet. Kontroller produkt ID.");
                                scanner.nextLine();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(
                                    "Ugyldig input. Sørg for at indtaste et gyldigt produkt ID og mængde som tal.");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println(
                                "Ugyldig input format. Brug venligst formatet \"produktID, mængde\".");
                        scanner.nextLine();
                    }
                    continue;
                case 3:
                    System.out.print('\u000C');
                    System.out.print(
                            "Indtast kundens email (indtast \"x\" for at gå tilbage): ");
                    String email = scanner.nextLine();
                    if (email.equalsIgnoreCase("x")) {
                        break;
                    }
                    Result result = orderController.addCustomerByEmail(email);
                    if (result == Result.CUSTOMERADDED) {
                        System.out.println(email + " tilføjet til ordren.");
                        scanner.nextLine();
                        break;
                    } else if (result == Result.CUSTOMERALREADYASSOCIATED) {
                        System.out.println(
                                "En kunde er allerede tilføjet til ordren.");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println(
                            email + " ikke fundet. Kontroller email.");
                    scanner.nextLine();
                    continue;
                case 4:
                    System.out.print('\u000C');
                    System.out.print("Indtast leveringsnavn: ");
                    String deliveryName = scanner.nextLine();
                    System.out.print("Indtast leveringsadresse: ");
                    String deliveryAddress = scanner.nextLine();
                    System.out.print("Indtast leveringsemail: ");
                    String deliveryEmail = scanner.nextLine();
                    if (deliveryName.isEmpty() || deliveryAddress.isEmpty() ||
                            deliveryEmail.isEmpty()) {
                        System.out.println("Alle felter skal udfyldes.");
                        System.out.println(
                                "Tryk på x for at gå tilbage til ordrermenuen eller en anden tast for at fortsætte.");
                        if (scanner.nextLine().equalsIgnoreCase("x")) {
                            break; // Exit to main menu
                        }
                        continue;
                    }
                    System.out.print('\u000C');
                    System.out.println("Er disse oplysninger korrekte?");
                    System.out.println("Navn: " + deliveryName);
                    System.out.println("Adresse: " + deliveryAddress);
                    System.out.println("Email: " + deliveryEmail);
                    System.out.print(
                            "Indtast \"ja\" for at bekræfte eller \"nej\" for at annullere: ");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equalsIgnoreCase("ja")) {
                        orderController.setShippingInformation(deliveryName,
                                deliveryAddress, deliveryEmail);
                        System.out.println("Fragtoplysninger opdateret.");
                    } else {
                        System.out.println("Fragtoplysninger annulleret.");
                    }
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print('\u000C');
                    System.out.println("Ordreroversigt:");
                    String[] lines = orderController.displayLines();
                    if (lines.length == 0) {
                        System.out.println("Ingen produkter i ordren.");
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Produkter i ordren:");
                        for (String line : lines) {
                            String[] parts = line.split("/");
                            System.out.print("/n");
                            System.out.println(parts[0].trim());
                            System.out.println("ID: " + parts[1].trim());
                            System.out.println("Pris: " + parts[2].trim());
                            System.out.println("Antal: " + parts[3].trim());
                            System.out.println("Subtotal: " + parts[4].trim());
                        }
                    }
                    System.out.println("Total pris: " +
                            NumberFormat.getCurrencyInstance(
                                            new Locale("da", "DK"))
                                    .format(orderController.getTotalPrice()[0]));
                    System.out.println(
                            "Rabat: " + orderController.getTotalPrice()[1] +
                                    "%");
                    System.out.println("Total pris efter rabat: " +
                            NumberFormat.getCurrencyInstance(
                                            new Locale("da", "DK"))
                                    .format(orderController.getTotalPrice()[2]));
                    scanner.nextLine(); // Any input continues the program.
                    break;
                case 6:
                    System.out.println('\u000C');
                    if (orderController.displayLines().length == 0) {
                        System.out.println(
                                "Ingen produkter i ordren. Du kan ikke sende en tom ordre.");
                        scanner.nextLine();
                        break;
                    }
                    System.out.println(
                            "Er du sikker på at du vil sende ordren videre?");
                    System.out.println(
                            "Dette vil sætte ordren til PENDING status og afvente kundens bekræftelse.");
                    System.out.print(
                            "Indtast \"ja\" for at bekræfte eller \"nej\" for at annullere: ");
                    String sendConfirmation = scanner.nextLine();
                    if (!sendConfirmation.equalsIgnoreCase("ja")) {
                        System.out.println("Ordren er ikke sendt videre.");
                        scanner.nextLine();
                        break;
                    }
                    orderController.setOrderPending();
                    System.out.println("Ordren er nu sat til PENDING.");
                    System.out.println("Ordren afventer kundens bekræftelse.");
                    scanner.nextLine();
                    return; // Exit to main menu
                case 0:
                    System.out.println(
                            "Er du sikker på at du vil forlade ordrermenuen?");
                    System.out.println("Dette vil slette den nuværende ordre.");
                    System.out.print(
                            "Indtast \"ja\" for at bekræfte eller \"nej\" for at annullere: ");
                    String exitConfirmation = scanner.nextLine();
                    if (!exitConfirmation.equalsIgnoreCase("ja")) {
                        System.out.println("Går tilbage til ordrermenuen.");
                        scanner.nextLine();
                        break;
                    }
                    return; // Exit to main menu
                default:
                    System.out.println("Ugyldigt valg.");
            }
        }
    }
}
