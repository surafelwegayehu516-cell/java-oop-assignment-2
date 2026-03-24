package com.jju;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("--- 🏦 Bank System Simulation ---\n");

        // 1. Create a Savings Account
        // Starting with $200 and a 10% (0.10) interest rate
        SavingsAccount mySavings = new SavingsAccount("Alice", 200.0, 0.10);
        System.out.println("Initial Savings: $" + mySavings.getBalance());
        mySavings.applyInterest();
        System.out.println("Savings after interest: $" + mySavings.getBalance());

        System.out.println("\n----------------------------------\n");

        // 2. Create a Checking Account
        // Starting with $100 (Withdrawal fee is usually internal to the class)
        CheckingAccount myChecking = new CheckingAccount("Bob", 100.0);
        System.out.println("Initial Checking: $" + myChecking.getBalance());
        
        // This should trigger a fee (e.g., $40 + $1.50 fee = $41.50 total deduction)
        myChecking.withdraw(40.0);
        System.out.println("Checking after $40 withdrawal: $" + myChecking.getBalance());

        System.out.println("\n----------------------------------\n");

        // 3. Demonstrating Polymorphism
        // We can put different account types into one list
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(mySavings);
        accounts.add(myChecking);
        accounts.add(new BankAccount("Charlie", 500.0));

        System.out.println("Processing all accounts in the system:");
        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getAccountHolder() + 
                               " | Balance: $" + acc.getBalance());
        }
    }

}


