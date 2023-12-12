package edu.neu.mgen.ACTION;

import java.awt.BorderLayout;

import javax.swing.*;

public class InstructionsWindow extends JFrame {
    public InstructionsWindow() {
        setTitle("Instructions");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea instructionsArea = new JTextArea(
            "Instructions:\n" +
            "1. Select only the color you see on the screen\n" +
            "2. Press R when you see the color Red\n" +
            "3. Press G when you see the color Green\n" +
            "4. Press B when you see the color Blue\n" +
            "5. Try to react as fast as you can for a good score"
        );
        instructionsArea.setEditable(false);

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            new TestTypeSelectionWindow().setVisible(true);
            dispose();
        });

        add(instructionsArea, BorderLayout.CENTER);
        add(continueButton, BorderLayout.SOUTH);
    }
}
