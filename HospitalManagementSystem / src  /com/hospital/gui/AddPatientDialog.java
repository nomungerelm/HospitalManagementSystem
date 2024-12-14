package com.hospital.gui;

import com.hospital.database.PatientOperations;
import com.hospital.models.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatientDialog extends JDialog {
	private static final long serialVersionUID = 1L;
    private JTextField nameField, ageField, genderField, bloodTypeField, medicalConditionField, dateOfAdmissionField;
    private JTextField doctorIdField, doctorNameField, hospitalField, insuranceProviderField, billingAmountField;
    private JTextField roomNumberField, admissionTypeField, dischargeDateField, medicationField, testResultsField;
    private JButton saveButton, cancelButton;

    public AddPatientDialog(Frame parent) {
        super(parent, "Add New Patient", true);
        setSize(400, 600);
        setLocationRelativeTo(parent);

        // Panel for form inputs
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(17, 2, 10, 10));

        // Form Fields
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        formPanel.add(genderField);

        formPanel.add(new JLabel("Blood Type:"));
        bloodTypeField = new JTextField();
        formPanel.add(bloodTypeField);

        formPanel.add(new JLabel("Medical Condition:"));
        medicalConditionField = new JTextField();
        formPanel.add(medicalConditionField);

        formPanel.add(new JLabel("Date of Admission:"));
        dateOfAdmissionField = new JTextField();
        formPanel.add(dateOfAdmissionField);

        formPanel.add(new JLabel("Doctor ID:"));
        doctorIdField = new JTextField();
        formPanel.add(doctorIdField);

        formPanel.add(new JLabel("Doctor Name:"));
        doctorNameField = new JTextField();
        formPanel.add(doctorNameField);

        formPanel.add(new JLabel("Hospital:"));
        hospitalField = new JTextField();
        formPanel.add(hospitalField);

        formPanel.add(new JLabel("Insurance Provider:"));
        insuranceProviderField = new JTextField();
        formPanel.add(insuranceProviderField);

        formPanel.add(new JLabel("Billing Amount:"));
        billingAmountField = new JTextField();
        formPanel.add(billingAmountField);

        formPanel.add(new JLabel("Room Number:"));
        roomNumberField = new JTextField();
        formPanel.add(roomNumberField);

        formPanel.add(new JLabel("Admission Type:"));
        admissionTypeField = new JTextField();
        formPanel.add(admissionTypeField);

        formPanel.add(new JLabel("Discharge Date:"));
        dischargeDateField = new JTextField();
        formPanel.add(dischargeDateField);

        formPanel.add(new JLabel("Medication:"));
        medicationField = new JTextField();
        formPanel.add(medicationField);

        formPanel.add(new JLabel("Test Results:"));
        testResultsField = new JTextField();
        formPanel.add(testResultsField);

        // Save and Cancel buttons
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        formPanel.add(saveButton);
        formPanel.add(cancelButton);

        // Add form panel to dialog
        add(formPanel, BorderLayout.CENTER);

        // Button actions Used to define actions for the buttons.
        //Triggers navigation to different pages
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect data from the form with validation
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();
                String gender = genderField.getText().trim();
                String bloodType = bloodTypeField.getText().trim();
                String medicalCondition = medicalConditionField.getText().trim();
                String dateOfAdmission = dateOfAdmissionField.getText().trim();
                String doctorIdText = doctorIdField.getText().trim();
                String doctorName = doctorNameField.getText().trim();
                String hospital = hospitalField.getText().trim();
                String insuranceProvider = insuranceProviderField.getText().trim();
                String billingAmountText = billingAmountField.getText().trim();
                String roomNumberText = roomNumberField.getText().trim();
                String admissionType = admissionTypeField.getText().trim();
                String dischargeDate = dischargeDateField.getText().trim();
                String medication = medicationField.getText().trim();
                String testResults = testResultsField.getText().trim();

                // Validate the fields to ensure they are not empty and contain valid data
                if (name.isEmpty() || gender.isEmpty() || bloodType.isEmpty() || medicalCondition.isEmpty() ||
                    dateOfAdmission.isEmpty() || doctorName.isEmpty() || hospital.isEmpty() || insuranceProvider.isEmpty() ||
                    admissionType.isEmpty() || dischargeDate.isEmpty() || medication.isEmpty() || testResults.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                    return;  // Exit if required fields are empty
                }

                try {
                    // Validate integer fields
                    int age = Integer.parseInt(ageText);
                    int doctorId = Integer.parseInt(doctorIdText);
                    int roomNumber = Integer.parseInt(roomNumberText);

                    // Validate double fields
                    double billingAmount = Double.parseDouble(billingAmountText);

                    // Create a new patient object
                    Patient newPatient = new Patient(0, name, age, gender, bloodType, medicalCondition, dateOfAdmission,
                            doctorId, doctorName, hospital, insuranceProvider, billingAmount, roomNumber, admissionType,
                            dischargeDate, medication, testResults);

                    // Save the patient data to the database
                    PatientOperations.addPatient(newPatient);
                    JOptionPane.showMessageDialog(AddPatientDialog.this, "Patient added successfully!");
                    // Close the dialog after saving
                    dispose();

                } catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(AddPatientDialog.this, "Please enter valid numbers for age, doctor ID, room number, and billing amount.");
                }
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog without saving
            }
        });
    }
}