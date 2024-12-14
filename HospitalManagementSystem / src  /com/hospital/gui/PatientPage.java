package com.hospital.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.hospital.database.PatientOperations;
import com.hospital.models.Patient;

public class PatientPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable patientTable;
    private JScrollPane scrollPane;
    private JTextField searchField;
    private JButton addButton, searchButton, modifyButton, deleteButton;

    public PatientPage() {
        setTitle("Patient Management");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Control Panel for Buttons
        JPanel controlPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(15);
        searchButton = new JButton("Search");
        addButton = new JButton("Add Patient");
        modifyButton = new JButton("Modify Patient");
        deleteButton = new JButton("Delete Patient");

        controlPanel.add(new JLabel("Search:"));
        controlPanel.add(searchField);
        controlPanel.add(searchButton);
        controlPanel.add(addButton);
        controlPanel.add(modifyButton);
        controlPanel.add(deleteButton);

        // Table for displaying patient data
        String[] columns = {
            "Patient ID", "Name", "Age", "Gender", "Blood Type", "Medical Condition", 
            "Date of Admission", "Doctor ID", "Doctor Name", "Hospital", "Insurance Provider", 
            "Billing Amount", "Room Number", "Admission Type", "Discharge Date", "Medication", "Test Results"
        };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        patientTable = new JTable(tableModel);
        scrollPane = new JScrollPane(patientTable);

        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Load patient data into the table
        loadPatientData();

        // Event Listeners
        addButton.addActionListener(e -> openAddPatientDialog());
        searchButton.addActionListener(e -> searchPatient());
        modifyButton.addActionListener(e -> modifyPatient());
        deleteButton.addActionListener(e -> deletePatient());
    }

    public void loadPatientData() {
        List<Patient> patients = PatientOperations.getAllPatients();
        DefaultTableModel tableModel = (DefaultTableModel) patientTable.getModel();
        tableModel.setRowCount(0); // Clear previous rows

        for (Patient patient : patients) {
            Object[] rowData = {
                patient.getPatientId(),
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getBloodType(),
                patient.getMedicalCondition(),
                patient.getDateOfAdmission(),
                patient.getDoctorId(),
                patient.getDoctorName(),
                patient.getHospital(),
                patient.getInsuranceProvider(),
                patient.getBillingAmount(),
                patient.getRoomNumber(),
                patient.getAdmissionType(),
                patient.getDischargeDate(),
                patient.getMedication(),
                patient.getTestResults()
            };
            tableModel.addRow(rowData);
        }
    }

    public void searchPatient() {
        String searchTerm = searchField.getText();
        List<Patient> patients = PatientOperations.searchPatient(searchTerm);
        DefaultTableModel tableModel = (DefaultTableModel) patientTable.getModel();
        tableModel.setRowCount(0); // Clear previous rows

        for (Patient patient : patients) {
            Object[] rowData = {
                patient.getPatientId(),
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getBloodType(),
                patient.getMedicalCondition(),
                patient.getDateOfAdmission(),
                patient.getDoctorId(),
                patient.getDoctorName(),
                patient.getHospital(),
                patient.getInsuranceProvider(),
                patient.getBillingAmount(),
                patient.getRoomNumber(),
                patient.getAdmissionType(),
                patient.getDischargeDate(),
                patient.getMedication(),
                patient.getTestResults()
            };
            tableModel.addRow(rowData);
        }
    }

    public void openAddPatientDialog() {
        new AddPatientDialog(this).setVisible(true);
        loadPatientData(); // Refresh table after adding
    }

    public void modifyPatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow != -1) {
            int patientId = (int) patientTable.getValueAt(selectedRow, 0); // Get patient ID from table
            Patient patient = PatientOperations.getPatientById(patientId); // Fetch patient from the database
            if (patient != null) {
                new ModifyPatientDialog(this, patient).setVisible(true);
                loadPatientData(); // Refresh table after modification
            } else {
                JOptionPane.showMessageDialog(this, "Patient not found!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a patient to modify.");
        }
    }

    public void deletePatient() {
        int selectedRow = patientTable.getSelectedRow();
        if (selectedRow != -1) {
            int patientId = (int) patientTable.getValueAt(selectedRow, 0);
            PatientOperations.deletePatient(patientId); // Delete from database
            loadPatientData(); // Refresh table after deletion
        } else {
            JOptionPane.showMessageDialog(this, "Please select a patient to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PatientPage().setVisible(true));
    }
}
