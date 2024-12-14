package com.hospital.gui;

import com.hospital.database.MedicalRecordOperation;
import com.hospital.models.MedicalRecords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MedicalRecordPage {
    private JFrame frame;
    private JTextField patientIdField, doctorIdField, diagnosisField, treatmentField, prescriptionField;
    private JTable recordTable;
    private MedicalRecordOperation medicalRecordOperation;

    public MedicalRecordPage() {
        medicalRecordOperation = new MedicalRecordOperation();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Medical Record Management");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel for input fields and buttons in a single column
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));  // Two columns for a cleaner look
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        // Adding labels and text fields
        JLabel patientIdLabel = new JLabel("Patient ID:");
        patientIdField = new JTextField();
        panel.add(patientIdLabel);
        panel.add(patientIdField);

        JLabel doctorIdLabel = new JLabel("Doctor ID:");
        doctorIdField = new JTextField();
        panel.add(doctorIdLabel);
        panel.add(doctorIdField);

        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        diagnosisField = new JTextField();
        panel.add(diagnosisLabel);
        panel.add(diagnosisField);

        JLabel treatmentLabel = new JLabel("Treatment:");
        treatmentField = new JTextField();
        panel.add(treatmentLabel);
        panel.add(treatmentField);

        JLabel prescriptionLabel = new JLabel("Prescription:");
        prescriptionField = new JTextField();
        panel.add(prescriptionLabel);
        panel.add(prescriptionField);

        // Adding buttons
        JButton addButton = new JButton("Add Medical Record");
        panel.add(addButton);

        JButton updateButton = new JButton("Update Medical Record");
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete Medical Record");
        panel.add(deleteButton);

        // Table for displaying medical record data
        recordTable = new JTable();
        frame.getContentPane().add(new JScrollPane(recordTable), BorderLayout.CENTER);

        // Action listener for adding a new medical record
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicalRecord();
            }
        });

        // Action listener for updating a selected medical record
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMedicalRecord();
            }
        });

        // Action listener for deleting a selected medical record
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMedicalRecord();
            }
        });

        loadMedicalRecords();  // Load existing records into the table
    }

    private void addMedicalRecord() {
        try {
            int patientId = Integer.parseInt(patientIdField.getText());
            int doctorId = Integer.parseInt(doctorIdField.getText());
            String diagnosis = diagnosisField.getText();
            String treatment = treatmentField.getText();
            String prescription = prescriptionField.getText();

            if (diagnosis.isEmpty() || treatment.isEmpty() || prescription.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled.");
                return;
            }

            String recordDate = java.time.LocalDate.now().toString();
            MedicalRecords medicalRecord = new MedicalRecords(0, patientId, doctorId, diagnosis, treatment, prescription, recordDate);

            boolean success = medicalRecordOperation.addMedicalRecord(medicalRecord);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Medical record added successfully!");
                clearForm();
                loadMedicalRecords();
            } else {
                JOptionPane.showMessageDialog(frame, "Error adding medical record.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for Patient ID and Doctor ID.");
        }
    }

    private void updateMedicalRecord() {
        int selectedRow = recordTable.getSelectedRow();
        if (selectedRow != -1) {
            int recordId = (int) recordTable.getValueAt(selectedRow, 0);  // Get record ID from the selected row
            String diagnosis = diagnosisField.getText();
            String treatment = treatmentField.getText();
            String prescription = prescriptionField.getText();

            if (diagnosis.isEmpty() || treatment.isEmpty() || prescription.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled.");
                return;
            }

            MedicalRecords medicalRecord = new MedicalRecords(recordId, Integer.parseInt(patientIdField.getText()), 
                Integer.parseInt(doctorIdField.getText()), diagnosis, treatment, prescription, java.time.LocalDate.now().toString());
            boolean success = medicalRecordOperation.updateMedicalRecord(medicalRecord);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Medical record updated successfully!");
                loadMedicalRecords();
            } else {
                JOptionPane.showMessageDialog(frame, "Error updating medical record.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a medical record to update.");
        }
    }

    private void deleteMedicalRecord() {
        int selectedRow = recordTable.getSelectedRow();
        if (selectedRow != -1) {
            int recordId = (int) recordTable.getValueAt(selectedRow, 0);  // Get record ID from the selected row
            boolean success = medicalRecordOperation.deleteMedicalRecord(recordId);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Medical record deleted successfully!");
                loadMedicalRecords();
                clearForm();  // Clear form after deletion
            } else {
                JOptionPane.showMessageDialog(frame, "Error deleting medical record.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a medical record to delete.");
        }
    }

    private void loadMedicalRecords() {
        List<MedicalRecords> medicalRecords = medicalRecordOperation.getAllMedicalRecords();
        String[] columnNames = {"Record ID", "Patient ID", "Doctor ID", "Diagnosis", "Treatment", "Prescription", "Record Date"};
        Object[][] data = new Object[medicalRecords.size()][7];

        // Populate the data array with fetched records
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecords record = medicalRecords.get(i);
            data[i][0] = record.getRecordID();
            data[i][1] = record.getPatientID();
            data[i][2] = record.getDoctorID();
            data[i][3] = record.getDiagnosis();
            data[i][4] = record.getTreatment();
            data[i][5] = record.getPrescription();
            data[i][6] = record.getRecordDate();
        }

        // Create and set the table model
        recordTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }



    private void clearForm() {
        patientIdField.setText("");
        doctorIdField.setText("");
        diagnosisField.setText("");
        treatmentField.setText("");
        prescriptionField.setText("");
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MedicalRecordPage().show();
            }
        });
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);  // Ensure the frame can be set visible
    }
}
