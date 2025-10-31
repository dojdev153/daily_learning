package DAY_26.types;
import java.util.*;

public class CompareByAge implements Comparator<Employee>{
    @Override
    public int compare(Employee emp1, Employee emp2){
        // return emp1.getAge() - emp2.getAge();
        if(emp1.getAge() < emp2.getAge())
            return -1;
        if(emp1.getAge() > emp2.getAge()) 
           return 1;
        return 0;
    }    
}
