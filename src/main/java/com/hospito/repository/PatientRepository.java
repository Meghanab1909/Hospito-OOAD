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

package com.hospito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospito.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
}
