import java.io.*;
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Sonny","Uwase");
        File file = new File("D:\\NOTES\\mine\\JAVA\\Student.ser");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(s1);
        }catch(IOException e){
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            Student s2 = (Student) in.readObject();
            System.out.println(s2.getFname() + " " + s2.getLname());
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
