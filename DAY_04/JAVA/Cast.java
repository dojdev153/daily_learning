class Employee{
    void work(){
        System.out.println("working");
    };

}
class Manager extends Employee{
    void conductMeeting(){
        System.out.println("conducting meeting");
    };
}

public class Cast{
    public static void main(String[] a){
        System.out.println("upcasting");
        Employee emp = new Manager();
        emp.work();
        System.out.println("downcasting");
        Manager mgr = (Manager)emp;
        mgr.conductMeeting();
    }
}