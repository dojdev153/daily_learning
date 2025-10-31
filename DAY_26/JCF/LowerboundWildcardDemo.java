package DAY_26.JCF;

import java.util.ArrayList;
import java.util.List;

public class LowerboundWildcardDemo {
    static void addSomeInt(List< ? super Integer> list){
        list.add(100);
        list.add(200);
        list.add(300);
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        List<Number> nums = new ArrayList<>();
        List<Object> objs = new ArrayList<>();

        addSomeInt(ints);
        addSomeInt(nums);
        addSomeInt(objs);

        System.out.println("ints: " + ints);
        System.out.println("nums: " + nums);
        System.out.println("objs: " + objs);
    }
}
