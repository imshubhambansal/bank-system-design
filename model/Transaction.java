// Transaction Class

package model;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private String type; // DEPOSIT or WITHDRAW
    private double amount;
    private LocalDateTime timestamp;

    // Parameterized Constructor
    public Transaction(String transactionId, String type, double amount){
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Getter method to get transaction id
    public String getTransactionId(){
        return transactionId;
    }

    // Getter method to get type of transaction
    public String getType(){
        return type;
    }

    // Getter method to get transaction amount
    public double getAmount() {
        return amount;
    }

    // Getter method to get time stamp of transaction
    public LocalDateTime getTimeStamp(){
        return timestamp;
    }

    @Override
    public String toString(){
        return "Transaction{" + "id = " + transactionId + "type = " + type + "amount = " + amount + "time = " + timestamp + "}";
    }
    
}
