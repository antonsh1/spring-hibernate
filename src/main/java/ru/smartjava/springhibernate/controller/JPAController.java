package ru.smartjava.springhibernate.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.smartjava.springhibernate.entity.ErrorMsg;
import ru.smartjava.springhibernate.service.JPAService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JPAController {

    private final JPAService service;
    private final Gson gson = new GsonBuilder().create();

    @GetMapping(value = "/persons/by-city", produces = "application/json")
    ResponseEntity<String> getPersonsByCity(@RequestParam String city) {
        return service.getPersonsByCity(city)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(
                                        gson.toJson(
                                                new ErrorMsg("Customers with city of living equals '" + city + "' not found")
                                        )
                                )
                );
    }
}
