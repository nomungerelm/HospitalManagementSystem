package com.hospital.database;

import com.hospital.models.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentOperation {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASSWORD = "bilig616";

    // Method to establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to add a new appointment
    public boolean addAppointment(Appointment appointment) {
        String query = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(3, appointment.getAppointmentDate());
            stmt.setString(4, appointment.getAppointmentTime());
            stmt.setString(5, appointment.getStatus());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointment";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Appointment appointment = new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("appointment_date"),
                        rs.getString("appointment_time"),
                        rs.getString("status")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // Method to delete an appointment by ID
    public boolean deleteAppointment(int appointmentId) {
        String query = "DELETE FROM appointment WHERE appointment_id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointmentId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 // Method to search for an appointment by ID
    public Appointment searchAppointmentById(int appointmentId) {
        Appointment appointment = null;
        String query = "SELECT * FROM appointment WHERE appointment_id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointmentId); // Set the appointment ID parameter
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Map the result set to an Appointment object
                    appointment = new Appointment(
                            rs.getInt("appointment_id"),
                            rs.getInt("patient_id"),
                            rs.getInt("doctor_id"),
                            rs.getString("appointment_date"),
                            rs.getString("appointment_time"),
                            rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log any SQL exceptions
        }

        return appointment; // Return the appointment object (or null if not found)
    }

	public Appointment getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
