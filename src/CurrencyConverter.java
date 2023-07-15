import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("------------------");
        System.out.println("Available Currencies:");
        System.out.println("1. USD - United States Dollar");
        System.out.println("2. EUR - Euro");
        System.out.println("3. INR - Indian Rupee");

        System.out.print("Enter the source currency code: ");
        String sourceCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the amount to convert: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered. Conversion failed.");
            scanner.close();
            return;
        }

        double conversionRate = 0.0;

        if (sourceCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            conversionRate = 0.85;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            conversionRate = 1.18;
        } else if (sourceCurrency.equals("INR") && targetCurrency.equals("USD")) {
            conversionRate = 0.014;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("INR")) {
            conversionRate = 71.21;
        }

        if (conversionRate != 0.0) {
            double convertedAmount = amount * conversionRate;
            System.out.printf("%.2f %s = %.2f %s\n", amount, sourceCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency codes entered. Conversion failed.");
        }

        scanner.close();
    }
}
