package com.example.HibernateTest.repository;

import com.example.HibernateTest.entity.Person;
import com.example.HibernateTest.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, PersonId> {
    @Query(value = "from Person where cityOfLiving =?1")
    List<Person> findByCityOfLiving(String city);

    @Query(value = "from Person where age <= ?1")
    List<Person> findByAgeLessThanOrderByAge(int age);

    @Query(value = "from Person where name = ?1 and surname = ?2")
    List<Person> findByNameAndSurname(String name, String surname);
}
