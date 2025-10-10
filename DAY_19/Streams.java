import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

public class Streams {
    public static void main(String[] args) {
        String sourcePath = "D:\\NOTES\\mine\\JAVA\\HelloWorld.java";
        String destPath = "D:\\NOTES\\mine\\JAVA\\copy.txt";

        try{
             File destFile = new File(destPath);
             destFile.getParentFile().mkdirs();

            FileInputStream in = new FileInputStream(sourcePath);
            FileOutputStream out = new FileOutputStream(destPath);

            int byteData;
            while((byteData = in.read()) != -1){
                out.write(byteData);
            }
            in.close();
            out.close();
            System.out.println("File copied successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    
}
}
