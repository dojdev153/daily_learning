import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] a){
        int n1=0,n2=1,n3;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of terms");
        int terms = sc.nextInt();
        System.out.println("fibonacci series" + " "+ "up to " + terms + " terms.");
        System.out.print(n1 +" "+n2+"");
        for(int i=3;i<=terms;i++){
            n3=n1+n2;
            System.out.print(n3 + " ");
            n1=n2;
            n2=n3;
        }
    }
}