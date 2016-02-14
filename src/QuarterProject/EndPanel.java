package QuarterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class EndPanel extends JPanel {

    JLabel endLabel;
    JLabel scoreLabel;
    JButton endBtn;
    MyFrame frame;

    int[] highScores;
    String[] highScoreNames;

    public EndPanel(MyFrame f, int score) {
        frame = f;
        setLayout(null);
        highScores = frame.highScoresPanel.getHighScores();
        highScoreNames = frame.highScoresPanel.getHighScoreNames();

        endLabel = new JLabel();
        endLabel.setFont(new Font("Bauhaus 93", 3, 40));
        endLabel.setForeground(Color.RED);
        endLabel.setText("END GAME");
        Dimension endLabelSize = endLabel.getPreferredSize();
        endLabel.setBounds(180, 50, endLabelSize.width, endLabelSize.height);
        add(endLabel);

        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setText("Score: " + score);
        Dimension scoreLabelSize = scoreLabel.getPreferredSize();
        scoreLabel.setBounds(220, 190, scoreLabelSize.width, scoreLabelSize.height);
        add(scoreLabel);

        endBtn = new JButton();
        endBtn.setText("end");
        Dimension endBtnSize = endBtn.getPreferredSize();
        endBtn.setBounds(10, 370, endBtnSize.width, endBtnSize.height);
        endBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                endBtnActionPerformed(evt);
            }
        });
        endBtn.setToolTipText("Go to main menu");
        add(endBtn);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    private void endBtnActionPerformed(ActionEvent evt) {
        frame.switchEndToMain();
    }

    public void checkScore(int score) {

        for (int i = 0; i < highScores.length; i++) {
            if (score > highScores[i]) {
                newHighScore(score, i);
                break;
            }
        }
    }

    private void newHighScore(int score, int i) {
        int n = JOptionPane.showConfirmDialog(frame.f,
                "Would you like to save your high score?", "Congratulations!",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (n == 0) {
            String name = inputName();
            int[] tempHighScores = highScores.clone();
            String[] tempNames = highScoreNames.clone();
            for (int j = i + 1; j < highScores.length; j++) {
                highScores[j] = tempHighScores[j - 1];
                highScoreNames[j] = tempNames[j - 1];
            }
            highScores[i] = score;
            highScoreNames[i] = name;
            saveScores();

        }
    }

    private String inputName() {
        String s = (String) JOptionPane.showInputDialog(frame.f,
                "Enter your name", "Saving High Score",
                JOptionPane.PLAIN_MESSAGE);

        if ((s != null) && (s.length() > 0)) {
            return s;
        } else {
            JOptionPane.showMessageDialog(frame.f,
                    "Invalid Input: Please type something", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            s = inputName();
        }
        return s;
    }

    private void saveScores() {
        try (FileOutputStream fos = new FileOutputStream("highScores.dat", false);
                ObjectOutput oo = new ObjectOutputStream(fos)) {
            oo.writeObject(highScoreNames);
            oo.writeObject(highScores);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScoresPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HighScoresPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.highScoresPanel.loadScores();
    }

}
