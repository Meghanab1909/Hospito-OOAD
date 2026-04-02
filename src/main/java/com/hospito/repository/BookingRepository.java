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
