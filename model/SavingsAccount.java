package model;

import java.util.UUID;
import exception.InsufficientBalanceException;

public class SavingsAccount extends Account{

    private double interestRate;

    // Parameterized Constructor
    public SavingsAccount(String accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // Getter Method to get Interest Rate
    public double getInterestRate(){
        return interestRate;
    }

    // Withdraw Method
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException{

        // Validate Amount
        if(amount <= 0) throw new IllegalArgumentException("Invalid Withdrawal Amount");
        
        // Check Balance (No Overdraft allowed)
        if(amount > balance) throw new InsufficientBalanceException("Insufficient Balance");

        // Deduct Balance
        balance -= amount;

        // Create Transaction
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), "WITHDRAW", amount);

        // Add to transaction history
        transactions.add(transaction);
    }
}