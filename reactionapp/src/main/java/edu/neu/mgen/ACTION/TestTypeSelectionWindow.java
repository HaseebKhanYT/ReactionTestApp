package edu.neu.mgen.ACTION;

import java.awt.FlowLayout;

import javax.swing.*;

public class TestTypeSelectionWindow extends JFrame {
    public TestTypeSelectionWindow() {
        setTitle("Select Test Type");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a list or buttons for test types
        JButton testType1 = new JButton("Test Type 1");
        JButton testType2 = new JButton("Test Type 2");
        JButton testType3 = new JButton("Test Type 3");
        JButton testType4 = new JButton("Test Type 4");

        // Event listeners for each test type button
        testType1.addActionListener(e -> startTest(1));
        testType2.addActionListener(e -> startTest(2));
        testType3.addActionListener(e -> startTest(3));
        testType4.addActionListener(e -> startTest(4));

        // Layout for buttons
        setLayout(new FlowLayout());
        add(testType1);
        add(testType2);
        add(testType3);
        add(testType4);
    }

    private void startTest(int testType) {
        // You can modify RT_level2 constructor to take testType as a parameter
        // For now, we will just start it without passing test type
        new RT_level2().setVisible(true);
        dispose(); // Close the test type selection window
    }
}
