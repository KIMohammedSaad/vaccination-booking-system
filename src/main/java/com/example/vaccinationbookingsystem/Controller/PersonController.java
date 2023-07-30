package com.example.vaccinationbookingsystem.Controller;

import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody Person person){
        try {
            Person personResponse = personService.addPerson(person);
            return new ResponseEntity(personResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
