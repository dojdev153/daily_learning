import java.io.*;
public class DataStream{
    public static void main(String a[]){
        File file = new File("D:\\NOTES\\mine\\JAVA\\DataStreams.txt");
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file))){
            out.writeInt(7);
            out.writeBoolean(false);
            out.writeUTF("hello brother");
        }catch(IOException e){
            e.printStackTrace();
        }
         try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            int num = in.readInt();
            boolean flag = in.readBoolean();
            String mesg = in.readUTF();

            System.out.println("Data read from file:");
            System.out.println("Integer: " + num);
            System.out.println("Boolean: " + flag);
            System.out.println("String: " + mesg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}