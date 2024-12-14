package com.hospital.database;

import com.hospital.models.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorOperation {

    // Adds a new doctor to the database
    public boolean addDoctor(Doctor doctor) {
        String query = "INSERT INTO Doctor (name, specialty, hospital, phoneNumber, email, yearsOfExperience, department, licenseNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialty());
            stmt.setString(3, doctor.getHospital());
            stmt.setString(4, doctor.getPhoneNumber());
            stmt.setString(5, doctor.getEmail());
            stmt.setInt(6, doctor.getYearsOfExperience());
            stmt.setString(7, doctor.getDepartment());
            stmt.setString(8, doctor.getLicenseNumber());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
            return false;
        }
    }

    // Fetches all doctors from the database
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM Doctor";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                doctors.add(new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getString("hospital"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getInt("yearsOfExperience"),
                        rs.getString("department"),
                        rs.getString("licenseNumber")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching doctors: " + e.getMessage());
        }
        return doctors;
    }

    // Fetches a specific doctor based on doctor ID
    public Doctor getDoctorById(int doctorId) {
        String query = "SELECT * FROM Doctor WHERE doctor_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, doctorId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Doctor(
                            rs.getInt("doctor_id"),
                            rs.getString("name"),
                            rs.getString("specialty"),
                            rs.getString("hospital"),
                            rs.getString("phoneNumber"),
                            rs.getString("email"),
                            rs.getInt("yearsOfExperience"),
                            rs.getString("department"),
                            rs.getString("licenseNumber")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching doctor by ID: " + e.getMessage());
        }
        return null;
    }

    // Deletes a specific doctor by ID
    public boolean deleteDoctorById(int doctorId) {
        String query = "DELETE FROM Doctor WHERE doctor_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, doctorId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting doctor: " + e.getMessage());
            return false;
        }
    }

    // Fetches and immediately deletes a doctor by ID
    public boolean fetchAndDeleteDoctorById(int doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            System.out.println("Doctor Details: " + doctor);
            return deleteDoctorById(doctorId);
        } else {
            System.out.println("Doctor with ID " + doctorId + " not found.");
            return false;
        }
    }
}
