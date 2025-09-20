class Animal{
      void makingSound(){
        System.out.println("making sound");
      }
}
class Dog extends Animal{
     void bark(){
         System.out.println("barking");
     }
}
public class Cast2{
    public static void main(String[] args){
        System.out.println("upcasting");
        Animal a = new Dog();
        a.makingSound();

        if(a instanceof Dog){
            Dog d = (Dog)a;
            d.bark();
        }else{
            System.out.println("not a dog");
        }
    }
}