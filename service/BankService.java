package service;

import model.*;
import java.util.*;

import exception.InsufficientBalanceException;

public class BankService {
    
    private Map<String, Customer> customers;
    private Map<String, Account> accounts;

    // Constructor
    public BankService(){
        customers = new HashMap<>();
        accounts = new HashMap<>();
    }

    // Method to Create Customer
    public Customer createCustomer(String name){
        String customerId = UUID.randomUUID().toString();

        Customer customer = new Customer(customerId, name);
        customers.put(customerId, customer);

        return customer;
    }

    // Method to Create Account
    public Account createAccount(String customerId, String type)
    {
        Customer customer = customers.get(customerId);
        
        if(customer == null) throw new IllegalArgumentException("Customer not Found");

        String accountNumber = UUID.randomUUID().toString();
        Account account;

        if(type.equals("SAVINGS")){
            account = new SavingsAccount(accountNumber, 3.5);
        } else if (type.equals("CURRENT")){
            account = new CurrentAccount(accountNumber, 1500);
        } else {
            throw new IllegalArgumentException("Invalid Account type");
        }

        accounts.put(accountNumber, account);
        customer.addAccount(account);

        return account;
    }

    // Method to Deposit
    public void deposit(String accountNumber, double amount){
        Account account = accounts.get(accountNumber);

        if(account == null) throw new IllegalArgumentException("Account not Found");

        account.deposit(amount);
    }

    // Method to Withdraw
    public void withdraw(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = accounts.get(accountNumber);

        if(account == null) throw new IllegalArgumentException("Account not found");
        
        account.withdraw(amount);
    }

    // Check Balance Method
    public double checkBalance(String accountNumber){
        Account account = accounts.get(accountNumber);

        if(account == null) throw new IllegalArgumentException("Account not found");

        return account.getBalance();
    }

    // Method to get transaction history
    public List<Transaction> geTransactionHistory(String accountNumber){
        
        Account account = accounts.get(accountNumber);
        
        if(account == null) throw new IllegalArgumentException("Account not found");
        
        return account.getTransactions();
    }
}
