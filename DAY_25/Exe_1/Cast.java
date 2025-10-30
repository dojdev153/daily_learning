package DAY_25.Exe_1;
public class Employee{
    void work(){
        System.out.println("i'm working");
    }
}

public class Manager extends Employee{
    void conductMeeting(){
        System.out.println("i'm conducting a meeting");
    }
}

public class Cast {
    public static void main(String[] args) {
        Employee emp = new Manager();
        emp.work();
        Manager mgr = (Manager)emp;
        mgr.conductMeeting();
    }
}
