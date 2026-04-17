/*
 * Author: Mitha M K
 * Class: Sem 6 Sec F
 * Project: Hospito
 * 
 * Author: N Rakshitha
 * Class: Sem 6 Sec F
 * Project: Hospito
*/

/*
Design Principles Used:
1. Separation of Concerns (SoC)
2. Repository Pattern
3. Abstraction
4. Dependency Injection (DI) (used by Spring Data internally)
5. Convention over Configuration
6. Single Responsibility Principle (SRP)
*/

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
