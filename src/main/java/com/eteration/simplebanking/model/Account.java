package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import java.util.List;

public class Account {
    private String owner;
    private String accountNumber;
    private double balance = 0;
    private List<Transaction> transactions;

    public Account(String owner, String accountNumber) {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    //credit
    public void deposit(double amount) {
        balance += amount;
    }

    //debit
    public void withdraw(double amount) throws InsufficientBalanceException {
        if(amount<balance){
            balance -= amount;
        }
        else{
            throw new InsufficientBalanceException("Bakiye Yetersizdir!");
        }
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        if(transaction instanceof WithdrawalTransaction){
            withdraw(transaction.getAmount());
        }
        else if(transaction instanceof DepositTransaction) {
            deposit(transaction.getAmount());
        }
        transactions.add(transaction);
    }
}
