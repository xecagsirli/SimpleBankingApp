package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
        setType("Deposit Transaction");
        setApprovalCode("67f1aada-637d-4469-a650-3fb6352527ba");
    }
}
