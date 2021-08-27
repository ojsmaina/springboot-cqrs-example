package com.example.sbcqrsexmple.command;

import com.example.sbcqrsexmple.cqs.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateAccountCommand implements Command<CreateAccountResult> {
    private String accountNumber;
    private String accountName;
}
