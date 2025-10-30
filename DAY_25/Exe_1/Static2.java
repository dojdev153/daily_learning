package DAY_25.Exe_1;

class BankAccount{
    public static double interestRate = 0.02;

    double balance;

    BankAccount(double balance){
        this.balance = balance;
    }

    double calcInterest(){
        return balance * interestRate;
    }
    void displayInterest(){
        System.out.println("balance: " + balance + " $");
        System.out.println("Interest rate: " + interestRate + " %");
        System.out.println("Interest: " + calcInterest() + " $");
        System.out.println("_______________________________________");
    }
}
public class Static2 {
    public static void main(String a[]){
        BankAccount acc1 = new BankAccount(1000);
        BankAccount acc2 = new BankAccount(2000);
        BankAccount acc3 = new BankAccount(3000);

        System.out.println("============Rate: 0.02%=============");

        acc1.displayInterest();
        acc2.displayInterest();
        acc3.displayInterest();

        System.out.println("============Rate: 0.05%=============");

        BankAccount.interestRate = 0.05;

        acc1.displayInterest();
        acc2.displayInterest();
        acc3.displayInterest();
    }
}
