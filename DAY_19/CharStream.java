import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Streams {
    public static void main(String[] args) {
        String sourcePath = "D:\\NOTES\\mine\\JAVA\\HelloWorld.java";
        String destPath = "D:\\NOTES\\mine\\JAVA\\copy1.txt";

        try{
             File destFile = new File(destPath);
             destFile.getParentFile().mkdirs();

            FileReader reader = new FileReader(sourcePath);
            FileWriter writer = new FileWriter(destPath);

            int character;
            while((character = reader.read()) != -1){
                writer.write(character);
            }
            reader.close();
            writer.close();
            System.out.println("File copied successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    
}
}
