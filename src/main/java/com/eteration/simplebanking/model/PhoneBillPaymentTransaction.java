package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends WithdrawalTransaction{

    private String payee;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(double amount) {
        super(amount);
    }

    public PhoneBillPaymentTransaction(String payee, String phoneNumber, double amount) {
        super(amount);
        this.payee = payee;
        this.phoneNumber = phoneNumber;
    }
}
