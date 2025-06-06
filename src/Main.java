/*
 * Main.java
 *
 * This main class is the entry point for the Vestbjerg order management system.
 * It provides an initial menu for users to interact with the system,
 * allowing them to manage orders or generate test data.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

import UI.OrderUI;
import UI.TestData;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Velkommen til Vestbjergs ordrerstyringssystem!\n")
                .append("Vælg en mulighed for at fortsætte.\n")
                .append("1. Opret Ordrer\n").append("2. Generer testdata\n")
                .append("0. Afslut\n").append("Vælg en mulighed: ");
        while (true) { // Infinite loop to keep the menu active until the user chooses to exit
            System.out.print('\u000C'); // Clear the console (bluej specific)
            System.out.println(sb.toString());
            Scanner scanner = new Scanner(System.in);
            int choice;
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
            }
            switch (choice) {
                case 1:
                    OrderUI orderUI = new OrderUI();
                    orderUI.createOrder();
                    break;
                case 2:
                    TestData testData = new TestData();
                    testData.generateTestData();
                    System.out.println("Testdata genereret.");
                    System.out.println(
                            "Du kan nu oprette ordrer med testdata.");
                    System.out.println("Tryk på Enter for at fortsætte.");
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Afslutter programmet.");
                    return;
                default:
                    System.out.println("Ugyldigt valg.");
                    System.out.println("Tryk på Enter for at prøve igen.");
                    scanner.nextLine();
            }
        }
    }
}