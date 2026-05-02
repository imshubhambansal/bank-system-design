package model;

import java.util.UUID;
import exception.InsufficientBalanceException;

public class CurrentAccount extends Account{

    private double overdraftLimit;

    // Parameterized Constructor
    public CurrentAccount(String accountNumber, double overdraftLimit){
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    // Getter method to get Overdraft Limit
    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    // Withdraw Method
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException{

        // Validate Amount
        if(amount <= 0) throw new IllegalArgumentException("Invalid Withdrawal Amount");

        // Check Balance + Overdraft
        if(amount > balance + overdraftLimit) throw new InsufficientBalanceException("Exceeded Overdraft Limit");

        // Deduct Balance
        balance -= amount;

        // Create Transaction
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), "WITHDRAW", amount);

        // Store Transaction
        transactions.add(transaction);
    }
}