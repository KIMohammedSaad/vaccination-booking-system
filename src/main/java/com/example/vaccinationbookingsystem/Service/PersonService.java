package com.example.vaccinationbookingsystem.Service;

import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    public Person addPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }
}