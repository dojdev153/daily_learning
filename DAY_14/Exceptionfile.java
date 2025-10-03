

import java.util.Scanner;

public class Exceptionfile {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int b = sc.nextInt();

        try {
            if(b<18)
                throw new AgeException("you're under 18");
            System.out.println("watch movie");
        } catch (AgeException e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
    
}

class AgeException extends Exception {
    public AgeException(String message){
        super(message);
    }
}
