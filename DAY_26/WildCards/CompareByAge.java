package DAY_26.WildCards;
import java.util.*;

public class CompareByAge implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2){
        return emp1.getAge() - emp2.getAge();
    }    
}
