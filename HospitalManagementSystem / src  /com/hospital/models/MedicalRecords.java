package com.hospital.models;

public class MedicalRecords {
    private int recordID;
    private int patientID;
    private int doctorID;
    private String diagnosis;
    private String treatment;
    private String prescription;
    private String recordDate;

    // Constructor
    public MedicalRecords(int recordID, int patientID, int doctorID, String diagnosis, String treatment, String prescription, String recordDate) {
        this.recordID = recordID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.prescription = prescription;
        this.recordDate = recordDate;
    }

    // Getters
    public int getRecordID() {
        return recordID;
    }
    public int getPatientID() {
        return patientID;
    }
    public int getDoctorID() {
        return doctorID;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public String getTreatment() {
        return treatment;
    }
    public String getPrescription() {
        return prescription;
    }
    public String getRecordDate() {
        return recordDate;
    }


    // Override toString for better readability
    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordID=" + recordID +
                ", patientID=" + patientID +
                ", doctorID=" + doctorID +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", prescription='" + prescription + '\'' +
                ", recordDate='" + recordDate + '\'' +
                '}';
    }

    // Override equals and hashCode for correct comparison and hashing in collections
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MedicalRecords that = (MedicalRecords) obj;
        return recordID == that.recordID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(recordID);
    }

	
}