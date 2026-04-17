/*
 * Author: Mitha M K
 * Class: Sem 6 Sec F
 * Project: Hospito
 * 
 * Author: N. Rakshitha
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
Design Principles Used:
1. Seperation of Concerns (SoC)
2. MVC Architecture (Model-View-Controller)
3. Dependency Injection (DI)
4. Single Responsibility Principle (SRP)
5. Loose Coupling
6. Convention over Configuration (Spring)
7. Encapsulation
*/

package com.hospito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospito.model.Booking;
import com.hospito.model.Patient;
import com.hospito.service.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {

    @Autowired
    private BookingService service;

    // Show booking form
    @GetMapping("/book")
    public String showForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking";
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Booking booking,
                    @RequestParam String type,
                    @RequestParam(required = false) String otherName,
                    @RequestParam(required = false) Integer otherAge,
                    HttpSession session) {

        Patient user = (Patient) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login"; // or dashboard
        }

        if (type.equals("self")) {
            booking.setPatientName(user.getName());
        } else {
            booking.setPatientName(otherName);
            booking.setPatientAge(otherAge);
        }

        service.saveBooking(booking, user);

        return "driver";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        Patient user = (Patient) session.getAttribute("user");

        model.addAttribute("bookings", service.getBookingsByPatient(user.getId()));

        return "dashboard";
    }

    @PostMapping("/doctor/diagnosis")
    public String addDiagnosis(@RequestParam Long bookingId,
                           @RequestParam String diagnosis,
                           HttpSession session) {

    Patient user = (Patient) session.getAttribute("user");

    if (user == null || !"DOCTOR".equals(user.getRole())) {
        return "redirect:/";
    }

    Booking booking = service.getBookingById(bookingId);
    booking.setDiagnosis(diagnosis);

    service.save(booking);

    return "redirect:/hospital/queue?name=" + booking.getHospitalName();
    }

    @PostMapping("/doctor/discharge")
    public String dischargePatient(@RequestParam Long bookingId,
                                HttpSession session) {

        Patient user = (Patient) session.getAttribute("user");

        if (user == null || !"DOCTOR".equals(user.getRole())) {
            return "redirect:/";
        }

        Booking booking = service.getBookingById(bookingId);
        String hospitalName = booking.getHospitalName();

        service.deleteBooking(bookingId);

        return "redirect:/hospital/queue?name=" + hospitalName;
    }
}
