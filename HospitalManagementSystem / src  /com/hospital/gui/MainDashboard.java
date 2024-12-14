package com.hospital.gui;

import java.awt.*;
import java.io.File;
import javax.swing.*;

//type of window that can display UI 
//2 panels header panel button panel
public class MainDashboard extends JFrame {
//maindashboard constructor buteegch
    private static final long serialVersionUID = 1L;

    public MainDashboard() {
        initialize();
    }
//initiliaze method sets the properties and UI elements 
    private void initialize() {
        // Set frame properties
        setTitle("Hospital Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Load background image
        File imgFile = new File("/Users/nomungerelm/Desktop/background.jpg");
        if (imgFile.exists()) {
            ImageIcon backgroundIcon = new ImageIcon(imgFile.getAbsolutePath());
            Image scaledImage = backgroundIcon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            backgroundIcon = new ImageIcon(scaledImage);

            JLabel background = new JLabel(backgroundIcon);
            background.setLayout(new BorderLayout());
            setContentPane(background); // Set the background as the content pane
        } else {
            System.out.println("Background image not found. Using fallback color.");
            getContentPane().setBackground(Color.LIGHT_GRAY); // Fallback background
        }

        // Header panel with title
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 130, 255)); // Custom header background color

        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>"
                + "<span style='font-size: 18px; color: white;'>Grand Med University Hospital</span><br>"
                + "<span style='font-size: 20px;'>Hello! Welcome to the Hospital Admin Portal</span>"
                + "</div></html>");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);

        headerPanel.add(welcomeLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Create a central grid layout for buttons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); // Transparent background for panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Buttons for different modules
        JButton patientButton = createStyledButton("Patient Management", "patient_icon.png");
        JButton doctorButton = createStyledButton("Doctor Management", "doctor_icon.png");
        JButton appointmentButton = createStyledButton("Appointment Management", "appointment_icon.png");
        JButton medicalRecordButton = createStyledButton("Medical Records", "medicalRecord_icon.png");

        // Add action listeners for buttons
        patientButton.addActionListener(e -> new PatientPage().setVisible(true));
        doctorButton.addActionListener(e -> new DoctorPage().setVisible(true));
        appointmentButton.addActionListener(e -> new AppointmentPage().setVisible(true));
        medicalRecordButton.addActionListener(e -> new MedicalRecordPage().setVisible(true));

        // Add buttons to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(patientButton, gbc);

        gbc.gridy++;
        buttonPanel.add(doctorButton, gbc);

        gbc.gridy++;
        buttonPanel.add(appointmentButton, gbc);

        gbc.gridy++;
        buttonPanel.add(medicalRecordButton, gbc);

        add(buttonPanel, BorderLayout.CENTER); // Add button panel to center
    }

    private JButton createStyledButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.BLUE);
        button.setBackground(new Color(50, 150, 250));
        button.setPreferredSize(new Dimension(250, 50));
        button.setFocusPainted(false);

        // Load and set icon
        File iconFile = new File("/Users/nomungerelm/Desktop/" + iconPath);
        if (iconFile.exists()) {
            ImageIcon icon = new ImageIcon(iconFile.getAbsolutePath());
            Image scaledIcon = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledIcon));
        }

        // Add hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 170, 250));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 150, 250));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainDashboard mainDashboard = new MainDashboard();
            mainDashboard.setVisible(true);
        });
    }
}
