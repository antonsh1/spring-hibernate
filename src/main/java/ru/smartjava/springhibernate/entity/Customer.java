package ru.smartjava.springhibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Person person;

    private String phone_number;

    private String cityOfLiving;


}
