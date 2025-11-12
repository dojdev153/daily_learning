import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number (1 = Monday, ..., 7 = Sunday): ");
        int day = sc.nextInt();

        if (day < 1 || day > 7) {
            System.out.println("Invalid input! Please enter a number between 1 and 7.");
            sc.close();
            return;
        }

        String dayName;

        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid input! Please enter a number between 1 and 7.";
        }

        System.out.println(dayName);

        System.out.println();

        System.out.println("Enter a vowel: ");

        char ch = sc.next().charAt(0); // Read first character

        // Convert to lowercase to handle both uppercase and lowercase letters
        ch = Character.toLowerCase(ch);

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(ch + " is a vowel.");
                break;
            default:
                // Check if the character is an alphabet letter
                if (ch >= 'a' && ch <= 'z') {
                    System.out.println(ch + " is a consonant.");
                } else {
                    System.out.println("Invalid input! Not an alphabet letter.");
                }
        }
        

        int n = 10; // Number of terms
        int first = 0, second = 1; // First two terms of the series

        System.out.println("Fibonacci series up to " + n + " terms:");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            // Calculate the next term
            int next = first + second;
            first = second;
            second = next;
        }
         
        sc.close();
    }
}
