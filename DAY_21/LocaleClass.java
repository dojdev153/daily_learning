import java.util.Scanner;

public class LocaleClass {
    public static void main(String[] args) {
        String data = "3,14";
        Scanner sc = new Scanner(data);
        sc.useLocale(java.util.Locale.FRANCE);
        double pie = sc.nextDouble();
        System.out.println("pie : "+ pie);
    }
}
