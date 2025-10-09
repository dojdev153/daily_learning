package DAY_18;

import java.util.Scanner;

class Person {
    private int id;
    public String name;
    private String dob;

    public Person(int id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }
}

class Account extends Person {
    private String accountNumber;
    private double balance = 0;
    public Account(int id, String name, String dob, String accountNumber) {
        super(id, name, dob);
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Deposit amount cannot be negative.");
        }
        this.balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }

    public void withdraw(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Withdrawal amount cannot be negative.");
        }
        if (this.balance < amount) {
            throw new Exception("Not enough balance to withdraw.");
        }
        this.balance -= amount;
        System.out.println("Successfully withdrew: " + amount);
    }

    public void showBalance() {
        System.out.println("Your current balance: " + balance);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Banking App!");

        int id = 0;
        while (true) {
            try {
                System.out.print("Enter your ID: ");
                id = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        }

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your date of birth(YYYY-MM-DD): ");
        String dob = sc.nextLine();

        System.out.print("Enter your account number: ");
        String accountNumber = sc.nextLine();

        Account userAccount = new Account(id, name, dob, accountNumber);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1-4.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            System.out.print("Enter amount to deposit: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            userAccount.deposit(amount);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            userAccount.withdraw(amount);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    userAccount.showBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the Banking App. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }

        sc.close();
    }
}
