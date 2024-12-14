package com.hospital.gui;

import com.hospital.database.PatientOperations;
import com.hospital.models.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyPatientDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private Patient patient;
    private JTextField nameField, ageField, genderField, bloodTypeField, conditionField;
    private JTextField doctorIdField, doctorNameField, hospitalField, insuranceField;
    private JTextField roomField, admissionTypeField, dischargeDateField, medicationField, testResultField;
    private JTextField dateOfAdmissionField;  // Added for LocalDate input
    private JButton saveButton, cancelButton;

    public ModifyPatientDialog(Frame owner, Patient patient) {
        super(owner, "Modify Patient", true);
        this.patient = patient;

        setLayout(new GridLayout(0, 2, 10, 10));
        setSize(500, 500);
        setLocationRelativeTo(owner);

        // Create input fields for patient details
        add(new JLabel("Name:"));
        nameField = new JTextField(patient.getName());
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField(String.valueOf(patient.getAge()));
        add(ageField);

        add(new JLabel("Gender:"));
        genderField = new JTextField(patient.getGender());
        add(genderField);

        add(new JLabel("Blood Type:"));
        bloodTypeField = new JTextField(patient.getBloodType());
        add(bloodTypeField);

        add(new JLabel("Medical Condition:"));
        conditionField = new JTextField(patient.getMedicalCondition());
        add(conditionField);

        add(new JLabel("Doctor ID:"));
        doctorIdField = new JTextField(String.valueOf(patient.getDoctorId()));
        add(doctorIdField);

        add(new JLabel("Doctor Name:"));
        doctorNameField = new JTextField(patient.getDoctorName());
        add(doctorNameField);

        add(new JLabel("Hospital:"));
        hospitalField = new JTextField(patient.getHospital());
        add(hospitalField);

        add(new JLabel("Insurance Provider:"));
        insuranceField = new JTextField(patient.getInsuranceProvider());
        add(insuranceField);

        add(new JLabel("Room Number:"));
        roomField = new JTextField(String.valueOf(patient.getRoomNumber()));
        add(roomField);

        add(new JLabel("Admission Type:"));
        admissionTypeField = new JTextField(patient.getAdmissionType());
        add(admissionTypeField);

        add(new JLabel("Discharge Date:"));
        dischargeDateField = new JTextField(patient.getDischargeDate());
        add(dischargeDateField);

        add(new JLabel("Medication:"));
        medicationField = new JTextField(patient.getMedication());
        add(medicationField);

        add(new JLabel("Test Result:"));
        testResultField = new JTextField(patient.getTestResults());
        add(testResultField);

        add(new JLabel("Date of Admission (yyyy-MM-dd):"));  // Label for date of admission
        dateOfAdmissionField = new JTextField(patient.getDateOfAdmission().toString());  // Assuming patient.getDateOfAdmission() returns a LocalDate
        add(dateOfAdmissionField);

        // Save and cancel buttons
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        add(saveButton);
        add(cancelButton);

        // Event listener for save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePatient();
            }
        });

        // Event listener for cancel button
        cancelButton.addActionListener(e -> dispose());
    }

    private void savePatient() {
        // Update the patient object with new data
        patient.setName(nameField.getText());
        patient.setAge(Integer.parseInt(ageField.getText()));
        patient.setGender(genderField.getText());
        patient.setBloodType(bloodTypeField.getText());
        patient.setMedicalCondition(conditionField.getText());
        patient.setDoctorId(Integer.parseInt(doctorIdField.getText()));
        patient.setDoctorName(doctorNameField.getText());
        patient.setHospital(hospitalField.getText());
        patient.setInsuranceProvider(insuranceField.getText());
        patient.setRoomNumber(Integer.parseInt(roomField.getText()));
        patient.setAdmissionType(admissionTypeField.getText());
     
        // Correct usage of Discharge Date as LocalDate
        String dischargeDateString = dischargeDateField.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dischargeDate = LocalDate.parse(dischargeDateString, formatter);
        patient.setDischargeDate(dischargeDate);

        patient.setMedication(medicationField.getText());
        patient.setTestResults(testResultField.getText()); // No need to call this twice

        // Convert Date of Admission from String input to LocalDate
        String dateOfAdmissionString = dateOfAdmissionField.getText();
        LocalDate dateOfAdmission = LocalDate.parse(dateOfAdmissionString, formatter);
        patient.setDateOfAdmission(dateOfAdmission);

        // Save to database
        PatientOperations.updatePatient(patient);
        JOptionPane.showMessageDialog(this, "Patient updated successfully!");
        dispose(); // Close dialog after saving
    }
}
