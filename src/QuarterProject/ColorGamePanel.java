package QuarterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ColorGamePanel extends JPanel {

    private JLabel scoreLbl;
    private JLabel timeLbl;

    private JLabel colorText;

    private JButton redButton;
    private JButton yellowButton;
    private JButton greenButton;
    private JButton blueButton;
    private JButton purpleButton;

    private MyFrame frame;
    private int score;

    private int color;
    private int rounds;

    public ColorGamePanel(MyFrame f, int score) {
        frame = f;
        this.score = score;
        rounds = 0;

        setLayout(null);

        scoreLbl = new JLabel();
        scoreLbl.setFont(new Font("Arial Rounded MT Bold", 1, 14));
        scoreLbl.setForeground(Color.BLACK);
        scoreLbl.setText("Score: " + score);
        scoreLbl.setToolTipText("Overall Score(Hangman score included)");
        Dimension scoreLblSize = scoreLbl.getPreferredSize();
        scoreLbl.setBounds(10, 15, scoreLblSize.width, scoreLblSize.height);
        add(scoreLbl);

        timeLbl = new JLabel();
        timeLbl.setFont(new Font("Times New Roman", 0, 12));
        timeLbl.setForeground(Color.BLACK);
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm:ss");
        ActionListener timer = (new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                timeLbl.setText(dateFormat.format(now.getTime()));
            }
        });
        new Timer(1000, timer).start();
        Calendar now = Calendar.getInstance();
        timeLbl.setText(dateFormat.format(now.getTime()));
        Dimension timeLblSize = timeLbl.getPreferredSize();
        timeLbl.setBounds(460, 20, timeLblSize.width, timeLblSize.height);
        timeLbl.setToolTipText("Current Time");
        add(timeLbl);

        redButton = new JButton(new ImageIcon("src//red.png"));
        redButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                redButtonActionPerformed();
            }
        });
        redButton.setRolloverIcon(new ImageIcon("src//lightRed.png"));
        redButton.setToolTipText("Red Button");

        yellowButton = new JButton(new ImageIcon("src//yellow.png"));
        yellowButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                yellowButtonActionPerformed();
            }
        });
        yellowButton.setRolloverIcon(new ImageIcon("src//lightYellow.png"));
        yellowButton.setToolTipText("Yellow Button");

        greenButton = new JButton(new ImageIcon("src//green.png"));
        greenButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                greenButtonActionPerformed();
            }
        });
        greenButton.setRolloverIcon(new ImageIcon("src//lightGreen.png"));
        greenButton.setToolTipText("Green Button");

        blueButton = new JButton(new ImageIcon("src//blue.png"));
        blueButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                blueButtonActionPerformed();
            }
        });
        blueButton.setRolloverIcon(new ImageIcon("src//lightBlue.png"));
        blueButton.setToolTipText("Blue Button");

        purpleButton = new JButton(new ImageIcon("src//purple.png"));
        purpleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                purpleButtonActionPerformed();
            }
        });
        purpleButton.setRolloverIcon(new ImageIcon("src//lightPurple.png"));
        purpleButton.setToolTipText("Purple Button");

        randomizeButtons();

        add(redButton);
        add(yellowButton);
        add(greenButton);
        add(blueButton);
        add(purpleButton);

        colorText = new JLabel();
        colorText.setFont(new Font("Arial Rounded MT Bold", 1, 18));
        randomizeColorText();
        add(colorText);

    }

    private void randomizeButtons() {
        int xCor[] = {120, 440, 270, 90, 350};
        int yCor[] = {80, 220, 240, 220, 70};
        boolean cordUsed[] = {false, false, false, false, false};

        int colorX[] = new int[5];
        int colorY[] = new int[5];

        Random r = new Random();
        int rand;

        for (int i = 0; i < colorX.length; i++) {

            rand = r.nextInt(5);
            while (cordUsed[rand]) {
                rand = r.nextInt(5);
            }
            colorX[i] = xCor[rand];
            colorY[i] = yCor[rand];
            cordUsed[rand] = true;

        }

        redButton.setBounds(colorX[0], colorY[0], 100, 100);
        yellowButton.setBounds(colorX[1], colorY[1], 100, 100);
        greenButton.setBounds(colorX[2], colorY[2], 100, 100);
        blueButton.setBounds(colorX[3], colorY[3], 100, 100);
        purpleButton.setBounds(colorX[4], colorY[4], 100, 100);
    }

    private void randomizeColorText() {
        String[] text = {"Red", "Yellow", "Green", "Blue", "Purple"};
        Color[] color = {Color.RED, Color.yellow, Color.GREEN, Color.blue, Color.MAGENTA};

        Random r = new Random();
        int rand = r.nextInt(5);
        colorText.setText(text[rand]);
        rand = r.nextInt(5);
        colorText.setForeground(color[rand]);
        this.color = rand;
        Dimension colorTextSize = colorText.getPreferredSize();
        colorText.setBounds(280, 180, colorTextSize.width, colorTextSize.height);
    }

    private void play(int color) {
        if (this.color == color) {
            score += 100;
        }

        scoreLbl.setText("Score: " + score);
        Dimension scoreLblSize = scoreLbl.getPreferredSize();
        scoreLbl.setBounds(10, 15, scoreLblSize.width, scoreLblSize.height);
        rounds++;
        if (rounds == 5) {
            frame.colorToSudoku(score);
        }

        randomizeButtons();
        randomizeColorText();
        repaint();
    }

    private void redButtonActionPerformed() {
        play(0);
    }

    private void yellowButtonActionPerformed() {
        play(1);
    }

    private void greenButtonActionPerformed() {
        play(2);
    }

    private void blueButtonActionPerformed() {
        play(3);
    }

    private void purpleButtonActionPerformed() {
        play(4);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }
}
