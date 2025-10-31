package DAY_26.JCF;
import java.util.*;
public class CompareBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2){
        return Double.compare(emp2.getSalary(), emp1.getSalary());
    }    
}
