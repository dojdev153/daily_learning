package DAY_25.Exe_1;
 class Student{
    public static int count = 0;

    public Student(){
        count++;
    }

    static void displayCount(){
        System.out.println("here're the total number of students: " + count);
    }
}

public class Static {
    public static void main(String[] a){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        Student.displayCount();
    }
}
