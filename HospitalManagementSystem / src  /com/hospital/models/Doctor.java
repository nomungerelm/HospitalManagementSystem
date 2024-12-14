package com.hospital.models;

public class Doctor {
    private int doctorID;
    private String name;
    private String specialty;
    private String hospital;
    private String phoneNumber;
    private String email;
    private int yearsOfExperience;
    private String department;
    private String licenseNumber;

    public Doctor(int doctorID, String name, String specialty, String hospital, String phoneNumber, String email, int yearsOfExperience, String department, String licenseNumber) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialty = specialty;
        this.hospital = hospital;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
        this.licenseNumber = licenseNumber;
    }

    // Getters and Setters
    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    // Implement getContact() based on phone number and email
    public String getContact() {
        return "Phone: " + phoneNumber + ", Email: " + email;
    }

    // Implement getAvailability() based on doctor's department
    public String getAvailability() {
        // Example: Availability can be determined by the department or schedule
        return department; // You can modify this based on your availability logic
    }
}
