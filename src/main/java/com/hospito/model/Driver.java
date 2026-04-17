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
2. Encapsulation
3. Object-Relational Mapping (ORM)
4. Abstraction
5. Single Responsibility Principle (SRP)
6. Convention over Configuration
*/

package com.hospito.model;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String location;
    private boolean available;
    
    // 🔹 Default constructor (required)
    public Driver() {}

    // 🔹 Parameterized constructor (optional but useful)
    public Driver(String name, String phone, String location, boolean available) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.available = available;
    }

    // 🔹 Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
