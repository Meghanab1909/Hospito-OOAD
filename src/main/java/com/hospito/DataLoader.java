package com.hospito;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hospito.repository.DriverRepository;

import com.hospito.model.Driver;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadDrivers(DriverRepository repo) {
        return args -> {
            repo.setAllDriversAvailable();

            if (repo.count() == 0) {

                repo.save(new Driver("Ravi", "9876543210", "Bangalore", true));
                repo.save(new Driver("Arjun", "9876543211", "Whitefield", true));
                repo.save(new Driver("Kiran", "9876543212", "Marathahalli", true));
                repo.save(new Driver("Suresh", "9876543213", "Indiranagar", true));
                repo.save(new Driver("Manoj", "9876543214", "Electronic City", true));
            }
        };
    }
}