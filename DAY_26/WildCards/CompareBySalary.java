package DAY_26.WildCards;
import java.util.*;
public class CompareBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2){
        return Double.compare(emp1.getSalary(), emp2.getSalary());
    }    
}
