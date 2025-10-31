package DAY_26.Collections;
import java.util.*;

class Student{
    String name;
    int marks;

    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    void dispaly(){
        System.out.println("Name: " + name + " , Marks: " + marks);
    }
}

public class Intro2 {
    public static void main(String a[]){
        //create an arraylist to store student objects
        ArrayList<Student> students = new ArrayList<>();

        //add student objects
        students.add(new Student("Rahit", 85));
        students.add(new Student("Rahus", 92));
        students.add(new Student("Charlie", 78));

        //display all students
        System.out.println("All Students with theri makrs: ");
        for(Student s : students){
            s.dispaly();
        }

        //access individual objects
        Student fStudent = students.get(0);
        System.out.println("first Student: " + fStudent.name + " Marks: " + fStudent.marks);
    }
}
