package com.hospito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospito.model.Driver;
import com.hospito.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;

    public Driver getAvailableDriver() {
        return repo.findByAvailableTrue()
                   .stream()
                   .findFirst()
                   .orElse(null);
    }

    public void markUnavailable(Driver driver) {
        driver.setAvailable(false);
        repo.save(driver);
    }
}