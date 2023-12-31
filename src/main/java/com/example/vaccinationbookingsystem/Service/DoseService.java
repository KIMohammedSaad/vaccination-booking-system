package com.example.vaccinationbookingsystem.Service;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.Model.Person;
import com.example.vaccinationbookingsystem.Repository.DoseRepository;
import com.example.vaccinationbookingsystem.Repository.PersonRepository;
import com.example.vaccinationbookingsystem.exception.DoseAlreadyTakenException;
import com.example.vaccinationbookingsystem.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;
    public Dose getDose1(int personId, DoseType doseType) {
        Optional<Person> optionalPerson = personRepository.findById(personId);

        //check person exists or not
        if(!optionalPerson.isPresent()){
            throw new PersonNotFoundException("Invalid PersonID");
        }
        Person person = optionalPerson.get();

        //Check if dose 1 is already taken
        if(person.isDose1Taken()){
            throw new DoseAlreadyTakenException("Dose 1 already taken");
        }

        //Create a Dose
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(doseType);
        dose.setPerson(person);

        person.setDose1Taken(true);
        personRepository.save(person);

        return doseRepository.save(dose);
    }
}
