import java.io.*;
import java.util.*;

public class CountLine {
    public static void main(String[] args) {
        File file = new File("D:\\NOTES\\mine\\JAVA\\STREAMS_SUMMARY.txt");
        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            int lineCount = 0;
            String line;
            
            while ((line = in.readLine()) != null) {
                if(!line.trim().isEmpty())
                    lineCount++;
            }
            System.out.println("Total Lines: " + lineCount);
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();

        }
    }
}
