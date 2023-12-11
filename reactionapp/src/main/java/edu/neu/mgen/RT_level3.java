package edu.neu.mgen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class RT_level3 extends JFrame {
    private long startTime, totalReactionTime = 0;
    private int correctResponses = 0;
    private Color currentColor;
    private final JLabel wordLabel;
    private final JLabel timeLabel;
    private int round = 0;
    private final String[] colorNames = {"red", "green", "blue"};

    public RT_level3() {
        wordLabel = new JLabel("Wait for words...", SwingConstants.CENTER);
        wordLabel.setForeground(Color.BLACK); // Set "Wait for words..." to always be black
        wordLabel.setFont(new Font("Serif", Font.BOLD, 48)); // Larger font for the word label

        timeLabel = new JLabel("Time: 0 ms", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 24)); // Larger font for the time label

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(wordLabel, BorderLayout.CENTER);
        panel.add(timeLabel, BorderLayout.SOUTH);

        add(panel);
        setSize(1000, 800); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RT Level 3");

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
            System.exit(0);
            return;
        }

        round++;
        wordLabel.setText("Wait for words...");
        wordLabel.setForeground(Color.BLACK); // Ensure "Wait for words..." is black
        new Timer(new Random().nextInt(2000) + 1000, e -> {
            String colorWord = getRandomColorWord();
            currentColor = getRandomColor();
            wordLabel.setText(colorWord);
            wordLabel.setForeground(currentColor); // Set the word to a random color
            startTime = System.currentTimeMillis();
            ((Timer)e.getSource()).stop();
        }).start();
    }

    private void handleKeyPress(char keyChar) {
        if (round > 5 || "Wait for words...".equals(wordLabel.getText())) return;

        long reactionTime = System.currentTimeMillis() - startTime;
        totalReactionTime += reactionTime;
        boolean correct = isCorrectResponse(keyChar, currentColor);
        if (correct) correctResponses++;

        timeLabel.setText("Time: " + reactionTime + " ms - " + (correct ? "Correct" : "Wrong"));
        nextRound();
    }

    private boolean isCorrectResponse(char keyChar, Color color) {
        if (color.equals(Color.RED) && keyChar == 'r') return true;
        if (color.equals(Color.GREEN) && keyChar == 'g') return true;
        if (color.equals(Color.BLUE) && keyChar == 'b') return true;
        return false;
    }

    private void showResults() {
        double averageTime = (double) totalReactionTime / 5;
        double accuracy = ((double) correctResponses / 5) * 100;
        JOptionPane.showMessageDialog(this, "Average Reaction Time: " + averageTime + " ms\nAccuracy: " + accuracy + "%");
    }

    private String getRandomColorWord() {
        return colorNames[new Random().nextInt(colorNames.length)];
    }

    private Color getRandomColor() {
        Random random = new Random();
        // Randomly select one of red, green, or blue colors
        switch (colorNames[random.nextInt(colorNames.length)]) {
            case "red": return Color.RED;
            case "green": return Color.GREEN;
            case "blue": return Color.BLUE;
            default: return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RT_level3().setVisible(true);
        });
    }
}
