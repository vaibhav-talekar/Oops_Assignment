import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {

    public static final int INITIAL_HEALTH = 60;
    public static final int SCORE_INCREMENT = 20;

    public static int healthScore = INITIAL_HEALTH;
    public static int gameScore = 0;
    public static String selectedWeapon = "";

    private JLabel healthLabel;
    private JLabel scoreLabel;
    private JLabel messageLabel;
    private JButton btnMysteriousForest, btnDangerousCave, btnAbandonedFort, btnFight, btnEscape;

    public Main() {
        initUI();
    }

    private void initUI() {
        setTitle("Java Adventure Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        healthLabel = new JLabel("Health: " + healthScore);
        scoreLabel = new JLabel("Score: " + gameScore);
        messageLabel = new JLabel("Choose your path:");

        btnMysteriousForest = new JButton("Way to Mysterious Forest");
        btnDangerousCave = new JButton("Way to Dangerous Cave");
        btnAbandonedFort = new JButton("Way to Abandoned Fort");

        btnMysteriousForest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWeapon = selectWeapon();
                forest(selectedWeapon);
            }
        });

        btnDangerousCave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWeapon = selectWeapon();
                cave(selectedWeapon);
            }
        });

        btnAbandonedFort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWeapon = selectWeapon();
                fort(selectedWeapon);
            }
        });

        panel.add(healthLabel);
        panel.add(scoreLabel);
        panel.add(messageLabel);
        panel.add(btnMysteriousForest);
        panel.add(btnDangerousCave);
        panel.add(btnAbandonedFort);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }

    private String selectWeapon() {
        int option = JOptionPane.showConfirmDialog(this, "Trade 10 health to open the treasure box?", "Treasure Box",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            healthScore -= 10;
            updateHealthLabel();
            if (healthScore <= 0) {
                restart();
                return "";
            }
            String weapon = getRandomWeapon();
            JOptionPane.showMessageDialog(this, "You traded health for a weapon and received: " + weapon);
            return weapon;
        } else {
            JOptionPane.showMessageDialog(this, "You decided to proceed without a new weapon.");
            return "";
        }
    }

    private void forest(String selectedWeapon) {
        String[] options = {"Fight the Tree Giant", "Escape"};
        int choice = JOptionPane.showOptionDialog(this, "You have entered the mysterious forest. There is a Tree Giant ahead.",
                "Forest Encounter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            String requiredWeapon = "Sword";
            if (requiredWeapon.equals(selectedWeapon)) {
                gameScore += SCORE_INCREMENT;
                JOptionPane.showMessageDialog(this, "Tree Giant Defeated! Your Score: " + gameScore);
                updateScoreLabel();
                continueGame();
            } else if (selectedWeapon.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tree Giant tears you apart!");
                restart();
            } else {
                healthScore -= 20;
                JOptionPane.showMessageDialog(this, "Your " + selectedWeapon + " is ineffective. Tree Giant dealt damage!");
                updateHealthLabel();
                if (healthScore <= 0) {
                    restart();
                }
                continueGame();
            }
        } else {
            healthScore -= 20;
            JOptionPane.showMessageDialog(this, "Escaped successfully.");
            updateHealthLabel();
            continueGame();
        }
    }

    private void cave(String selectedWeapon) {
        String[] options = {"Fight the Monster", "Escape"};
        int choice = JOptionPane.showOptionDialog(this, "You have entered the dangerous cave. There is a Monster ahead.",
                "Cave Encounter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            String requiredWeapon = "Bow";
            if (requiredWeapon.equals(selectedWeapon)) {
                gameScore += SCORE_INCREMENT;
                JOptionPane.showMessageDialog(this, "Monster Defeated! Your Score: " + gameScore);
                updateScoreLabel();
                continueGame();
            } else if (selectedWeapon.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Monster eats you alive!");
                restart();
            } else {
                healthScore -= 20;
                JOptionPane.showMessageDialog(this, "Your " + selectedWeapon + " is ineffective. Monster dealt damage!");
                updateHealthLabel();
                if (healthScore <= 0) {
                    restart();
                }
                continueGame();
            }
        } else {
            healthScore -= 20;
            JOptionPane.showMessageDialog(this, "Escaped successfully.");
            updateHealthLabel();
            continueGame();
        }
    }

    private void fort(String selectedWeapon) {
        String[] options = {"Fight the Rocky Creature", "Escape"};
        int choice = JOptionPane.showOptionDialog(this, "You have entered the Abandoned fort. There is a Rocky Creature ahead.",
                "Fort Encounter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            String requiredWeapon = "Magic Staff";
            if (requiredWeapon.equals(selectedWeapon)) {
                gameScore += SCORE_INCREMENT;
                JOptionPane.showMessageDialog(this, "Rocky Creature Defeated! Your Score: " + gameScore);
                updateScoreLabel();
                continueGame();
            } else if (selectedWeapon.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Rocky Creature crushes you!");
                restart();
            } else {
                healthScore -= 20;
                JOptionPane.showMessageDialog(this, "Your " + selectedWeapon + " is ineffective. Rocky Creature dealt damage!");
                updateHealthLabel();
                if (healthScore <= 0) {
                    restart();
                }
                continueGame();
            }
        } else {
            healthScore -= 20;
            JOptionPane.showMessageDialog(this, "Escaped successfully.");
            updateHealthLabel();
            continueGame();
        }
    }

    private void continueGame() {
        int option = JOptionPane.showConfirmDialog(this, "Do you want to continue?", "Continue Game",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Player can choose a new path
        } else {
            JOptionPane.showMessageDialog(this, "Game Over! Your final score: " + gameScore);
            System.exit(0);
        }
    }

    private void restart() {
        int option = JOptionPane.showConfirmDialog(this, "You have died! Restart game?", "Game Over",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            healthScore = INITIAL_HEALTH;
            gameScore = 0;
            updateHealthLabel();
            updateScoreLabel();
        } else {
            JOptionPane.showMessageDialog(this, "Game Over! Your final score: " + gameScore);
            System.exit(0);
        }
    }

    private void updateHealthLabel() {
        healthLabel.setText("Health: " + healthScore);
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + gameScore);
    }

    private static String getRandomWeapon() {
        String[] weapons = {"Sword", "Bow", "Magic Staff"};
        int randomIndex = new Random().nextInt(weapons.length);
        return weapons[randomIndex];
    }
}