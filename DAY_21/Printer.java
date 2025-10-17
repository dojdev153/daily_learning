 import java.io.*;
 class Printer{
        public static void main(String[] a){
            File file = new File("D:\\NOTES\\mine\\JAVA\\copy1.txt");
            try(PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
                writer.println("dont miss");
                writer.println("see you then ...");
            }catch(IOException e){
                e.printStackTrace();
            }
            
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;
                while((line = reader.readLine()) != null){
                    System.out.println(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

