package com.example.vaccinationbookingsystem.Model;

import com.example.vaccinationbookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    int id;

    String name;

    int age;

    @Column(unique = true, nullable = false)
    String emailId;

    @Enumerated(EnumType.STRING) //  Converts Enum to string
    Gender gender;

    boolean isDose1Taken;

    boolean isDose2Taken;

//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) //I want to transfer all the operation
//            // to childern
//    List<Dose> dosesTaken = new ArrayList<>();
//
//    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
//    Certificate certificate;

}
