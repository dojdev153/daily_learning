import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Readline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.println("enter your inputs, type");

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if(line.equalsIgnoreCase("exit"))
               break;
            System.out.println("you entered : " + line);
        }
        
    }
    
 