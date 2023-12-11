package edu.neu.mgen;

import javax.swing.SwingUtilities;
import java.awt.Frame;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        ReactionTestApp reactionTestApp = new ReactionTestApp();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReactionTestApp();
            }
        });
    }
}
