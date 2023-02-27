package com.eteration.simplebanking.model;


import java.time.LocalDateTime;

// This class is a place holder you can change the complete implementation
public abstract class Transaction {
    protected LocalDateTime date;
    protected double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
