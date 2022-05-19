import javax.swing.*;

import java.awt.Color;
import java.util.Random;

public class GUI {
    private JFrame frame = new JFrame("GUI!");
    private JPanel panel = new JPanel();

    private JLabel playerScoreLabel = new JLabel("Player score: 0");
    private JLabel computerScoreLabel = new JLabel("Computer score: 0");

    private JLabel imageLabel = new JLabel();

    private JButton resetButton = new JButton("Reset");
    private JButton addScoreButton = new JButton("Roll!");

    private int playerScore = 0;
    private int dice = 1;
    private int computerScore = 0;

    /**
     * Costruttore
     */

    public GUI() {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);

        this.customizePanel();

        panel.setLayout(null);
        panel.add(playerScoreLabel).setBounds(100, 100, 150, 20);
        panel.add(computerScoreLabel).setBounds(100, 150, 150, 20);
        panel.add(resetButton).setBounds(300, 150, 150, 20);
        panel.add(addScoreButton).setBounds(300, 100, 150, 20);
        panel.add(imageLabel).setBounds(300, 200, 512, 512);

        resetButton.addActionListener(evt -> this.resetScore());
        addScoreButton.addActionListener(evt -> this.addScore());
        this.addImage();
    }

    private void customizePanel() {
        panel.setBackground(new Color(24, 140, 34));
    }

    /**
     * Metodo crea immagine
     * 
     * @param path        percorso dell'immagine
     * @param description descrizione dell'immagine
     */
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * 
     * Resetta il punteggio
     * 
     */
    private void resetScore() {
        playerScore = 0;
        computerScore = 0;

        this.playerScoreLabel.setText("Player score: 0");
        this.computerScoreLabel.setText("Computer score: 0");
    }

    /**
     * 
     * Aumenta il punteggio
     * 
     */
    private void addScore() {
        Random r = new Random();
        dice = (byte) r.nextInt(6) + 1;

        playerScore += dice;
        this.playerScoreLabel.setText("Player score: " + playerScore);

        this.addImage();

        dice = r.nextInt(6) + 1;
        computerScore += dice;
        this.computerScoreLabel.setText("Computer score: " + computerScore);

    }

    /**
     * 
     * Aggiungi immagine al pannello
     * 
     */
    private void addImage() {
        ImageIcon image;
        String path = dice + ".png";
        // System.out.println("" + dice);

        image = createImageIcon(path, "dice");
        imageLabel.setIcon(image);
    }
}