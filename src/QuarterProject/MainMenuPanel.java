package QuarterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {

    private BufferedImage executioner;
    private JButton playBtn;
    private JButton highScoresBtn;
    private JButton creditsBtn;
    public MyFrame frame;

    MainMenuPanel(MyFrame f) {
        frame = f;
        this.setBackground(new Color(0, 0, 0));
        this.setForeground(new Color(255, 255, 255));
        setLayout(null);

        playBtn = new JButton();
        playBtn.setBackground(new Color(0, 0, 0));
        playBtn.setFont(new Font("Bauhaus 93", 2, 18));
        playBtn.setForeground(new Color(255, 255, 255));
        playBtn.setText("Play");
        Dimension playBtnSize = playBtn.getPreferredSize();
        playBtn.setBounds(500, 250, playBtnSize.width, playBtnSize.height);
        playBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });
        playBtn.setToolTipText("Start Playing");
        add(playBtn);

        highScoresBtn = new JButton();
        highScoresBtn.setBackground(new Color(0, 0, 0));
        highScoresBtn.setFont(new Font("Bauhaus 93", 2, 18));
        highScoresBtn.setForeground(new Color(255, 255, 255));
        highScoresBtn.setText("High Scores");
        Dimension highScoresBtnSize = highScoresBtn.getPreferredSize();
        highScoresBtn.setBounds(470, 290, highScoresBtnSize.width, highScoresBtnSize.height);
        highScoresBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                highScoresBtnActionPerformed(evt);
            }
        });
        highScoresBtn.setToolTipText("Check out the High Scores");
        add(highScoresBtn);

        creditsBtn = new JButton();
        creditsBtn.setBackground(new Color(0, 0, 0));
        creditsBtn.setFont(new Font("Bauhaus 93", 2, 18));
        creditsBtn.setForeground(new Color(255, 255, 255));
        creditsBtn.setText("Credits");
        Dimension creditsBtnSize = creditsBtn.getPreferredSize();
        creditsBtn.setBounds(490, 330, creditsBtnSize.width, creditsBtnSize.height);
        creditsBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                creditsBtnActionPerformed(evt);
            }
        });
        creditsBtn.setToolTipText("Appreciate the creators");
        add(creditsBtn);

    }

    private void playBtnActionPerformed(ActionEvent evt) {
        frame.switchToHangman();
    }

    private void highScoresBtnActionPerformed(ActionEvent evt) {
        frame.switchToHighScores();
    }

    private void creditsBtnActionPerformed(ActionEvent evt) {
        frame.switchToCredits();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            executioner = ImageIO.read(new File("src\\mainMenuImage.png"));
        } catch (IOException e) {
        }
        g.drawImage(executioner, 100, 130, 150, 200, this);

    }

}
