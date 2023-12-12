package edu.neu.mgen.ACTION;

import java.awt.BorderLayout;

import javax.swing.*;

public class ProductDescription extends JFrame {
    public ProductDescription() {
        setTitle("Product Description");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea descriptionArea = new JTextArea("A short text describing data...");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            new ParticipantInfoWindow().setVisible(true);
            dispose();
        });

        add(scrollPane, BorderLayout.CENTER);
        add(continueButton, BorderLayout.SOUTH);
    }
}
