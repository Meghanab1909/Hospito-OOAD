package com.hospito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospito.model.Booking;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByHospitalNameOrderBySeverityAsc(String hospitalName);
}