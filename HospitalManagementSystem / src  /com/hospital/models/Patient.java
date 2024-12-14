package com.hospital.models;

import java.time.LocalDate;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String bloodType;
    private String medicalCondition;
    private String dateOfAdmission;
    private int doctorId;
    private String doctorName;
    private String hospital;
    private String insuranceProvider;
    private double billingAmount;
    private int roomNumber;
    private String admissionType;
    private String dischargeDate;
    private String medication;
    private String testResults;
    
 // Default Constructor
    public Patient() {
    }

    // Constructor, getters, and setters
    public Patient(int patientId, String name, int age, String gender, String bloodType, String medicalCondition,
                String string, int doctorId, String doctorName, String hospital, String insuranceProvider,
                   double billingAmount, int roomNumber, String admissionType, String dischargeDate, 
                   String medication, String testResults) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
        this.medicalCondition = medicalCondition;
        this.dateOfAdmission = string;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.hospital = hospital;
        this.insuranceProvider = insuranceProvider;
        this.billingAmount = billingAmount;
        this.roomNumber = roomNumber;
        this.admissionType = admissionType;
        this.dischargeDate = dischargeDate;
        this.medication = medication;
        this.testResults = testResults;
    }

    // Getters and Setters for each attribute
    public int getPatientId() {
        return patientId;
    }
    
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }
    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }
    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospital() {
        return hospital;
    }
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }
    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public double getBillingAmount() {
        return billingAmount;
    }
    public void setBillingAmount(double billingAmount) {
        this.billingAmount = billingAmount;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAdmissionType() {
        return admissionType;
    }
    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }
    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }
 
    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

	



	

	

	public void setDateOfAdmission(LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}

	public void setDischargeDate(LocalDate localDate) {
		// TODO Auto-generated method stub
		
	}
	
}

	