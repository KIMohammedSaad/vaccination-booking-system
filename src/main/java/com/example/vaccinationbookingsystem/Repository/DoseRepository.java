package com.example.vaccinationbookingsystem.Repository;

import com.example.vaccinationbookingsystem.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose, Integer> {

}
