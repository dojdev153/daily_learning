package DAY_26.JCF;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> namesHash = new HashMap<>();
        Map<String, Integer> nameLinked = new LinkedHashMap<>();
        Map<String, Integer> nameTree = new TreeMap<>();
        
        namesHash.put("yui", 2);
        namesHash.put("Raus", 1);
        namesHash.put("nikolas", 3);

        nameLinked.putAll(namesHash);
        nameTree.putAll(namesHash);

        System.out.println("HashMap: " + namesHash);
        System.out.println("LinkedHashMap: "+ nameLinked);
        System.out.println("TreeMap: " + nameTree);
    }
}
