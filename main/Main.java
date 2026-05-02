package main;

import exception.InsufficientBalanceException;
import model.Account;
import model.Customer;
import service.BankService;

public class Main {
    public static void main(String[] args) {
        
        BankService bankService = new BankService();

        // Create Customer
        Customer customer = bankService.createCustomer("Rahul");
        System.out.println("Customer Created : " + customer.getCustomerId());

        // Create Account
        Account account = bankService.createAccount(customer.getCustomerId(), "SAVINGS");
        System.out.println("Account Created : " + account.getAccountNumber());

        // Deposit
        bankService.deposit(account.getAccountNumber()
        , 5000);
        System.out.println("Balance after Deposit : "+bankService.checkBalance(account.getAccountNumber()));

        // Withdraw
        try{
            bankService.withdraw(account.getAccountNumber(), 2000);
            System.out.println("Balance after Withdrawal : " + bankService.checkBalance(account.getAccountNumber()));
        } catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }

        // Over-Withdraw Test
        try{
            bankService.withdraw(account.getAccountNumber(), 10000);
        } catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }

        // Transaction History
        System.out.println("Transaction History : ");
        bankService.geTransactionHistory(account.getAccountNumber()).forEach(System.out::println);
    }    
}