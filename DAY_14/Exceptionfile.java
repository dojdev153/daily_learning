package DAY_14;

import java.util.Scanner;

public class Exceptionfile {
    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
        int a, b;

        System.out.println("Enter the first number: ");
        a = sc.nextInt();
        System.out.println("Enter the second number: ");
        b = sc.nextInt();

        try {
            if(b == 0)
               throw new ArithmeticException("Cannot divide by zero");
            int c = a / b;
            System.out.println("The result is: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("General error: " + e);
        }

        sc.close();
    }
    
}
