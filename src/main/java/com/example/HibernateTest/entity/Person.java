package com.example.HibernateTest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
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


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(cityOfLiving, person.cityOfLiving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, phoneNumber, cityOfLiving);
    }
}
