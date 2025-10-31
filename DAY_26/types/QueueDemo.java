package DAY_26.types;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> names = new LinkedList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println(names.peek());
        System.out.println(names.poll());
        System.out.println(names);
    }
}
