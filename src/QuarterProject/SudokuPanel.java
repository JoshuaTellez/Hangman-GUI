package QuarterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SudokuPanel extends JPanel {

    private int overallScore;
    private int sudokuScore;
    private MyFrame frame;

    private JLabel scoreLabel;
    private JLabel timeLbl;
    private JLabel sudokuLbl;

    private JButton submitBtn;
    private JButton quitBtn;

    private JTextField[] numbers;

    private String[] answerKey = {"8", "3", "5", "4", "1", "6", "9", "2", "7",
        "2", "9", "6", "8", "5", "7", "4", "3", "1", "4", "1", "7", "2", "9",
        "3", "6", "5", "8", "5", "6", "9", "1", "3", "4", "7", "8", "2", "1",
        "2", "3", "6", "7", "8", "5", "4", "9", "7", "4", "8", "5", "2", "9",
        "1", "6", "3", "6", "5", "2", "7", "8", "1", "3", "9", "4", "9", "8",
        "1", "3", "4", "5", "2", "7", "6", "3", "7", "4", "9", "6", "2",
        "8", "1", "5"};

    private boolean[] pointsReduced = new boolean[81];
    private boolean allCorrect;

    public SudokuPanel(MyFrame f, int score) {
        frame = f;
        overallScore = score;
        sudokuScore = 540;
        allCorrect = false;

        setLayout(null);

        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("Arial Rounded MT Bold", 1, 14));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setText("Sudoku Score: " + sudokuScore);
        Dimension scoreLabelSize = scoreLabel.getPreferredSize();
        scoreLabel.setBounds(10, 35, scoreLabelSize.width, scoreLabelSize.height);
        scoreLabel.setToolTipText("Current Score(Other game scores not included)");
        add(scoreLabel);

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

        sudokuLbl = new JLabel();
        sudokuLbl.setFont(new Font("Bauhaus 93", 2, 20));
        sudokuLbl.setForeground(Color.BLUE);
        sudokuLbl.setText("SUDOKU");
        Dimension sudokuLblSize = sudokuLbl.getPreferredSize();
        sudokuLbl.setBounds(10, 10, sudokuLblSize.width, sudokuLblSize.height);
        add(sudokuLbl);

        submitBtn = new JButton();
        submitBtn.setText("Submit");
        Dimension submitBtnSize = new Dimension(submitBtn.getPreferredSize());
        submitBtn.setBounds(40, 350, submitBtnSize.width, submitBtnSize.height);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitBtnActionPerformed();
            }
        });
        submitBtn.setToolTipText("Submit your answers(-10 pts for each incorrect box)");
        add(submitBtn);

        quitBtn = new JButton();
        quitBtn.setText("Quit");
        Dimension quitBtnSize = new Dimension(quitBtn.getPreferredSize());
        quitBtn.setBounds(500, 350, quitBtnSize.width, quitBtnSize.height);
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.sudokuToEnd(overallScore);
            }
        });
        quitBtn.setToolTipText("Quit game(lose all sudoku points)");
        add(quitBtn);

        addTextFields();

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(246, 50, 3, 294);
        g.fillRect(345, 50, 3, 294);
        g.fillRect(150, 146, 294, 3);
        g.fillRect(150, 245, 294, 3);
    }

    private void addTextFields() {
        numbers = new JTextField[81];
        int[] givenFields = {0, 3, 5, 8, 15, 19, 24, 25, 27, 29, 31, 33, 34, 40,
            46, 47, 49, 51, 53, 55, 56, 61, 65, 72, 75, 77, 80};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JTextField();
            numbers[i].setFont(new Font("Arial Rounded MT Bold", 3, 14));
            numbers[i].setForeground(Color.BLACK);
            numbers[i].setToolTipText("Input 1-9 only");
            numbers[i].addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    checkInput(e.getKeyChar());
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

            });
        }

        for (int i : givenFields) {
            numbers[i].setText(answerKey[i]);
            numbers[i].setToolTipText("");
            numbers[i].setEditable(false);
        }

        int i = 0;
        for (int y = 50; y < 340; y += 33) {
            for (int x = 150; x < 440; x += 33) {
                numbers[i].setBounds(x, y, 30, 30);
                add(numbers[i]);
                i++;
            }
        }
    }

    private void submitBtnActionPerformed() {
        if (!checkInput('\n')) {
            allCorrect = true;
            for (int i = 0; i < numbers.length; i++) {
                if (!answerKey[i].equals(numbers[i].getText())) {
                    allCorrect = false;
                    if (!pointsReduced[i]) {
                        sudokuScore -= 10;
                        pointsReduced[i] = true;
                    }
                }
            }
            checkGame();
        } else {
            JOptionPane.showMessageDialog(frame.f, "Please correct all invalid inputs and fill each box",
                    "Invalid Submission", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void checkGame() {
        if (allCorrect) {
            overallScore += sudokuScore;
            frame.sudokuToEnd(overallScore);
        } else {
            JOptionPane.showMessageDialog(frame.f, "Your submission is incorrect. Please try again",
                    "Sorry", JOptionPane.PLAIN_MESSAGE);
            scoreLabel.setText("Sudoku Score: " + sudokuScore);
            Dimension scoreLabelSize = scoreLabel.getPreferredSize();
            scoreLabel.setBounds(10, 35, scoreLabelSize.width, scoreLabelSize.height);
            repaint();
        }

    }

    private boolean checkInput(char ch) {
        boolean inputError = false;
        if (ch != '\b') {
            boolean dialogShown = false;
            for (JTextField text : numbers) {
                text.setForeground(Color.black);
                String str = text.getText();

                if (!str.isEmpty()) {
                    try {
                        int i = Integer.parseInt(str);
                        if (i > 9 || i < 1) {
                            text.setForeground(Color.red);
                            inputError = true;
                            if (!dialogShown) {
                                JOptionPane.showMessageDialog(frame.f, "Please type a number from 1-9",
                                        "Invalid Input", JOptionPane.PLAIN_MESSAGE);
                                dialogShown = true;
                            }
                        }
                    } catch (NumberFormatException e) {
                        text.setForeground(Color.red);
                        inputError = true;
                        if (!dialogShown) {
                            JOptionPane.showMessageDialog(frame.f, "Please type a number from 1-9",
                                    "Invalid Input", JOptionPane.PLAIN_MESSAGE);
                            dialogShown = true;
                        }

                    }
                } else {
                    inputError = true;
                }
            }
        }
        return inputError;
    }

}
