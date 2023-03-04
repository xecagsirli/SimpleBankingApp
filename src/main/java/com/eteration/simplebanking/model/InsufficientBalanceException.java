package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation
public class InsufficientBalanceException extends Exception {
    //kullanılabilir diye ekledim, ama kullanmıyorum, constructor'ı kullanıyorum
    private String exMsg = "Bakiye Yetersizdir";

    public InsufficientBalanceException(String exMsg) {
        this.exMsg = exMsg;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }
}