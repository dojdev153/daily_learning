import java.util.*;
public class UseDelimite {
    public static void main(String []a) {
        String data = "Darius ahari yashonje 1";
        String dat2 = "17-10-2025";
        Scanner sc = new Scanner(data);
        String token1 = sc.next();
        String token2 = sc.next();
        String token3 = sc.next();
        int token4 = sc.nextInt();

        System.out.println("First: "  + token1 + " "+ "Second: " + token2 + " "+ "Third: " + token3 + " " + "Fourth: "+ token4);

        Scanner sc2 = new Scanner(dat2);
        sc2.useDelimiter("-");

        int tok1 = Integer.parseInt(sc2.next());
        int tok2 =  Integer.parseInt(sc2.next());
        int tok3 =  Integer.parseInt(sc2.next());
        int sum = tok1 + tok2 + tok3;
        System.out.println("here's the sum: " + sum);

    }
}
