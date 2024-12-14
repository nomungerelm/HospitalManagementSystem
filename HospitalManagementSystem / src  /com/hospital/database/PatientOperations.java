package com.hospital.database;

import com.hospital.models.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientOperations {
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospital_db"; // Adjust database name
        String username = "root";  // Change to your DB user name
        String password = "bilig616"; // Change to your DB password
        return DriverManager.getConnection(url, username, password);
    }

    public static List<Patient> searchPatient(String searchTerm) {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM Patient WHERE name LIKE ? OR medical_condition LIKE ?"; // Keep the table name as 'patient'

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, "%" + searchTerm + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setBloodType(rs.getString("blood_type"));
                patient.setMedicalCondition(rs.getString("medical_condition"));
                patient.setDateOfAdmission(rs.getDate("date_of_admission").toLocalDate());
                patient.setDoctorId(rs.getInt("doctor_id"));
                patient.setDoctorName(rs.getString("doctor_name"));
                patient.setHospital(rs.getString("hospital"));
                patient.setInsuranceProvider(rs.getString("insurance_provider"));
                patient.setBillingAmount(rs.getDouble("billing_amount"));
                patient.setRoomNumber(rs.getInt("room_number"));
                patient.setAdmissionType(rs.getString("admission_type"));
                patient.setDischargeDate(rs.getDate("discharge_date").toLocalDate());
                patient.setMedication(rs.getString("medication"));
                patient.setTestResults(rs.getString("test_results"));  // Change 'test_result' to 'test_results'
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM Patient"; // Keep the table name as 'patient'

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("blood_type"),
                        rs.getString("medical_condition"),
                        rs.getString("date_of_admission"),
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_name"),
                        rs.getString("hospital"),
                        rs.getString("insurance_provider"),
                        rs.getDouble("billing_amount"),
                        rs.getInt("room_number"),
                        rs.getString("admission_type"),
                        rs.getString("discharge_date"),
                        rs.getString("medication"),
                        rs.getString("test_results")  // Change 'test_result' to 'test_results'
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    public static Patient getPatientById(int patientId) {
        Patient patient = null;
        String query = "SELECT * FROM Patient WHERE patient_id = ?";


        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("blood_type"),
                        rs.getString("medical_condition"),
                        rs.getString("date_of_admission"),
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_name"),
                        rs.getString("hospital"),
                        rs.getString("insurance_provider"),
                        rs.getDouble("billing_amount"),
                        rs.getInt("room_number"),
                        rs.getString("admission_type"),
                        rs.getString("discharge_date"),
                        rs.getString("medication"),
                        rs.getString("test_results")  // Change 'test_result' to 'test_results'
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    public static void addPatient(Patient patient) {
        String sql = "INSERT INTO Patient (name, age, gender, blood_type, medical_condition, date_of_admission, "
                + "doctor_id, doctor_name, hospital, insurance_provider, billing_amount, room_number, admission_type, "
                + "discharge_date, medication, test_results) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameters
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getBloodType());
            stmt.setString(5, patient.getMedicalCondition());
            stmt.setDate(6, patient.getDateOfAdmission() != null ? Date.valueOf(patient.getDateOfAdmission()) : null);
            stmt.setInt(7, patient.getDoctorId() != 0 ? patient.getDoctorId() : null);
            stmt.setString(8, patient.getDoctorName());
            stmt.setString(9, patient.getHospital());
            stmt.setString(10, patient.getInsuranceProvider());
            stmt.setDouble(11, patient.getBillingAmount());
            stmt.setInt(12, patient.getRoomNumber());
            stmt.setString(13, patient.getAdmissionType());
            stmt.setDate(14, patient.getDischargeDate() != null ? Date.valueOf(patient.getDischargeDate()) : null);
            stmt.setString(15, patient.getMedication());
            stmt.setString(16, patient.getTestResults());

            // Execute update
            int rowsAffected = stmt.executeUpdate();

            // Log result
            if (rowsAffected > 0) {
                System.out.println("Patient added successfully.");
            } else {
                System.out.println("Failed to add patient.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding patient: " + e.getMessage());
        }
    }


    public static void updatePatient(Patient patient) {
        String sql = "UPDATE Patient SET name = ?, age = ?, gender = ?, blood_type = ?, medical_condition = ?, "
                + "date_of_admission = ?, doctor_id = ?, doctor_name = ?, hospital = ?, insurance_provider = ?, "
                + "billing_amount = ?, room_number = ?, admission_type = ?, discharge_date = ?, medication = ?, "
                + "test_results = ? WHERE patient_id = ?"; // Change 'test_result' to 'test_results'

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getBloodType());
            stmt.setString(5, patient.getMedicalCondition());
            stmt.setDate(6, Date.valueOf(patient.getDateOfAdmission()));
            stmt.setInt(7, patient.getDoctorId());
            stmt.setString(8, patient.getDoctorName());
            stmt.setString(9, patient.getHospital());
            stmt.setString(10, patient.getInsuranceProvider());
            stmt.setDouble(11, patient.getBillingAmount());
            stmt.setInt(12, patient.getRoomNumber());
            stmt.setString(13, patient.getAdmissionType());
            stmt.setDate(14, Date.valueOf(patient.getDischargeDate()));
            stmt.setString(15, patient.getMedication());
            stmt.setString(16, patient.getTestResults());  // Change 'test_result' to 'test_results'
            stmt.setInt(17, patient.getPatientId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient(int patientId) {
        String sql = "DELETE FROM Patient WHERE patient_id = ?"; // Keep the table name as 'patient'

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}