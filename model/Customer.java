package model;

import java.util.*;

public class Customer {

    private String customerId;
    private String name;
    private List<Account> accounts;

    // Parameterized Constructor
    public Customer(String customerId, String name){
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Add Account Method
    public void addAccount(Account account){
        accounts.add(account);
    }

    // Get All Accounts Method
    public List<Account> getAccounts() {
        return accounts;
    }

    // Getter Method
    public String getCustomerId(){
        return customerId;
    }
    
    // Getter Method to get name
    public String getName(){
        return name;
    }
}