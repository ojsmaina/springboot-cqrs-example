package com.example.sbcqrsexmple.cqs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringBus implements Bus {

    private final Registry registry;
    @Override
    public <T, C extends Command<T>> T executeCommand(C command) {
        CommandHandler<T, C> commandHandler = registry.getCmd(command.getClass());
        return commandHandler.handle(command);
    }
}
