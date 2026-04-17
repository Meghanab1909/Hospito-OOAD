/*
 * Author: Mitha M K
 * Class: Sem 6 Sec F
 * Project: Hospito
 * 
 * Author: Mrunal Manjunath Kudtarkar
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
1. Separation of Concerns (SoC)
2. Repository Pattern
3. Abstraction
4. Dependency Injection (DI) (used by Spring Data internally)
5. Convention over Configuration
6. Single Responsibility Principle (SRP)
*/

package com.hospito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospito.model.Booking;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // 🔹 For priority queue
    List<Booking> findAllByOrderBySeverityAsc();

    // 🔹 For patient dashboard
    List<Booking> findByPatient_Id(Long patientID);

    // 🔥 ADD THIS (your missing method)
    List<Booking> findByHospitalNameOrderBySeverityAsc(String hospitalName);
}
