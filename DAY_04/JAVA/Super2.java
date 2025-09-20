class Person{
   void displayInfo(){
      System.out.println("I am a person");
   }
}

class Student extends Person{
    void showInfo(){
            super.displayInfo();
    }
}

public class Super2{
    public static void main(String[] args){
        Student s1 = new Student();
        s1.showInfo();
    }
}