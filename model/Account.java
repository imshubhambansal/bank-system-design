// Abstract Class Account

package model;

import java.util.*;
import java.lang.IllegalArgumentException;
import exception.InsufficientBalanceException;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions;

    // Parameterized Constructor
    public Account(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // Deposit Method
    public void deposit(double amount){
        
        // Amount validity check
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Deposit Amount");
        }
        
        // Balance update
        balance += amount;

        // Transaction Creation
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), "DEPOSIT", amount);

        // Transaction added to history
        transactions.add(transaction);
    }

    // Withdraw Method
    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    
    // Transaction history Method
    public List<Transaction> geTransactions() {
        return transactions;
    }

    // Get balance Method
    public double getBalance(){
        return balance;
    }
    
    // Get Transaction Method
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Get Account Number Method
    public String getAccountNumber(){
        return accountNumber;
    }
}