package ru.smartjava.springhibernate.service;

import java.util.Optional;

public interface JPAService {

    Optional<String> getPersonsByCity(String Name);
}
