         package com.arg.bank;
         import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String id;
    private String password;
    private double balance;

    public Account(String id, String password, double initialBalance) {
        this.id = id;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getId() {
        return id;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class BankSystem {
    private HashMap<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter ID: ");
        String id = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        if (!accounts.containsKey(id)) {
            accounts.put(id, new Account(id, password, initialBalance));
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account ID already exists.");
        }
    }

    public Account login() {
        System.out.print("Enter ID: ");
        String id = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        Account account = accounts.get(id);
        if (account != null && account.authenticate(password)) {
            System.out.println("Login successful.");
            return account;
        }
        System.out.println("Invalid ID or password.");
        return null;
    }

    public void deposit(Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + account.getBalance());
    }

    public void withdraw(Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance(Account account) {
        System.out.println("Current balance: " + account.getBalance());
    }

    public void start() {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    Account account = login();
                    if (account != null) {
                        manageAccount(account);
                    }
                    break;
                case 3:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void manageAccount(Account account) {
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    deposit(account);
                    break;
                case 2:
                    withdraw(account);
                    break;
                case 3:
                    checkBalance(account);
                    break;
                case 4:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

public class Sample {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        bankSystem.start();
    }
}
