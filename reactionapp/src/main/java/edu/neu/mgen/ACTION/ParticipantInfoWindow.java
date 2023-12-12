package edu.neu.mgen.ACTION;

import javax.swing.*;
import java.awt.*;

public class ParticipantInfoWindow extends JFrame {
    ////////////////////////////////////////////////////////////////
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> genderComboBox;
    private JCheckBox anagraphCheckBox;
    ////////////////////////////////////////////////////////////////

    public ParticipantInfoWindow() {
        setTitle("Enter your details");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with GridBagLayout for flexible component placement
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Insets for padding and larger font
        Insets insets = new Insets(10, 10, 10, 10);
        Font labelFont = new Font("Serif", Font.PLAIN, 24);
        Font textFont = new Font("Serif", Font.PLAIN, 20);

        gbc.insets = insets;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Name Label and Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setFont(textFont);
        mainPanel.add(nameField, gbc);

        // Age Label and Field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(labelFont);
        mainPanel.add(ageLabel, gbc);

        gbc.gridx = 1;
        JTextField ageField = new JTextField(20);
        ageField.setFont(textFont);
        mainPanel.add(ageField, gbc);

        // Gender Label and ComboBox
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderComboBox.setFont(textFont);
        mainPanel.add(genderComboBox, gbc);

        // Anagraph Label and CheckBox
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel anagraphLabel = new JLabel("Myopia?");
        anagraphLabel.setFont(labelFont);
        mainPanel.add(anagraphLabel, gbc);

        gbc.gridx = 1;
        JCheckBox anagraphCheckBox = new JCheckBox();
        anagraphCheckBox.setFont(textFont);
        mainPanel.add(anagraphCheckBox, gbc);

        // Continue Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(textFont);
        continueButton.addActionListener(e -> {
            // submitParticipantInfo();//////
            new InstructionsWindow().setVisible(true);
            dispose();
        });
        mainPanel.add(continueButton, gbc);

        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);

    }

    
    //////////////////////////////////////////////////////////////
    private void submitParticipantInfo() {
        String name = nameField.getText();
        int age;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.");
            return;
        }
        String gender = (String) genderComboBox.getSelectedItem();

        // Call to database operation
        DatabaseOperations.insertParticipant(name, age, gender);

        System.out.println("submitParticipant");

        // Optionally, navigate to next window or show a confirmation
        new InstructionsWindow().setVisible(true);
        dispose();
    }
    //////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ParticipantInfoWindow().setVisible(true));
    }
}
