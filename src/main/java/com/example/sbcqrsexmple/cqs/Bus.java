package com.example.sbcqrsexmple.cqs;

public interface Bus {
    <T, C extends Command<T>> T executeCommand(C command);
}
