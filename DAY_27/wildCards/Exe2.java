package DAY_27.wildCards;
import java.util.*;

class Summing{
    
    public static double sumList(List<? extends Number> nums){
        double sum = 0.0;
        for(Number n:nums){
            sum += n.doubleValue();
        }
        return sum;
    }
    

}

public class Exe2 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(12,12);
        double sumOfInt = sumList(intList);
        System.out.println("sum of int: " + sumOfInt);
        
    }
}
