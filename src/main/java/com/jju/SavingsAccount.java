package com.jju;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    // Apply interest
    public void applyInterest() {
        double interest = balance * interestRate;
        this.deposit(interest); // reuse deposit logic
    }
}

