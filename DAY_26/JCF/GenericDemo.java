package DAY_26.JCF;
class Box<T>{
    private T value;

    public void set(T value){
        this.value = value;
    }
    public T get(){
        return value;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}

public class GenericDemo {
    public static void main(String[] args) {
        Box<String> nameBox = new Box<>();
        nameBox.set("Alice");
        System.out.println("String box: " + nameBox.get());

        Box<Integer> numberBox = new Box<>();
        numberBox.set(42);
        System.out.println("Integer box: " + numberBox.get());
    }
}
