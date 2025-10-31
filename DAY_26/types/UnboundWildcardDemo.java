package DAY_26.types;
import java.util.*;

public class UnboundWildcardDemo {
    static void printList(List<?> list){
        for(Object o : list){
            System.out.println(o + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3);
        List<String> names = Arrays.asList("Bob", "Charlie");

        System.out.print("ints:   \n");  printList(ints);
        System.out.print("names:  \n");  printList(names);
    }
}
