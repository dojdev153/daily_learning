import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuffStreams {
    public static void main(String[] args) {
        String sourcePath = "D:\\projects\\HTML_CSS_JS\\gaming_webiste\\zentry-copy-one\\index.html";
        String destPath = "D:\\NOTES\\mine\\daily_learning\\daily_learning\\DAY_20\\STREAMS\\newBufferFile.txt";

        try(
               BufferedReader in = new BufferedReader(new FileReader(sourcePath));
               BufferedWriter out = new BufferedWriter(new FileWriter(destPath));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.newLine();
            }
            System.out.println("successfully copied file!");
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
