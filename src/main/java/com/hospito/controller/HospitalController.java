/*
 * Author: Meghana Saisri Bisa
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
Design Principles Used:
1. Separation of Concerns (SoC)
2. MVC Architecture (Model–View–Controller)
3. Dependency Injection (DI)
4. Single Responsibility Principle (SRP)
5. Loose Coupling 
6. Convention over Configuration
7. Encapsulation
*/

package com.hospito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospito.service.BookingService;

@Controller
public class HospitalController {

    @Autowired
    private BookingService service;

    // 🔹 Show input page
    @GetMapping("/hospital")
    public String hospitalPage() {
        return "hospital";
    }

    // 🔹 Show queue for selected hospital
    @GetMapping("/hospital/queue")
    public String viewQueue(@RequestParam String name, Model model) {

        model.addAttribute("queue", service.getQueueByHospital(name));

        return "hospital";
    }
}
