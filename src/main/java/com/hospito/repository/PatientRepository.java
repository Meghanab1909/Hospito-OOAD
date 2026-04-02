package com.hospito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospito.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
}