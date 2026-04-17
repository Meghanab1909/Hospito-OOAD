/*
 * Author: Meghana Saisri Bisa
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
Design Principles Used:
Separation of Concerns (SoC)
Repository Pattern
Abstraction
Dependency Injection (DI) (used by Spring Data internally)
Convention over Configuration
Single Responsibility Principle (SRP)
*/

package com.hospito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospito.model.Booking;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByHospitalNameOrderBySeverityAsc(String hospitalName);
}
