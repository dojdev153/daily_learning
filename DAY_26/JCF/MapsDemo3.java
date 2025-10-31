package DAY_26.JCF;
import java.util.*;

class Student{
    String name;
    Student(String name){
          this.name = name;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.name.equals(other.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public String toString(){
        return name;
    }
}

public class MapsDemo3 {
    public static void main(String[] args) {
        Map<Student, Integer> players = new HashMap<>();

        Student name1 = new Student("Shai");
        Student name2 = new Student("Shai");
        Student name3 = new Student("Anthony");


        players.put(name1, 51);
        players.put(name2, 36);
        players.put(name3, 41);

        System.out.println(players.size());
        System.out.println(players);
    }
}
