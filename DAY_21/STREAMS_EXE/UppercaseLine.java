import java.io.*;

public class UppercaseLine {
    public static void main(String[] args) {
        File file = new File("D:\\NOTES\\mine\\JAVA\\copy1.txt");
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = in.readLine()) != null) {
                String upper = line.toUpperCase();
                System.out.println(upper);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
