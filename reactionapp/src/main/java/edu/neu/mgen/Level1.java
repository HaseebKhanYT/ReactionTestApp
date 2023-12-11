import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorReactionGame1 extends JFrame implements ActionListener, KeyListener {
    private static final int TARGET_SCORE = 10;

    private JPanel panel;
    private JLabel imageLabel, scoreLabel, timerLabel;
    private int score;
    private Timer timer;
    private Random random;
    private long startTime;
    private String currentColor;

    private Map<String, ImageIcon> imageMap;

    public ColorReactionGame1() {
        setTitle("Color Reaction Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240)); // Light background color
        panel.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        timerLabel = new JLabel("Time: 0");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.setBackground(new Color(200, 200, 200)); // Darker background color for top panel
        topPanel.add(scoreLabel);
        topPanel.add(timerLabel);

        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(topPanel, BorderLayout.NORTH);

        add(panel);

        score = 0;
        timer = new Timer(1000, this);
        random = new Random();
        imageMap = new HashMap<>();

        addKeyListener(this);
        setFocusable(true);

        loadImages();
        startGame();
    }

    private void loadImages() {
        imageMap.put("red", new ImageIcon(getClass().getImage("C:\\Users\\vikra\\OneDrive\\Desktop\\AED classroom tasks\\red.avif")));
        imageMap.put("green", new ImageIcon(getClass().getResource("C:\\Users\\vikra\\OneDrive\\Desktop\\AED classroom tasks\\green.jpeg")));
        imageMap.put("blue", new ImageIcon(getClass().getResource("C:\\Users\\vikra\\OneDrive\\Desktop\\AED classroom tasks\\green.jpeg")));
    }

    private void startGame() {
        score = 0;
        updateScoreLabel();
        startTime = System.currentTimeMillis();
        updateTimerLabel();

        nextColor();
        timer.start();
    }

    private void nextColor() {
        String[] colors = {"red", "green", "blue"};
        String newColor;
        do {
            newColor = colors[random.nextInt(colors.length)];
        } while (newColor.equals(currentColor));

        currentColor = newColor;
        imageLabel.setIcon(imageMap.get(currentColor));
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    private void updateTimerLabel() {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        timerLabel.setText("Time: " + elapsedTime + "s");
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Your score is " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        startGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            updateTimerLabel();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char keyPressed = Character.toLowerCase(e.getKeyChar());
        char targetColor = currentColor.charAt(0);

        if (keyPressed == targetColor) {
            score++;
            updateScoreLabel();
            if (score == TARGET_SCORE) {
                gameOver();
            } else {
                nextColor();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ColorReactionGame1 game = new ColorReactionGame1();
            game.setVisible(true);
        });
    }
}
