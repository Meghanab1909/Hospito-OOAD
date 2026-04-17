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
Design Principles Used:
1. Separation of Concerns (SoC)
2. Repository Pattern
3. Abstraction
4. Dependency Injection (DI) (used by Spring Data internally)
5. Convention over Configuration
6. Single Responsibility Principle (SRP)
*/

package com.hospito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hospito.model.Driver;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByAvailableTrue();

    @Transactional
    @Modifying
    @Query(value = "UPDATE driver SET available = 1", nativeQuery = true)
    int setAllDriversAvailable();
}
