package DAY_26.JCF;
import java.util.*;

class Box<T>{
    private T value;
    public Box(){
        this.value = value
    }

    public getValue(){
        return value
    }
    public setValue(T value){
        this.value = value;
    }
    public void processWild(List<? super Number> box){

    }
}
public class Lower2 {
    public static void main(String[] args) {
        Box<Object> nameBox = new Box<>("Box_A1");
        Box<Number> numBox = new Box<>(3);

    }
}
