package ru.smartjava.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smartjava.springhibernate.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface JPARepository extends JpaRepository<Customer, Long> {
    List<Customer> getCustomersByCityOfLiving(String city);
    List<Customer> getCustomersByPerson_AgeLessThan(Integer age);
    Optional<List<Customer>> getCustomersByPerson_NameAndPerson_SureName(String name, String sureName);
}
