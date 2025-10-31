package DAY_26.types;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Alice","Bob","Charlie"));
        System.out.println(names.get(0));
        System.out.println(names);
    }
}
