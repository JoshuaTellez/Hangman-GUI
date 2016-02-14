package QuarterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HighScoresPanel extends JPanel {

    private JLabel highScoresLabel;
    private JLabel highScore1;
    private JLabel highScore2;
    private JLabel highScore3;
    private JLabel highScore4;
    private JLabel highScore5;

    private String[] highScoreNames;
    private int[] highScores;

    private JButton backBtn;

    private MyFrame frame;

    HighScoresPanel(MyFrame f) {
        frame = f;
        setLayout(null);

        highScoreNames = new String[5];
        highScores = new int[5];

        highScore1 = new JLabel();
        highScore1.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        highScore1.setForeground(Color.BLACK);

        highScore2 = new JLabel();
        highScore2.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        highScore2.setForeground(Color.BLACK);

        highScore3 = new JLabel();
        highScore3.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        highScore3.setForeground(Color.BLACK);

        highScore4 = new JLabel();
        highScore4.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        highScore4.setForeground(Color.BLACK);

        highScore5 = new JLabel();
        highScore5.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        highScore5.setForeground(Color.BLACK);

        loadScores();
        setLabelsText();

        add(highScore1);
        add(highScore2);
        add(highScore3);
        add(highScore4);
        add(highScore5);

        highScoresLabel = new JLabel();
        highScoresLabel.setFont(new Font("Bauhaus 93", 3, 40));
        highScoresLabel.setForeground(Color.BLUE);
        highScoresLabel.setText("HIGHSCORES");
        Dimension highScoresLabelSize = highScoresLabel.getPreferredSize();
        highScoresLabel.setBounds(180, 50, highScoresLabelSize.width, highScoresLabelSize.height);
        add(highScoresLabel);

        backBtn = new JButton();
        backBtn.setText("back");
        Dimension backBtnSize = backBtn.getPreferredSize();
        backBtn.setBounds(10, 370, backBtnSize.width, backBtnSize.height);
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        backBtn.setToolTipText("Go to main menu");
        add(backBtn);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    private void backBtnActionPerformed(ActionEvent evt) {
        frame.switchHighToMain();
    }

    public void loadScores() {
        try (FileInputStream fis = new FileInputStream("highScores.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            highScoreNames = (String[]) ois.readObject();
            highScores = (int[]) ois.readObject();
            setLabelsText();
        } catch (FileNotFoundException ex) {
            writeDefaultScores();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(HighScoresPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int[] getHighScores() {
        return highScores;
    }

    public String[] getHighScoreNames() {
        return highScoreNames;
    }

    private void writeDefaultScores() {
        String[] defaultNames = {"ABC", "ABC", "ABC", "ABC", "ABC"};
        int[] defaultScores = {0, 0, 0, 0, 0};
        try (FileOutputStream fos = new FileOutputStream("highScores.dat");
                ObjectOutput oo = new ObjectOutputStream(fos)) {
            oo.writeObject(defaultNames);
            oo.writeObject(defaultScores);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScoresPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HighScoresPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadScores();
    }

    private void setLabelsText() {

        highScore1.setText(highScoreNames[0] + "........" + highScores[0]);
        Dimension highScore1Size = highScore1.getPreferredSize();
        highScore1.setBounds(220, 150, highScore1Size.width, highScore1Size.height);

        highScore2.setText(highScoreNames[1] + "........" + highScores[1]);
        Dimension highScore2Size = highScore2.getPreferredSize();
        highScore2.setBounds(220, 170, highScore2Size.width, highScore2Size.height);

        highScore3.setText(highScoreNames[2] + "........" + highScores[2]);
        Dimension highScore3Size = highScore3.getPreferredSize();
        highScore3.setBounds(220, 190, highScore3Size.width, highScore3Size.height);

        highScore4.setText(highScoreNames[3] + "........" + highScores[3]);
        Dimension highScore4Size = highScore4.getPreferredSize();
        highScore4.setBounds(220, 210, highScore4Size.width, highScore4Size.height);

        highScore5.setText(highScoreNames[4] + "........" + highScores[4]);
        Dimension highScore5Size = highScore5.getPreferredSize();
        highScore5.setBounds(220, 230, highScore5Size.width, highScore5Size.height);
    }
}
