class BankAccount {
    private double balance;
    private final double maxBalance;

    public BankAccount (double initialBalance, double maxBalance) {
        this.balance = initialBalance;
        this.maxBalance = maxBalance;
    }

    public synchronized void deposit(double amount){
        while (maxBalance > 0 && balance + amount > maxBalance) {
            try{ wait();}
            catch(InterruptedException e){ 
                Thread.currentThread().interrupt();
                return;
            }
        }
         balance += amount;
        System.out.println(Thread.currentThread().getName() +  " deposit: " + amount + ", balance: " + balance);

        notifyAll();
    }

    public synchronized void withdraw(double amount){
        if(amount > balance){
            try{ wait(); } 
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdraw: " + amount + ", balance: " + balance);

        notifyAll();
    }

    public synchronized double getBalance(){
        return balance;
    }
}

class Depositor implements Runnable {
    private BankAccount account;

    public Depositor(BankAccount account){
        this.account = account;
    }

    @Override
    public void run() {
        java.util.Random r = new java.util.Random();

        while (true) {
            double amount = 10 + r.nextInt(91);
            account.deposit(amount);

            try{ Thread.sleep(100);}
            catch(InterruptedException e){ return; }
        }
    }
}

class Withdrawer implements Runnable {
    private BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }
    @Override
    public void run() {
        java.util.Random r = new java.util.Random();

        while (true) {
            double amount = 10 + r.nextInt(71);
            account.withdraw(amount);

            try { Thread.sleep(100);}
            catch(InterruptedException e){ return;}
        }
    }
}
public class Bank {
    public static void main(String []a){
        BankAccount account = new BankAccount(100, 500);

        Thread t1 = new Thread(new Depositor(account), "Depositor-1");
        Thread t2 = new Thread(new Withdrawer(account), "Withdrawer-1");

        t1.start();
        t2.start();
    }
}
