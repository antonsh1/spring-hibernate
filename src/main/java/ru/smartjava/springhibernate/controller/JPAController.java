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

    private final String customerByCityAbsentTemplate = "Customers with city of living equals '%s' not found";
    private final String customerByAgeAbsentTemplate = "Customers younger than '%d' years not found";
    private final String customerNyNameAndSureNameTemplate = "Customers with Name '%s' and Surename '%s' not found";

    @GetMapping(value = "/persons/by-city", produces = "application/json")
    ResponseEntity<String> getCustomersByCity(@RequestParam String city) {
        return service.getCustomersByCity(city)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFoundResponseBuilder(customerByCityAbsentTemplate, city));
    }

    @GetMapping(value = "/persons/by-age-less", produces = "application/json")
    ResponseEntity<String> getCustomersByAgeLessThan(@RequestParam Integer age) {
        return service.getCustomersByAgeLessThan(age)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFoundResponseBuilder(customerByAgeAbsentTemplate, age));
    }

    @GetMapping(value = "/persons/by-name-surename", produces = "application/json")
    ResponseEntity<String> getCustomersByNameAndSureName(@RequestParam String name, @RequestParam String sureName) {
        return service.getCustomersByNameAndSureName(name, sureName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFoundResponseBuilder(customerNyNameAndSureNameTemplate, name, sureName));
    }

    private ResponseEntity<String> notFoundResponseBuilder(String template, String value) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(gson.toJson(new ErrorMsg(String.format(template, value))));

    }

    private ResponseEntity<String> notFoundResponseBuilder(String template, Integer value) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(gson.toJson(new ErrorMsg(String.format(template, value))));

    }

    private ResponseEntity<String> notFoundResponseBuilder(String template, String value1, String value2) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(gson.toJson(new ErrorMsg(String.format(template, value1, value2))));
    }
}
