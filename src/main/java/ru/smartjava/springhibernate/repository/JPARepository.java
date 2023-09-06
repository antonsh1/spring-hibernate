package ru.smartjava.springhibernate.repository;

import ru.smartjava.springhibernate.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface JPARepository {
    Optional<List<Customer>> getPersonsByCity(String Name);
}
