package DAY_26.types;

import java.util.*;

public class Upper2 {
    public static double sumOfList(List<? extends Number> list){
        double sum = 0.0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }
    public static void main(String[] args) {
          List<Integer> intList = Arrays.asList(12,4,5,6,78);
          double sumOfInt = sumOfList(intList);
          System.out.println("sum of integers: " + sumOfInt);

          List<Double> doubleList = Arrays.asList(12.4,41.2,67.3);
          double sumOfdouble = sumOfList(doubleList);
          System.out.println("sum of doubles: " + sumOfdouble);
    }
}
