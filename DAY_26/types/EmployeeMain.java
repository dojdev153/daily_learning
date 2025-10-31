package DAY_26.types;
import java.util.*;
public class EmployeeMain {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bod", 25, 600000));
        employees.add(new Employee("Rahil", 28, 550000));

        System.out.println("=== Og List ===");
        System.out.println(employees);

        Collections.sort(employees, new CompareByAge());
        System.out.println("\n==== Sorted by age(asc) ===");
        System.out.println(employees);

        Collections.sort(employees, new CompareBySalary());
        System.out.println("\n=== sorted by salary(desc) ===");
        System.out.println(employees);
    }
}
