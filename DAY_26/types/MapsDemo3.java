package DAY_26.types;

import java.util.*;

public class MapsDemo3 {
    public static void main(String[] args) {
        Map<String, Integer> players = new HashMap<>();

        String name1 = new String("Shai");
        String name2 = new String("Shai");
        String name3 = new String("Anthony");

        System.out.println("are they of the same objects? " + name1 == name2);
        System.out.println("do they have the same content? " + name1.equals(name2));

        players.put(name1, 51);
        players.put(name1, 36);
        players.put(name3, 41);

        System.out.println(players);
    }
}
