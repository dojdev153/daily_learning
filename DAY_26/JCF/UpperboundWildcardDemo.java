package DAY_26.JCF;
import java.util.*;

public class UpperboundWildcardDemo {
    static double sumNumbers(ListDemo<? extends Number> nums){
        double sum = 0.0;
        for(Number n : nums){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        ListDemo<Integer> ints = Arrays.asList(10,20,30);
        ListDemo<Double> doubles = Arrays.asList(1.5,2.5,3.0);

        System.out.println("sum of ints: " + sumNumbers(ints));
        System.out.println("sum of doubles: " + sumNumbers(doubles));
    }
}
