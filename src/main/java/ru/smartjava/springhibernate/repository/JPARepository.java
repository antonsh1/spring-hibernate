package ru.smartjava.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.smartjava.springhibernate.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface JPARepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.cityOfLiving = :city")
    List<Customer> getCustomersByCityOfLiving(@Param("city") String city);

    @Query("select c from Customer c where c.person.age < :age")
    List<Customer> getCustomersByPerson_AgeLessThan(@Param("age") Integer age);

    @Query("select c from Customer c where c.person.name = :name and c.person.sureName = :sureName")
    Optional<List<Customer>> getCustomersByPerson_NameAndPerson_SureName(@Param("name") String name, @Param("sureName") String sureName);
}
