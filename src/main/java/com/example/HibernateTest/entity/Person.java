package com.example.HibernateTest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "persons")
@IdClass(PersonId.class)
public class Person {

    @Id
    @Column(nullable = false, length = 100)
    private String name;
    @Id
    @Column(nullable = false, length = 100)
    private String surname;
    @Id
    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 20)
    @Pattern(regexp = "[+]?[0-9]{1,3} ?\\(?[0-9]{3}\\)? ?[0-9]{2}[0-9 -]+[0-9]{2}")
    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;
}
