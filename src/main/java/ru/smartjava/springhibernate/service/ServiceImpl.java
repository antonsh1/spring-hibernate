package ru.smartjava.springhibernate.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smartjava.springhibernate.entity.Customer;
import ru.smartjava.springhibernate.repository.JPARepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements JPAService {

    private final JPARepository repository;
    private final Gson gson = new GsonBuilder().create();

    @Override
    public Optional<String> getCustomersByCity(String city) {
        List<Customer> customerList = repository.getCustomersByCityOfLiving(city);
        if (!customerList.isEmpty()) {
            return Optional.of(gson.toJson(customerList));
        }
        return Optional.empty();
    }


    @Override
    public Optional<String> getCustomersByAgeLessThan(Integer age) {
        List<Customer> customerList = repository.getCustomersByPerson_AgeLessThan(age);
        if (!customerList.isEmpty()) {
            return Optional.of(gson.toJson(customerList));
        }
        return Optional.empty();

    }

    @Override
    public Optional<String> getCustomersByNameAndSureName(String name, String sureName) {
        Optional<List<Customer>> customerList = repository.getCustomersByPerson_NameAndPerson_SureName(name, sureName);
        if(customerList.isPresent() && !customerList.get().isEmpty()) {
            return customerList.map(gson::toJson);
        }
        return Optional.empty();
    }

}
