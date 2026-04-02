package com.hospito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospito.model.Patient;
import com.hospito.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public Patient register(Patient patient) {
        return repo.save(patient);
    }

    public Patient login(String email, String password) {
        Patient p = repo.findByEmail(email);
        if (p != null && p.getPassword().equals(password)) {
            return p;
        }
        return null;
    }
}