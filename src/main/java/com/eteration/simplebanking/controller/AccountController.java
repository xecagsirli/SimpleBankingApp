package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// This class is a place holder you can change the complete implementation
public class AccountController {


    @GetMapping(value = "/{accountNumber}", produces = "application/json")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok().body(new Account("",""));
    }

    @PostMapping(value = "/credit")
    public ResponseEntity<TransactionStatus> credit(@RequestBody String balance, DepositTransaction depositTransaction ) {
        Account account = getAccount("").getBody();
        account.deposit(account.getBalance());
        return ResponseEntity.ok().body(new TransactionStatus());

    }

    @PostMapping(value = "/debit")
    public ResponseEntity<TransactionStatus> debit(@RequestBody String balance, WithdrawalTransaction depositTransaction ) throws InsufficientBalanceException {
        Account account = getAccount("").getBody();
        account.withdraw(account.getBalance());
        return ResponseEntity.ok().body(new TransactionStatus());
	}
}