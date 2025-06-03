import UI.OrderUI;
import UI.TestData;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Velkommen til Vestbjergs ordrerstyringssystem!");
            System.out.println("Vælg en mulighed for at fortsætte.");
            System.out.print("""
                    1. Ordrer
                    2. Generer testdata
                    3. Afslut
                    """);
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    OrderUI orderUI = new OrderUI();
                    orderUI.openOrderMenu();
                    break;
                case 2:
                    System.out.println("Genererer testdata...");
                    TestData testData = new TestData();
                    testData.generateTestData();
                    break;
                case 3:
                    System.out.println("Afslutter programmet.");
                    return;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
}