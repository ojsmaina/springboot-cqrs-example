package com.example.sbcqrsexmple.command;

import com.example.sbcqrsexmple.cqs.CommandHandler;
import com.example.sbcqrsexmple.domain.Account;
import com.example.sbcqrsexmple.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountHandler implements CommandHandler<CreateAccountResult, CreateAccountCommand> {

    private final AccountRepository accountRepository;

    @Override
    public CreateAccountResult handle(CreateAccountCommand command) {
        Account account = Account.builder()
                .name(command.getAccountName())
                .number(command.getAccountNumber())
                .build();
        Account newAccount =  accountRepository.save(account);
        return new CreateAccountResult(newAccount.getNumber());
    }
}
