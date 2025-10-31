package DAY_26.Collections;
import java.util.*;
public class Intro {
    public static void main(String a[]){
          System.out.println("============ ArrayList ============");
          ArrayList<String> names = new ArrayList<>();
          names.add("Rahit");
          names.add("Rahul");
          String name = names.get(0);
          System.out.println("Name: " + name);
          System.out.println("Size: " + names.size());

          System.out.println("============ List ==========");
          List<String> List = new ArrayList<>();
          List.add("Rahit");
          List.add("Rahul");
          String name2 = List.get(0);
          System.out.println("Name: " + name2);
          System.out.println("Size: " + List.size());

    }
}
