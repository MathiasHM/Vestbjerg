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
        while (true) {
            System.out.print('\u000C'); // Clear the console
            System.out.println("Velkommen til Vestbjergs ordrerstyringssystem!");
            System.out.println("Vælg en mulighed for at fortsætte.");
            System.out.print("""
                    1. Ordrer
                    2. Generer testdata
                    0. Afslut
                    """);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    OrderUI orderUI = new OrderUI();
                    orderUI.openOrderMenu();
                    break;
                case 2:
                    TestData testData = new TestData();
                    testData.generateTestData();
                    System.out.println("Testdata genereret.");
                    System.out.println("Du kan nu oprette ordrer med testdata.");
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Afslutter programmet.");
                    return;
                default:
                    System.out.println("Ugyldigt valg.");
                    scanner.nextLine();
            }
        }
    }
}