package edu.neu.mgen.ACTION;

import javax.swing.*;

public class HomeScreen extends JFrame {
    public HomeScreen() {
        setTitle("Human Reaction Test");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            new ProductDescription().setVisible(true);
            dispose();
        });

        add(startButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen().setVisible(true));
    }
}
