package edu.neu.mgen.ACTION;

import java.awt.*;
import javax.swing.*;

public class ProductDescription extends JFrame {
    public ProductDescription() {
        setTitle("Data Collection");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Data Collection", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(titleLabel, BorderLayout.NORTH);

        // Description Text Panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        JTextArea descriptionText = new JTextArea("This program may collect data.");
        descriptionText.setEditable(false);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setLineWrap(true);
        descriptionText.setFont(new Font("Serif", Font.PLAIN, 30));
        descriptionText.setBackground(getBackground());
        descriptionText.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add some vertical space
        textPanel.add(Box.createVerticalGlue());
        textPanel.add(descriptionText);
        textPanel.add(Box.createVerticalGlue());

        add(textPanel, BorderLayout.CENTER);

        // Acknowledgment Checkbox and Label
        JCheckBox ackCheckbox = new JCheckBox();
        JLabel ackLabel = new JLabel("<html>I accept that my response and reaction time along with my age, gender, and eye conditions may be recorded for the research project done by the team 'Call of Sergey'</html>");
        ackLabel.setFont(new Font("Serif", Font.PLAIN, 18)); // Increased font size

        JPanel ackPanel = new JPanel();
        ackPanel.setLayout(new BoxLayout(ackPanel, BoxLayout.LINE_AXIS));
        ackPanel.add(ackCheckbox);
        ackPanel.add(Box.createRigidArea(new Dimension(5, 0))); // Small horizontal space between checkbox and label
        ackPanel.add(ackLabel);

        // Add vertical padding above the acknowledgment
        JPanel paddedAckPanel = new JPanel(new BorderLayout());
        paddedAckPanel.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH); // Vertical space
        paddedAckPanel.add(ackPanel, BorderLayout.CENTER);

        // Continue Button
        JButton continueButton = new JButton("Continue");
        continueButton.setEnabled(false); // Initially disabled
        continueButton.addActionListener(e -> {
            new ParticipantInfoWindow().setVisible(true);
            dispose();
        });

        // Enable Continue button when Checkbox is selected
        ackCheckbox.addActionListener(e -> continueButton.setEnabled(ackCheckbox.isSelected()));

        // Add Checkbox Panel and Continue Button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(paddedAckPanel, BorderLayout.CENTER);
        bottomPanel.add(continueButton, BorderLayout.PAGE_END);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductDescription().setVisible(true));
    }
}
