package edu.neu.mgen;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ReactionTestApp extends JFrame implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private JLabel scoreLabel;
    
    Random random = new Random();
    ReactionTestApp(){
        setTitle("Reaction Testing Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(COLORS[0]); // use this to color the background for level 1

        scoreLabel = new JLabel("Score: 0", JLabel.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    }



}
