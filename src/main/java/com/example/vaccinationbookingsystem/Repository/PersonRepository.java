package com.example.vaccinationbookingsystem.Repository;

import com.example.vaccinationbookingsystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
