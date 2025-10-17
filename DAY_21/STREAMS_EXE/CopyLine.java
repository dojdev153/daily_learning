import java.io.*;

public class CopyLine {
    public static void main(String[] args) {
        File sourcFile = new File("D:\\NOTES\\mine\\JAVA\\STREAMS_SUMMARY.txt");
        File destFile = new File("D:\\NOTES\\mine\\JAVA\\new.txt");
        try(
            BufferedReader in = new BufferedReader(new FileReader(sourcFile));
            BufferedWriter out = new BufferedWriter(new FileWriter(destFile))
            ){
                String line;
                while ((line = in.readLine()) != null) {
                    out.write(line);
                    out.newLine();
                }
                System.out.println("file copied successfully!");
            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
