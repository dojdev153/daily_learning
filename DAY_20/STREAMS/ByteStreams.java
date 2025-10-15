import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreams {
    public static void main(String[] args) {
        String sourcePath = "D:\\NOTES\\mine\\daily_learning\\daily_learning\\DAY_01\\pygame_arduino\\pong_game.py";
        String destPath = "D:\\NOTES\\mine\\daily_learning\\daily_learning\\DAY_20\\STREAMS\\newFile.txt";

        try(
            FileInputStream in = new FileInputStream(sourcePath);
            FileOutputStream out = new FileOutputStream(destPath);
        ){
            int byteData;

            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
            System.out.println("Data copied successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
