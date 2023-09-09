package ru.smartjava.springhibernate.service;

import java.util.Optional;

public interface JPAService {

    Optional<String> getCustomersByCity(String name);

    Optional<String> getCustomersByAgeLessThan(Integer age);

    Optional<String> getCustomersByNameAndSureName(String name, String sureName);

}
