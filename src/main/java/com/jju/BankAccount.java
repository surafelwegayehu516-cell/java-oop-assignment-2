package com.jju;
public class BankAccount {
    private String accountHolder;
    protected double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        if (initialBalance < 0) {
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    // Getter
    public double getBalance() {
        return balance;
    }
}
























