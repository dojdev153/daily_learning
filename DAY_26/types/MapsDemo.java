package DAY_26.types;
import java.util.*;
public class MapsDemo {
    public static void main(String[] args) {
        Map<String, Integer> marks = new HashMap<>();
        String name = "alice";
        String Alice = name.toLowerCase();
                
        marks.put("Bob", 85);
        marks.put("alice", 78);
        marks.put("Rahil", 90);

        System.out.println("Here are the students with their makrs");
        System.out.println("Bob's makrs: " + marks.get("bob".toLowerCase()));

        for(Map.Entry<String, Integer> entry : marks.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value:  " + entry.getValue());
        }

        System.out.println("Has Alice? " + marks.containsKey("Alice".toLowerCase()));
    }
}
