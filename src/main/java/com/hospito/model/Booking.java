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
2. Encapsulation
3. Object-Relational Mapping (ORM)
4. Abstraction
5. Single Responsibility Principle (SRP)
6. Convention over Configuration
*/

package com.hospito.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalName;
    private String injuryType;
    private int severity;
    private String status;
    private String patientName;
    private int patientAge;

    // 🔹 Patient relation
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // 🔥 ADD THIS (IMPORTANT)
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private String diagnosis;
    
    public Booking() {}

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // 🔥 ADD THIS
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
