package com.hospital.gui;

import com.hospital.database.AppointmentOperation;
import com.hospital.models.Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AppointmentPage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable appointmentTable;
    private AppointmentOperation appointmentOperation;

    public AppointmentPage() {
        appointmentOperation = new AppointmentOperation();
        setTitle("Appointment Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout for buttons and table
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        // Table to display appointments
        String[] columns = {"Appointment ID", "Patient ID", "Doctor ID", "Date", "Time", "Status"};
        appointmentTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add appointment button
        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAppointmentDialog();
            }
        });
        topPanel.add(addButton);

        // Search appointment button
        JButton searchButton = new JButton("Search Appointment");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAppointmentDialog();
            }
        });
        topPanel.add(searchButton);

        // Delete appointment button
        JButton deleteButton = new JButton("Delete Appointment");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAppointmentDialog();
            }
        });
        bottomPanel.add(deleteButton);

        // Refresh appointments button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAppointments();
            }
        });
        bottomPanel.add(refreshButton);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initial load of appointments
        loadAppointments();
    }

    // Load appointments from the database into the table
    private void loadAppointments() {
        List<Appointment> appointments = appointmentOperation.getAllAppointments();
        Object[][] data = new Object[appointments.size()][6];
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            data[i][0] = appointment.getAppointmentId();
            data[i][1] = appointment.getPatientId();
            data[i][2] = appointment.getDoctorId();
            data[i][3] = appointment.getAppointmentDate();
            data[i][4] = appointment.getAppointmentTime();
            data[i][5] = appointment.getStatus();
        }

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{
                "Appointment ID", "Patient ID", "Doctor ID", "Date", "Time", "Status"
        }));
    }
//add
    private void addAppointmentDialog() {
        JTextField appointmentIdField = new JTextField();
        JTextField patientIdField = new JTextField();
        JTextField doctorIdField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField statusField = new JTextField();

        Object[] message = {
            "Appointment ID:", appointmentIdField,
            "Patient ID:", patientIdField,
            "Doctor ID:", doctorIdField,
            "Date (YYYY-MM-DD):", dateField,
            "Time (HH:MM):", timeField,
            "Status:", statusField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Appointment", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Appointment appointment = new Appointment(
                Integer.parseInt(appointmentIdField.getText()),
                Integer.parseInt(patientIdField.getText()),
                Integer.parseInt(doctorIdField.getText()),
                dateField.getText(),
                timeField.getText(),
                statusField.getText()
            );
            if (appointmentOperation.addAppointment(appointment)) {
                JOptionPane.showMessageDialog(this, "Appointment added successfully!");
                loadAppointments();
            } else {
                JOptionPane.showMessageDialog(this, "Error adding appointment.");
            }
        }
    }

    // Open dialog to search for an appointment
    private void searchAppointmentDialog() {
        String input = JOptionPane.showInputDialog(this, "Enter Appointment ID to search:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int appointmentId = Integer.parseInt(input.trim());
                Appointment appointment = appointmentOperation.searchAppointmentById(appointmentId);

                if (appointment != null) {
                    JOptionPane.showMessageDialog(this, "Appointment Found:\n" +
                            "ID: " + appointment.getAppointmentId() + "\n" +
                            "Patient ID: " + appointment.getPatientId() + "\n" +
                            "Doctor ID: " + appointment.getDoctorId() + "\n" +
                            "Date: " + appointment.getAppointmentDate() + "\n" +
                            "Time: " + appointment.getAppointmentTime() + "\n" +
                            "Status: " + appointment.getStatus());
                } else {
                    JOptionPane.showMessageDialog(this, "Appointment not found!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Appointment ID. Please enter a number.");
            }
        }
    }


    // Open dialog to delete an appointment
    private void deleteAppointmentDialog() {
        String appointmentIdStr = JOptionPane.showInputDialog(this, "Enter Appointment ID to delete:");
        if (appointmentIdStr != null) {
            int appointmentId = Integer.parseInt(appointmentIdStr);
            if (appointmentOperation.deleteAppointment(appointmentId)) {
                JOptionPane.showMessageDialog(this, "Appointment deleted successfully.");
                loadAppointments();
            } else {
                JOptionPane.showMessageDialog(this, "Error deleting appointment.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppointmentPage().setVisible(true));
    }
}
