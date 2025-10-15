import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class CharStreams{
    public static void main(String[] args) {
        String sourcePath = "D:\\NOTES\\mine\\daily_learning\\daily_learning\\DAY_01\\pygame_arduino\\joystick-01.py";
        String destPath = "D:\\NOTES\\mine\\daily_learning\\daily_learning\\DAY_20\\STREAMS\\newCharFile.txt";
        try(
            FileReader in = new FileReader(sourcePath);
            FileWriter out = new FileWriter(destPath);
        ){
           
            int character;
            while ((character = in.read()) != -1) {
                out.write(character);
            }
            System.out.println("successfully copied the file!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}