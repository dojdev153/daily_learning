package DAY_26.JCF;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            System.out.println("invalid name!");
        }
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }else{
            System.out.println("Invalid age!");
        }
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        if(salary >=0){
            this.salary = salary;
        }else{
            System.out.println("Invalid salary!");
        }
    }

    @Override
    public String toString(){
        return name + " (Age: " + age + " , Salary: " + salary + ")";
    }
}
