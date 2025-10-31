package DAY_26.types;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        Set<String> names2 = new LinkedHashSet<>();
        Set<String> names3 = new TreeSet<>();
        
        names.add("xhai");
        names.add("shai");
        names.add("shant");

        names2.addAll(names);
        names3.addAll(names);

        System.out.println("HashSet names: " + names);
        System.out.println("LinkedHashSet names: " + names2);
        System.out.println("TreeSet names: " + names3);
    }
}
