package com.sidney.banking.account.adapter.in.web;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sidney.banking.account.application.port.in.CreateAccountUseCase;
import com.sidney.banking.account.domain.Account;

@RestController
public class AccountController {

    private final CreateAccountUseCase createAccountUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestParam UUID customerId) {
        return createAccountUseCase.create(customerId);
    }
}