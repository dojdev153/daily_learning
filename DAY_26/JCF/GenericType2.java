package DAY_26.JCF;
import java.util.*;

class Pair<K, V>{
    K key;
    V value;

    Pair(K Key, V value){
        this.key = key;
        this.value = value;
    }

}

class Data<T extends Number>{
    T num;
    Data(T num){
        this.num = num;
    }
    double square(){
        return num.doubleValue() * num.doubleValue();
    }
}
public class GenericType2 {
    public static void main(String[] args) {
        Pair<String, Integer> Pairs = new Pair<>("alice", 85);
        System.out.println(Pairs.key + " "+ Pairs.value);

        Data<Integer> d1 = new Data<>(5);
        System.out.println(d1.square());
    }
}
