package edu.neu.mgen.ACTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RT_level1 extends JFrame {
    private long startTime, totalReactionTime = 0;
    private int correctResponses = 0;
    private Color currentColor;
    private final JPanel colorPanel;
    private final JLabel messageLabel;
    private final JLabel timeLabel;
    private int round = 0;

    public RT_level1() {
        colorPanel = new JPanel();
        colorPanel.setLayout(new BorderLayout());
        colorPanel.setBackground(Color.WHITE); // Initial background color

        messageLabel = new JLabel("Wait for colors...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Serif", Font.BOLD, 48)); // Larger font for the message label
        messageLabel.setForeground(Color.BLACK); // Set message label color

        timeLabel = new JLabel("Time: 0 ms", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 24)); // Larger font for the time label

        colorPanel.add(messageLabel, BorderLayout.CENTER);
        colorPanel.add(timeLabel, BorderLayout.SOUTH);

        add(colorPanel);
        setSize(800, 600); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RT Level 2");

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyChar());
            }
        });

        nextRound();
    }

    private void nextRound() {
        if (round >= 5) {
            showResults();
            // System.exit(0);
            return;
        }

        round++;
        colorPanel.setBackground(Color.WHITE); // Reset background color to white
        messageLabel.setText("Wait for colors..."); // Show waiting message

        new Timer(new Random().nextInt(2000) + 1000, e -> {
            currentColor = getRandomColor();
            colorPanel.setBackground(currentColor);
            messageLabel.setText(""); // Hide the message when color is displayed
            startTime = System.currentTimeMillis();
            ((Timer)e.getSource()).stop();
        }).start();
    }

    private void handleKeyPress(char keyChar) {
        if (round > 5 || colorPanel.getBackground().equals(Color.WHITE)) return;

        long reactionTime = System.currentTimeMillis() - startTime;
        totalReactionTime += reactionTime;
        boolean correct = (currentColor.equals(getColorFromChar(keyChar)));
        if (correct) correctResponses++;

        timeLabel.setText("Time: " + reactionTime + " ms - " + (correct ? "Correct" : "Wrong"));
        nextRound();
    }

    private Color getRandomColor() {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        return colors[new Random().nextInt(colors.length)];
    }

    private Color getColorFromChar(char keyChar) {
        switch (keyChar) {
            case 'r': return Color.RED;
            case 'g': return Color.GREEN;
            case 'b': return Color.BLUE;
            default: return Color.WHITE;
        }
    }

    private void showResults() {
        double averageTime = (double) totalReactionTime / 5;
        double accuracy = ((double) correctResponses / 5) * 100;
    
        // Create a JOptionPane with a custom message
        JOptionPane optionPane = new JOptionPane(
            "Average Reaction Time: " + averageTime + " ms\nAccuracy: " + accuracy + "%",
            JOptionPane.INFORMATION_MESSAGE);
    
        // Create a custom "Continue" button and add an action listener to it
        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            new TestTypeSelectionWindow().setVisible(true);
            dispose(); // Close the current window
        });
    
        // Set the option pane's options to include the custom button
        optionPane.setOptions(new Object[]{continueButton});
    
        // Create and display the dialog
        JDialog dialog = optionPane.createDialog(this, "Results");
        dialog.setVisible(true);
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         new TestTypeSelectionWindow().setVisible(true);
    //     });
    // }
}
