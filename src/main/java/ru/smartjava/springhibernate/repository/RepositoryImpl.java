package ru.smartjava.springhibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.smartjava.springhibernate.entity.Customer;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RepositoryImpl implements JPARepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<List<Customer>> getPersonsByCity(String city) {
        List<Customer> customerList = (List<Customer>) entityManager.createNativeQuery("select * from netology.customer where city_of_living= :city",
                Customer.class).setParameter("city", city).getResultList();
        if (customerList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(customerList);
        }
    }


}
