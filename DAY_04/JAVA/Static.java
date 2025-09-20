class Student{
    static int count = 0;
    Student(){
        count++;
    }
    static void displayCount(){
        System.out.println("here are the total number of students" +" "+ count++);
    }
}

public class Static{
    public static void main(String[] args){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        Student.displayCount();
    }
}