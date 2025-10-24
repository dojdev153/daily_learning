import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Streams {
    public static void main(String[] args) {
        String sourcePath = "D:\\NOTES\\mine\\JAVA\\HelloWorld.java";
        String destPath = "D:\\NOTES\\mine\\JAVA\\copy2.txt";

        try(
            BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destPath));
        ){
            String line;
            while((line = reader.readLine()) != null){
                writer.write(line);
            }
            reader.close();
            writer.close();
            System.out.println("File copied successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    
}
}
