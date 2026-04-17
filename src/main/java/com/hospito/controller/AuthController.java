/*
 * Author: Meghana Saisri Bisa
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
Design Principles Used:
Separation of Concerns
MVC Pattern
Dependency Injection
Single Responsibility (mostly)
Loose Coupling (partially)
Open/Closed (can improve)
*/

package com.hospito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospito.model.Patient;
import com.hospito.service.PatientService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private PatientService service;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        Patient p = service.login(email, password);

        if (p != null) {
            session.setAttribute("user", p); 
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Patient patient) {

        if (patient.getEmail().contains("@doc")) {
            patient.setRole("DOCTOR");
        } else {
            patient.setRole("PATIENT");
        }

        service.register(patient);
        return "login";
    }
}
