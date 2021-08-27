package com.example.sbcqrsexmple.cqs;

public interface CommandHandler<T, C> {
    T handle(C command);
}
