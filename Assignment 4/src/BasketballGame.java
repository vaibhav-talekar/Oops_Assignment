import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class BasketballGame extends JPanel implements ActionListener {
    private Timer timer;
    private BufferedImage ballImage;
    private BufferedImage basketImage;
    private double ballX, ballY;
    private double angle;
    private double ballSpeedX, ballSpeedY;
    private boolean isBallMoving;
    private boolean roundEnded;
    private int scorePlayer1, scorePlayer2;
    private int currentPlayer; // 1 for Player 1, 2 for Player 2
    private final double gravity = 0.4;
    private double throwSpeed = 10;
    private final int basketX = 1800;
    private final int basketY = 300;
    private final double ballScale = 0.5;
    private int roundcount = 0;

    // Oscillation variables
    private double oscillationAmplitude = 5;
    private double oscillationFrequency = 0.1;
    private double oscillationPhase = 0;

    public BasketballGame() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
        loadImages();
        resetGame();

        timer = new Timer(5, this);
        timer.start();

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                if (!roundEnded && roundcount < 10) {
                    angle = Math.atan2(e.getY() - ballY, e.getX() - ballY);
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isBallMoving && !roundEnded && currentPlayer == 1) {
                    ballSpeedX = Math.cos(angle) * throwSpeed;
                    ballSpeedY = Math.sin(angle) * throwSpeed;
                    isBallMoving = true;
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER && !isBallMoving && !roundEnded && currentPlayer == 2) {
                    ballSpeedX = Math.cos(angle) * throwSpeed;
                    ballSpeedY = Math.sin(angle) * throwSpeed;
                    isBallMoving = true;
                }
            }
        });

        addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                throwSpeed += e.getWheelRotation();
                throwSpeed = Math.max(1, throwSpeed);
            }
        });
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                   resetGame();
                }
            } });
        setFocusable(true);
    }

    private void loadImages() {
        try {
            ballImage = javax.imageio.ImageIO.read(getClass().getResource("basketball.png"));
            basketImage = javax.imageio.ImageIO.read(getClass().getResource("basket.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(basketImage, basketX, basketY, null);

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldTransform = g2d.getTransform();
        g2d.scale(ballScale, ballScale);
        g2d.drawImage(ballImage, (int) (ballX / ballScale), (int) (ballY / ballScale), null);
        g2d.setTransform(oldTransform);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Player 1 Score: " + scorePlayer1, 20, 30);
        g.drawString("Player 2 Score: " + scorePlayer2, 20, 60);
        g.drawString("Throw Speed: " + String.format("%.1f", throwSpeed), 20, 90);
        g.drawString("Current Player: " + (currentPlayer == 1 ? "Player 1" : "Player 2"), 20, 120);

        if (roundEnded) {
            if (roundcount >= 5) {
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Game Over! ", 200, 300);
                g.drawString("Final Score - Player 1: " + scorePlayer1 + " | Player 2: " + scorePlayer2, 150, 350);
            } else {
                continueGame();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Update the ball's oscillation phase
        oscillationPhase += oscillationFrequency;
        ballX += Math.sin(oscillationPhase) * oscillationAmplitude;

        if (isBallMoving) {
            ballSpeedY += gravity;
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            if (ballX >= basketX && ballY <= basketY + 50 && ballY >= basketY) {
                if (currentPlayer == 1) {
                    scorePlayer1++;
                } else {
                    scorePlayer2++;
                }
                roundcount++;
                isBallMoving = false;
                roundEnded = true;
                ballX = 100;
                ballY = 500;
            }

            if (ballY >= getHeight() - ballImage.getHeight() * ballScale) {
                ballY = getHeight() - ballImage.getHeight() * ballScale;
                ballSpeedY = -ballSpeedY * 0.8;
            }

            if (ballX < 0 || ballX > getWidth()) {
                roundcount++;
                continueGame();
            }

            if (ballY > getHeight()) {
                roundcount++;
                continueGame();
            }
        }
        repaint();
    }

    private void resetGame() {
        ballX = 100;
        ballY = 500;
        angle = 0;
        ballSpeedX = 0;
        ballSpeedY = 0;
        isBallMoving = false;
        roundEnded = false;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        currentPlayer = 1; // Start with Player 1
        roundcount = 0;
    }

    private void continueGame() {
        if (roundcount >= 10) {
            ballX = 100;
            ballY = 500;
            angle = 0;
            ballSpeedX = 0;
            ballSpeedY = 0;
            isBallMoving = false;
            roundEnded = true;
        } else {
            ballX = 100;
            ballY = 500;
            angle = 0;
            ballSpeedX = 0;
            ballSpeedY = 0;
            isBallMoving = false;
            roundEnded = false;
            currentPlayer = (currentPlayer == 1) ? 2 : 1; // Switch player
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Basketball Game");
        BasketballGame gamePanel = new BasketballGame();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

       /* frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    gamePanel.resetGame();
                }
            }
        });*/
    }
}
