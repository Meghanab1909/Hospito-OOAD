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