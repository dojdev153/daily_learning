package DAY_26.JCF;
import java.util.*;

class Box<T>{
    private T value;
    void set(T value){
        this.value = value;
    }
    T get(){
        return value;
    }
    public static <T> void display(T item){
        System.out.println(item);
    }

}

public class GenericType {
    public static void main(String[] args) {
        Box<String> nameBox = new Box<>();
        nameBox.set("Box_A1");
        System.out.println(nameBox.get());

        Box<Integer> numberBox = new Box<>();
        numberBox.set(42);
        System.out.println(numberBox.get());

        Box.display("Hello world");
    }
}
