package com.example.sbcqrsexmple.controller;

import com.example.sbcqrsexmple.command.CreateAccountCommand;
import com.example.sbcqrsexmple.command.CreateAccountResult;
import com.example.sbcqrsexmple.cqs.Bus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final Bus bus;

    @PostMapping
    public ResponseEntity<CreateAccountResult> createBankAccount(@RequestBody() CreateAccountCommand command) {
        return ResponseEntity.ok(bus.executeCommand(command));
    }
}
