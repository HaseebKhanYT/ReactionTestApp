package edu.neu.mgen.ACTION;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import edu.neu.mgen.RT_level3;

public class TestTypeSelectionWindow extends JFrame {
    public TestTypeSelectionWindow() {
        setTitle("Select Test Type");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a list of buttons for test types
        JButton testType1 = new JButton("Test Type 1");
        JButton testType2 = new JButton("Test Type 2");
        JButton testType3 = new JButton("Test Type 3");
        // JButton testType4 = new JButton("Test Type 4");

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(200, 50);
        testType1.setPreferredSize(buttonSize);
        testType2.setPreferredSize(buttonSize);
        testType3.setPreferredSize(buttonSize);
        // testType4.setPreferredSize(buttonSize);

        // Event listeners for each test type button
        testType1.addActionListener(e -> startTest(1));
        testType2.addActionListener(e -> startTest(2));
        testType3.addActionListener(e -> startTest(3));
        // testType4.addActionListener(e -> startTest(4));

        Font buttonFont = new Font("Arial", Font.PLAIN, 30);
        testType1.setFont(buttonFont);
        testType2.setFont(buttonFont);
        testType3.setFont(buttonFont);

        // Layout for buttons
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(testType1, gbc);
        add(testType2, gbc);
        add(testType3, gbc);
        // add(testType4, gbc);
    }

    private void startTest(int testType) {
        switch (testType) {
            case 1:
                new RT_level1().setVisible(true);
                break;
            case 2:
                new RT_level2().setVisible(true);
                break;
            case 3:
                new RT_level3().setVisible(true);
                break;
            // Add more cases here for additional test types if needed
        }
        dispose(); // Close the test type selection window
    }
}
