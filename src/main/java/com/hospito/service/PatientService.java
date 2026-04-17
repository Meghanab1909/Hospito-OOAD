/*
 * Author: N Rakshitha
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
Design Principles Used:
1. Separation of Concerns (SoC)
2. Repository Pattern
3. Abstraction
4. Dependency Injection (DI) (used by Spring Data internally)
5. Convention over Configuration
6. Single Responsibility Principle (SRP)
*/

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
