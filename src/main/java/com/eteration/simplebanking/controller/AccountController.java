package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// This class is a place holder you can change the complete implementation
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    Account account;

    @GetMapping(value = "/{accountNumber}", produces = "application/json")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account1 = null;
        for(int i=0; i<account.getAccountList().size(); i++){
            if(account.getAccountList().get(i).getAccountNumber().equals(accountNumber))
                account1 = account.getAccountList().get(i);
        }
        return ResponseEntity.ok().body(account1);
    }

    @PostMapping(value = "/credit")
    public ResponseEntity<TransactionStatus> credit(@RequestBody String accountNumber, DepositTransaction depositTransaction ) {
        Account account = getAccount(accountNumber).getBody();
        account.deposit(depositTransaction.getAmount());
        return ResponseEntity.ok().body(new TransactionStatus("OK"));

    }

    @PostMapping(value = "/debit")
    public ResponseEntity<TransactionStatus> debit(@RequestBody String accountNumber, WithdrawalTransaction withdrawalTransaction ) throws InsufficientBalanceException {
        Account account = getAccount(accountNumber).getBody();
        account.withdraw(withdrawalTransaction.getAmount());
        return ResponseEntity.ok().body(new TransactionStatus("OK"));
	}
}