package ru.smartjava.springhibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sureName;
    private int age;


}
