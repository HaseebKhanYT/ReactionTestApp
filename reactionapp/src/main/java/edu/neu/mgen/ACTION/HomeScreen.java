package edu.neu.mgen.ACTION;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {
    public HomeScreen() {
        setTitle("Human Reaction Test");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BoxLayout for vertical alignment
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Human Reaction Test", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment

        // Start Button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Serif", Font.BOLD, 24));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        startButton.addActionListener(e -> {
            new ProductDescription().setVisible(true);
            dispose();
        });

        // Adding components to mainPanel
        mainPanel.add(Box.createVerticalGlue()); // Spacer
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Space between label and button
        mainPanel.add(startButton);
        mainPanel.add(Box.createVerticalGlue()); // Spacer

        // Footer Label
        JLabel footerLabel = new JLabel("Created by Team of Sergey", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Serif", Font.PLAIN, 18));

        // Adding panels to frame
        add(mainPanel, BorderLayout.CENTER);
        add(footerLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen().setVisible(true));
    }
}
