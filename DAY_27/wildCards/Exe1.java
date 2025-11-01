package DAY_27.wildCards;
import java.util.*;

class Ball<T>{
    private T value;
    Ball(T value){
        this.value = value;
    }
    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }

    public static void printList(List<?> elements){
        for(Object obj : elements){
            System.out.println(obj);
        }
    }
}

public class Exe1 {
    public static void main(String[] args) {
          List<Integer> nums = Arrays.asList(10,20,30,40);
          List<String> names = Arrays.asList("paddling","jordan","michael","antony");

          System.out.println("printing names: ");
          Ball.printList(names);

          System.out.println("balls numbers: ");
          Ball.printList(nums);
    }
}
