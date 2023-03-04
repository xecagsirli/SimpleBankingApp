package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount) {
        super(amount);
        setType("Withdrawal Transaction");
        setApprovalCode("a66cce54-335b-4e46-9b49-05017c4b38dd");
    }
}
