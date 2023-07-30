package com.example.vaccinationbookingsystem.Controller;

import com.example.vaccinationbookingsystem.Enum.DoseType;
import com.example.vaccinationbookingsystem.Model.Dose;
import com.example.vaccinationbookingsystem.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dose")
@RestController
public class DoseController {

    @Autowired
    DoseService doseService;
    @PostMapping("/get_dose_1")
    public ResponseEntity getDose1(@RequestParam("id") int personId, @RequestParam("doseType")DoseType doseType){
        try{
            Dose doseTake = doseService.getDose1(personId, doseType);
            return new ResponseEntity(doseTake, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
