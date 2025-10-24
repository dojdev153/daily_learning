package DAY_24;
import java.util.*;

public class YearAcoll {
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        c.add(15);
        c.add(12);
        c.add(13);
        c.add(31);

        int first = c.get(0);
        System.out.println("Here's the first element: " + first);

        System.out.println("Values multiplied by 2:");
        Iterator<Integer> it = c.iterator();
        while(it.hasNext()){
            int values = it.next();
            System.out.println(values * 2);
        }

        Collections.sort(c);
        System.out.println("Sorted list:");
        for(int val : c){
            System.out.println(val);
        }
    }
}
