package com.hospital.gui;

import com.hospital.database.DoctorOperation;
import com.hospital.models.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DoctorPage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField doctorIdField, nameField, specialtyField, contactField, availabilityField;
    private JTable doctorTable;
    private DoctorOperation doctorOperation;

    private static final String[] COLUMN_NAMES = {"Doctor ID", "Name", "Specialty", "Contact", "Availability"};

    public DoctorPage() {
        doctorOperation = new DoctorOperation();
        initialize();
    }

    private void initialize() {
        setTitle("Doctor Management");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Panel for input fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        getContentPane().add(panel, BorderLayout.NORTH);

        // Labels and fields for Doctor details
        JLabel doctorIdLabel = new JLabel("Doctor ID:");
        doctorIdField = new JTextField();
        panel.add(doctorIdLabel);
        panel.add(doctorIdField);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel specialtyLabel = new JLabel("Specialty:");
        specialtyField = new JTextField();
        panel.add(specialtyLabel);
        panel.add(specialtyField);

        JLabel contactLabel = new JLabel("Contact:");
        contactField = new JTextField();
        panel.add(contactLabel);
        panel.add(contactField);

        JLabel availabilityLabel = new JLabel("Availability:");
        availabilityField = new JTextField();
        panel.add(availabilityLabel);
        panel.add(availabilityField);

        // Add Doctor button
        JButton addButton = new JButton("Add Doctor");
        panel.add(addButton);

        // Delete Doctor button
        JButton deleteButton = new JButton("Delete Doctor");
        panel.add(deleteButton);

        // Table to display doctors
        doctorTable = new JTable();
        getContentPane().add(new JScrollPane(doctorTable), BorderLayout.CENTER);

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctor();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDoctor();
            }
        });

        // Load the doctor list into the table on initialization
        loadDoctors();
    }

    private void addDoctor() {
        String name = nameField.getText();
        String specialty = specialtyField.getText();
        String contact = contactField.getText();
        String availability = availabilityField.getText();

        // Basic validation: Check if fields are not empty
        if (name.isEmpty() || specialty.isEmpty() || contact.isEmpty() || availability.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!");
            return;
        }

        // Create a new Doctor object
        Doctor doctor = new Doctor(0, name, specialty, "", contact, "", 0, "", "");

        // Add doctor using DoctorOperation
        boolean success = doctorOperation.addDoctor(doctor);
        if (success) {
            JOptionPane.showMessageDialog(this, "Doctor added successfully!");
            clearForm();
            loadDoctors();
        } else {
            JOptionPane.showMessageDialog(this, "Error adding doctor.");
        }
    }

    private void deleteDoctor() {
        try {
            int doctorId = Integer.parseInt(doctorIdField.getText());
            boolean success = doctorOperation.fetchAndDeleteDoctorById(doctorId);
            if (success) {
                JOptionPane.showMessageDialog(this, "Doctor deleted successfully!");
                loadDoctors();
            } else {
                JOptionPane.showMessageDialog(this, "Doctor not found or could not be deleted.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Doctor ID.");
        }
    }

    private void loadDoctors() {
        List<Doctor> doctors = doctorOperation.getAllDoctors();
        Object[][] data = new Object[doctors.size()][COLUMN_NAMES.length];

        for (int i = 0; i < doctors.size(); i++) {
            Doctor d = doctors.get(i);
            data[i][0] = d.getDoctorID();
            data[i][1] = d.getName();
            data[i][2] = d.getSpecialty();
            data[i][3] = d.getPhoneNumber();
            data[i][4] = "Available"; // Placeholder for availability
        }

        // Set table model with the data
        doctorTable.setModel(new javax.swing.table.DefaultTableModel(data, COLUMN_NAMES));
    }

    private void clearForm() {
        doctorIdField.setText("");
        nameField.setText("");
        specialtyField.setText("");
        contactField.setText("");
        availabilityField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoctorPage().setVisible(true);
            }
        });
    }
}
