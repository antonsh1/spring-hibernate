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
    public Optional<String> getPersonsByCity(String city) {
        Optional<List<Customer>> customerList = repository.getPersonsByCity(city);
        return customerList.map(gson::toJson);
    }
}
