package ru.smartjava.springhibernate.entity;

import lombok.ToString;

@ToString
public class ErrorMsg {

    final String message;

    public ErrorMsg(String message) {
        this.message = message;
    }
}
