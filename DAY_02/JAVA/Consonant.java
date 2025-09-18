import java.util.Scanner;
public class Consonant {
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the character");
        char ch = sc.next().toLowerCase().charAt(0);
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("vowerl");
                break;
            default:
                if(ch >='a' && ch <='z'){
                    System.out.println("consonant");
                }else{
                    System.out.println("invalid input");
                }    
        }
    }
}