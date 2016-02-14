package QuarterProject;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MyFrame {

    private TitlePanel titlePanel;
    private MainMenuPanel mainMenuPanel;
    public HighScoresPanel highScoresPanel;
    private CreditsPanel creditsPanel;
    private HangManPanel hangManPanel;
    private ColorGamePanel colorGamePanel;
    private SudokuPanel sudokuPanel;
    private EndPanel endPanel;

    Timer timer;

    public JFrame f;

    public MyFrame() {
        titlePanel = new TitlePanel();
        mainMenuPanel = new MainMenuPanel(this);
        highScoresPanel = new HighScoresPanel(this);
        creditsPanel = new CreditsPanel(this);
        f = new JFrame();
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (e.getKeyCode() == 27) {
                        System.exit(0);
                    }
                    if (e.getKeyCode() == 112) {
                        JOptionPane.showMessageDialog(f, "Joshua Tellez, 010304476",
                                "Summer 2015 Quarter Project", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                return false;
            }
        });

    }

    public void play() {

        System.out.println("Created GUI on EDT? "
                + SwingUtilities.isEventDispatchThread());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.add(titlePanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        exitTitlePanel();

    }

    private void exitTitlePanel() {
        timer = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                f.remove(titlePanel);
                f.add(mainMenuPanel);
                f.pack();
                timer.stop();
            }
        });
        timer.start();

    }

    public void switchToHangman() {
        f.remove(mainMenuPanel);
        f.pack();
        hangManPanel = new HangManPanel(this);
        f.add(hangManPanel);
        f.pack();
    }

    public void switchToHighScores() {
        f.remove(mainMenuPanel);
        f.pack();
        f.add(highScoresPanel);
        f.pack();
    }

    public void switchHighToMain() {

        f.remove(highScoresPanel);
        f.pack();
        f.add(mainMenuPanel);
        f.pack();
    }

    public void switchToCredits() {
        f.remove(mainMenuPanel);
        f.pack();
        f.add(creditsPanel);
        f.pack();
    }

    public void switchCreditsToMain() {
        f.remove(creditsPanel);
        f.pack();
        f.add(mainMenuPanel);
        f.pack();
    }

    public void hangToColorGame(int score) {
        f.remove(hangManPanel);
        f.pack();
        colorGamePanel = new ColorGamePanel(this, score);
        f.add(colorGamePanel);
        f.pack();
    }

    public void colorToSudoku(int score) {
        f.remove(colorGamePanel);
        f.pack();
        sudokuPanel = new SudokuPanel(this, score);
        f.add(sudokuPanel);
        f.pack();
    }

    public void sudokuToEnd(int score) {
        f.remove(sudokuPanel);
        f.pack();
        endPanel = new EndPanel(this, score);
        f.add(endPanel);
        f.pack();
        endPanel.checkScore(score);
    }

    public void switchEndToMain() {
        f.remove(endPanel);
        f.pack();
        f.add(mainMenuPanel);
        f.pack();
    }

}
