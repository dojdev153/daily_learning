package DAY_09;

class BankAccount{
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println(amount + "deposited. New balance: " + balance);
    }
    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        }else{
            System.out.println("Insufficient funds!");
        }
    }
}



public class Bank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("12345", 1000);
        acc1.deposit(500);
        acc1.withdraw(200);
        System.out.println("Final balance: " + acc1.getBalance());
    }
}
