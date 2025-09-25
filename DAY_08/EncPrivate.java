 class Student{
    private String Lname = "john";
    private String Fname = "doe";
    
    public String getName(){
        return Lname + " " + Fname;
    }
    

}

public class EncPrivate{
    public static void main(String[] a){
        Student s1 = new Student();
        s1.getName();
    }
}