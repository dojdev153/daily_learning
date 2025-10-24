import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

public class Exerc {
    public static void main(String[] args) throws ParseException {
        double pi = Math.PI;
        int salary = 1_200_000;
        double amount = 1999.99;
        double num = 123.45;
        LocalDateTime now = LocalDateTime.now();
        String input = "3,14"; 

        // 1. Write a program that prints the numbers 10, 20, and 30 in a single line using printf().
        System.out.println("1. WRITE A PROGRAM THAT PRINTS THE NUMBERS 10, 20, AND 30 IN A SINGLE LINE USING PRINTF().");
        System.out.printf("%d %d %d%n", 10, 20, 30);
        System.out.println();

        // 2. Print the value of π with 2, 4, and 6 decimal places.
        System.out.println("2. PRINT THE VALUE OF PI WITH 2, 4, AND 6 DECIMAL PLACES.");
        System.out.printf("Pi (2 decimals): %.2f%n", pi);
        System.out.printf("Pi (4 decimals): %.4f%n", pi);
        System.out.printf("Pi (6 decimals): %.6f%n", pi);
        System.out.println();

        // 3. Use printf() to print two names left-aligned and their scores right-aligned in columns.
        System.out.println("3. USE PRINTF() TO PRINT TWO NAMES LEFT-ALIGNED AND THEIR SCORES RIGHT-ALIGNED IN COLUMNS.");
        System.out.printf("%-10s %5d%n", "Alice", 95);
        System.out.printf("%-10s %5d%n", "Bob", 87);
        System.out.println();

        // 4. Display a salary of 1200000 using commas as thousand separators.
        System.out.println("4. DISPLAY A SALARY OF 1200000 USING COMMAS AS THOUSAND SEPARATORS.");
        System.out.printf("%,d%n", salary);
        System.out.println();

        // 5. Format the same number for US and France locales using printf().
        System.out.println("5. FORMAT THE SAME NUMBER FOR US AND FRANCE LOCALES USING PRINTF().");
        double number = 1234567.89;
        System.out.printf(Locale.US, "US format: %,f%n", number);
        System.out.printf(Locale.FRANCE, "France format: %,f%n", number);
        System.out.println();

        // 6. Display the same amount (1999.99) in US, France, and Japan currencies.
        System.out.println("6. DISPLAY THE SAME AMOUNT (1999.99) IN US, FRANCE, AND JAPAN CURRENCIES.");
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat fr = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat jp = NumberFormat.getCurrencyInstance(Locale.JAPAN);

        System.out.println("US: " + us.format(amount));
        System.out.println("France: " + fr.format(amount));
        System.out.println("Japan: " + jp.format(amount));
        System.out.println();

        // 7. Use printf() to print +123.45 with zero-padding in a field width of 8.
        System.out.println("7. USE PRINTF() TO PRINT +123.45 WITH ZERO-PADDING IN A FIELD WIDTH OF 8.");
        System.out.printf("%+08.2f%n", num);
        System.out.println();

        // 8. Create a product table with columns: Name, Qty, and Price, using proper spacing.
        System.out.println("8. CREATE A PRODUCT TABLE WITH COLUMNS: NAME, QTY, AND PRICE, USING PROPER SPACING.");
        System.out.printf("%-10s %5s %10s%n", "Name", "Qty", "Price");
        System.out.printf("%-10s %5d %10.2f%n", "Apples", 5, 3.5);
        System.out.printf("%-10s %5d %10.2f%n", "Bananas", 12, 1.25);
        System.out.printf("%-10s %5d %10.2f%n", "Mangoes", 3, 4.75);
        System.out.println();

        // 9. Read a number formatted in French locale (e.g., 3,14) and print it in US format.
        System.out.println("9. READ A NUMBER FORMATTED IN FRENCH LOCALE (E.G., 3,14) AND PRINT IT IN US FORMAT.");
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat nfUs = NumberFormat.getInstance(Locale.US);

        Number parsed = nfFr.parse(input);
        System.out.println("French input: " + input);
        System.out.println("As US number: " + nfUs.format(parsed));
        System.out.println();

        // 10. Display the current date and time using printf() and different locales.
        System.out.println("10. DISPLAY THE CURRENT DATE AND TIME USING PRINTF() AND DIFFERENT LOCALES.");
        System.out.printf(Locale.US, "US: %tA, %<tB %<td, %<tY %<tT%n", now);
        System.out.printf(Locale.FRANCE, "France: %tA, %<td %<tB %<tY %<tT%n", now);
        System.out.printf(Locale.JAPAN, "Japan: %tA, %<tB %<td, %<tY %<tT%n", now);
        System.out.println();
    }
}
