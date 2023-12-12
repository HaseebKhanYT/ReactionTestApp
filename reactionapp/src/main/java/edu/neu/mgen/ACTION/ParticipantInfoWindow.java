package edu.neu.mgen.ACTION;

import javax.swing.*;
import java.awt.*;

public class ParticipantInfoWindow extends JFrame {
    public ParticipantInfoWindow() {
        setTitle("Enter your details");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2));
        add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        JTextField ageField = new JTextField();
        add(ageField);

        add(new JLabel("Gender:"));
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        add(genderComboBox);

        add(new JLabel("Anagraph:"));
        JCheckBox anagraphCheckBox = new JCheckBox();
        add(anagraphCheckBox);

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            new InstructionsWindow().setVisible(true);
            dispose();
        });
        add(continueButton);
    }
}
