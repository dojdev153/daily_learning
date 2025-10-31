package DAY_26.Collections;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student other){
        return this.marks - other.marks;
    }
    //from object class, overiden to prevent it from bringing hashcode of the object, anonymous class
    public String toString(){
        return name + " (" + marks + ")";
    }
}

public class Comparable1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));

        System.out.println("Before sorting: ");
        System.out.println(students);

        Collections.sort(students);

        System.out.println("After sorting by marks: ");
        System.out.println(students);

    }
}
