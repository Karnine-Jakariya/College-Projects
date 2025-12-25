import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    static Scanner sc = new Scanner(System.in);

    // Store Conversion Rates
    static ArrayList<String> history = new ArrayList<>();

    // Store Currency rates with base USD
    static HashMap<String, Double> rates = new HashMap<>();

    public static void main(String[] args) {

        // Store Currency rates
        rates.put("USD", 1.0);
        rates.put("BDT", 109.5);
        rates.put("GBP", 0.79);
        rates.put("EUR", 0.92);
        rates.put("JPY", 155.0);
        rates.put("CHF", 0.88);

        while (true) {
            printMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    convertCurrency();
                    break;
                case 2:
                    showCurrencies();
                    break;
                case 3:
                    showHistory();
                    break;
                case 4:
                    clearHistory();
                    break;
                case 5:
                    aboutDevelopers();
                    break;
                case 6:
                    System.out.println("\nThank you for using Currency Converter ❤");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Main print menu
    static void printMenu() {
        System.out.println("\n=====================================");
        System.out.println("         CURRENCY CONVERTER ");
        System.out.println("=====================================");
        System.out.println("1. Convert Currency");
        System.out.println("2. Check Supported Currencies");
        System.out.println("3. Check History");
        System.out.println("4. Clear History");
        System.out.println("5. About the Developers");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // first function
    static void convertCurrency() {
        System.out.print("\nFrom Currency (USD, BDT, GBP, EUR, JPY, CHF): ");
        String from = sc.next().toUpperCase();

        System.out.print("To Currency: ");
        String to = sc.next().toUpperCase();

        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            System.out.println(" Unsupported currency!");
            return;
        }

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        double usdAmount = amount / rates.get(from);
        double converted = usdAmount * rates.get(to);

        String result = amount + " " + from + " = " +
                String.format("%.2f", converted) + " " + to;

        System.out.println(result);
        history.add(result);
    }

    // Showing all currencies
    static void showCurrencies() {
        System.out.println("\nSupported Currencies:");
        System.out.println("---------------------");
        for (String currency : rates.keySet()) {
            System.out.println("- " + currency);
        }
    }

    // Showing history
    static void showHistory() {
        System.out.println("\nConversion History:");
        System.out.println("-------------------");

        if (history.isEmpty()) {
            System.out.println("No history available.");
            return;
        }

        for (String record : history) {
            System.out.println(record);
        }
    }

    // clear all history
    static void clearHistory() {
        history.clear();
        System.out.println("History cleared successfully!");
    }

    // about section
    static void aboutDevelopers() {
        System.out.println("\n=================================");
        System.out.println("           ABOUT PROJECT");
        System.out.println("=================================");
        System.out.println("Project : Currency Converter");
        System.out.println("Mode    : Console Application");
        System.out.println("Language: Java");
        System.out.println("Developer: Java Brothers, 4th Semester");
        System.out.println("Purpose : Academic Learning Project");
    }
}