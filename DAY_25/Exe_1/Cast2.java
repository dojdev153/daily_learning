package DAY_25.Exe_1;
public class Animal{
    void makeSound(){
        System.out.println("i make sound brother!");
    }
}
public class Lion extends Animal{
    void Roar(){
        System.out.println("I Roar brother!");
    }
}

public class Cast2 {
    public static void main(String []a){
        Animal a1 = new Lion();
        a1.makeSound();
        Lion l1 = (Lion)a1;
        l1.Roar();
    }
}
