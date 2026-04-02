package com.hospito.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String role = "PATIENT";
    
    // 🔥 Medical info (important for your requirement)
    private double height;
    private double weight;
    private String allergies;

    // 🔗 Relationship with Booking
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    // 🔹 Default constructor (required)
    public Patient() {}

    // 🔹 Parameterized constructor (optional)
    public Patient(String name, String email, String password,
                   double height, double weight, String allergies) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.allergies = allergies;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}