package ru.smartjava.springhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ErrorMsg {

    String message;

    public ErrorMsg(String message) {
        this.message = message;
    }
}
