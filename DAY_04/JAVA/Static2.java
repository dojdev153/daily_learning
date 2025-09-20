class BankAccount {
    String username;
    double balance;
    static double interestRate = 0.01;

    BankAccount(String name, double balance) {
        this.username = name;
        this.balance = balance;
    }

    double calcInterest() {
        return balance * interestRate;
    }

    static void setInterestRate(double newRate) {
        interestRate = newRate;
    }
}

public class Static2 {
    public static void main(String[] args) {
        BankAccount ac1 = new BankAccount("Alice", 1000);
        BankAccount ac2 = new BankAccount("Bob", 2000);

        System.out.println("Interest for Alice: " + ac1.calcInterest());
        System.out.println("Interest for Bob: " + ac2.calcInterest());

        BankAccount.setInterestRate(0.5);
        System.out.println("After interest rate change:");
        System.out.println("Interest for Alice: " + ac1.calcInterest());
        System.out.println("Interest for Bob: " + ac2.calcInterest());
    }
}
