package com.hospito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospito.repository.BookingRepository;
import com.hospito.model.Booking;
import com.hospito.model.Patient;
import com.hospito.model.Driver;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private DriverService driverService;

    @Autowired
    private BookingRepository repository;

    public Booking getBookingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Booking booking) {
        repository.save(booking);
    }

    public Booking saveBooking(Booking booking, Patient patient) {

        booking.setPatient(patient);

        booking.setSeverity(getPriority(booking.getInjuryType()));
        booking.setStatus("Pending");

        Driver driver = driverService.getAvailableDriver();
        if (driver != null) {
            booking.setDriver(driver);
            driverService.markUnavailable(driver);
        }

        return bookingRepo.save(booking);
    }

    public int getPriority(String injury) {
        switch (injury.toLowerCase()) {
            case "critical": return 1;
            case "serious": return 2;
            default: return 3;
        }
    }

    public void deleteBooking(Long id)
    {
        repository.deleteById(id);
    }

    public List<Booking> getQueue() {
        return bookingRepo.findAllByOrderBySeverityAsc();
    }

    public List<Booking> getBookingsByPatient(Long pid) {
        return bookingRepo.findByPatient_Id(pid);
    }

    public List<Booking> getQueueByHospital(String hospitalName) {
        return repository.findByHospitalNameOrderBySeverityAsc(hospitalName);
    }
}