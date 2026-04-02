package com.hospito.controller;

import com.hospito.model.Booking;
import com.hospito.model.Patient;
import com.hospito.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class DriverController {

    @Autowired
    private BookingService service;

    @GetMapping("/driver")
    public String showDrivers(Model model, HttpSession session) {

        Patient user = (Patient) session.getAttribute("user");

        // 🔴 IMPORTANT: handle not logged in
        if (user == null) {
            return "redirect:/login";
        }

        // ✅ Get ONLY this user's bookings
        List<Booking> bookings = service.getBookingsByPatient(user.getId());

        model.addAttribute("queue", bookings);

        return "driver";
    }
}