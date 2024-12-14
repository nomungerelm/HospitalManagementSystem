package com.hospital.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.models.MedicalRecords;

public class MedicalRecordOperation {

    // Add a new medical record
    public boolean addMedicalRecord(MedicalRecords record) {
        String query = "INSERT INTO MedicalRecord (patient_id, doctor_id, diagnosis, treatment, prescription, record_date) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set parameters
            stmt.setInt(1, record.getPatientID());
            stmt.setInt(2, record.getDoctorID());
            stmt.setString(3, record.getDiagnosis());
            stmt.setString(4, record.getTreatment());
            stmt.setString(5, record.getPrescription());

            // Handle record_date as String
            if (record.getRecordDate() != null) {
                stmt.setString(6, record.getRecordDate()); // Assuming recordDate is a formatted String
            } else {
                stmt.setNull(6, java.sql.Types.TIMESTAMP); // Allow database default
            }

            // Execute update
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Medical record added successfully!");
                return true;
            } else {
                System.out.println("No rows were affected. Check your data.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error adding medical record: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Fetch all medical records
    public List<MedicalRecords> getAllMedicalRecords() {
        List<MedicalRecords> records = new ArrayList<>();
        String query = "SELECT record_id, patient_id, doctor_id, diagnosis, treatment, prescription, record_date FROM MedicalRecord";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int recordId = rs.getInt("record_id");
                int patientId = rs.getInt("patient_id");
                int doctorId = rs.getInt("doctor_id");
                String diagnosis = rs.getString("diagnosis");
                String treatment = rs.getString("treatment");
                String prescription = rs.getString("prescription");
                String recordDate = rs.getString("record_date");
                
                MedicalRecords medicalRecord = new MedicalRecords(recordId, patientId, doctorId, diagnosis, treatment, prescription, recordDate);
                records.add(medicalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Fetched " + records.size() + " medical records.");
        return records;
    }


    // Update an existing medical record in the database
    public boolean updateMedicalRecord(MedicalRecords record) {
        String query = "UPDATE MedicalRecord SET patient_id = ?, doctor_id = ?, diagnosis = ?, treatment = ?, prescription = ?, record_date = ? WHERE record_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, record.getPatientID());
            stmt.setInt(2, record.getDoctorID());
            stmt.setString(3, record.getDiagnosis());
            stmt.setString(4, record.getTreatment());
            stmt.setString(5, record.getPrescription());

            // Handle record_date as String
            stmt.setString(6, record.getRecordDate()); // Assuming recordDate is a formatted String

            stmt.setInt(7, (int) record.getRecordID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Medical record updated successfully!");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error updating medical record: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Delete a medical record from the database
    public boolean deleteMedicalRecord(int recordId) {
        String query = "DELETE FROM MedicalRecord WHERE record_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, recordId);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Medical record deleted successfully!");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error deleting medical record: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}