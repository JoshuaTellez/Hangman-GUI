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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class HangManPanel extends JPanel {

    private JLabel hangManLbl;
    private JLabel scoreLbl;
    private JLabel timeLbl;
    private JButton skipBtn;

    private JButton aBtn, bBtn, cBtn, dBtn, eBtn, fBtn, gBtn, hBtn, iBtn, jBtn, kBtn, lBtn,
            mBtn, nBtn, oBtn, pBtn, qBtn, rBtn, sBtn, tBtn, uBtn, vBtn, wBtn, xBtn, yBtn, zBtn;

    private BufferedImage scafold;
    private BufferedImage head;

    private int score;
    private String[] words = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    private String chosenWord;
    private int wordSize;
    private int attempts;
    private int lettersLeft;

    private MyFrame frame;

    public HangManPanel(MyFrame f) {
        frame = f;
        score = 100;
        attempts = 0;
        chooseWord();
        lettersLeft = wordSize;

        setLayout(null);

        hangManLbl = new JLabel();
        hangManLbl.setFont(new Font("Bauhaus 93", 2, 20));
        hangManLbl.setForeground(Color.RED);
        hangManLbl.setText("HANGMAN");
        Dimension hangManLblSize = hangManLbl.getPreferredSize();
        hangManLbl.setBounds(10, 10, hangManLblSize.width, hangManLblSize.height);
        add(hangManLbl);

        scoreLbl = new JLabel();
        scoreLbl.setFont(new Font("Arial Rounded MT Bold", 1, 14));
        scoreLbl.setForeground(Color.BLACK);
        scoreLbl.setText("Score: " + score);
        Dimension scoreLblSize = scoreLbl.getPreferredSize();
        scoreLbl.setBounds(10, 35, scoreLblSize.width, scoreLblSize.height);
        scoreLbl.setToolTipText("Current Score");
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

        skipBtn = new JButton();
        skipBtn.setText("Skip");
        Dimension skipBtnSize = skipBtn.getPreferredSize();
        skipBtn.setBounds(530, 60, skipBtnSize.width, skipBtnSize.height);
        skipBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                skipBtnActionPerformed(evt);
            }
        });
        skipBtn.setToolTipText("Go to next game(lose all points)");
        add(skipBtn);

        aBtn = new JButton();
        aBtn.setText("A");
        Dimension aBtnSize = aBtn.getPreferredSize();
        aBtn.setBounds(20, 310, aBtnSize.width, aBtnSize.height);
        aBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                aBtnActionPerformed(evt);
            }
        });
        add(aBtn);

        bBtn = new JButton();
        bBtn.setText("B");
        bBtn.setBounds(63, 310, aBtnSize.width, aBtnSize.height);
        bBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                bBtnActionPerformed(evt);
            }
        });
        add(bBtn);

        cBtn = new JButton();
        cBtn.setText("C");
        cBtn.setBounds(106, 310, aBtnSize.width, aBtnSize.height);
        cBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                cBtnActionPerformed(evt);
            }
        });
        add(cBtn);

        dBtn = new JButton();
        dBtn.setText("D");
        dBtn.setBounds(149, 310, aBtnSize.width, aBtnSize.height);
        dBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                dBtnActionPerformed(evt);
            }
        });
        add(dBtn);

        eBtn = new JButton();
        eBtn.setText("E");
        eBtn.setBounds(192, 310, aBtnSize.width, aBtnSize.height);
        eBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                eBtnActionPerformed(evt);
            }
        });
        add(eBtn);

        fBtn = new JButton();
        fBtn.setText("F");
        fBtn.setBounds(235, 310, aBtnSize.width, aBtnSize.height);
        fBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fBtnActionPerformed(evt);
            }
        });
        add(fBtn);

        gBtn = new JButton();
        gBtn.setText("G");
        gBtn.setBounds(278, 310, aBtnSize.width, aBtnSize.height);
        gBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                gBtnActionPerformed(evt);
            }
        });
        add(gBtn);

        hBtn = new JButton();
        hBtn.setText("H");
        hBtn.setBounds(321, 310, aBtnSize.width, aBtnSize.height);
        hBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                hBtnActionPerformed(evt);
            }
        });
        add(hBtn);

        iBtn = new JButton();
        iBtn.setText("I");
        iBtn.setBounds(364, 310, aBtnSize.width, aBtnSize.height);
        iBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                iBtnActionPerformed(evt);
            }
        });
        add(iBtn);

        jBtn = new JButton();
        jBtn.setText("J");
        jBtn.setBounds(407, 310, aBtnSize.width, aBtnSize.height);
        jBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                jBtnActionPerformed(evt);
            }
        });
        add(jBtn);

        kBtn = new JButton();
        kBtn.setText("K");
        kBtn.setBounds(450, 310, aBtnSize.width, aBtnSize.height);
        kBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                kBtnActionPerformed(evt);
            }
        });
        add(kBtn);

        lBtn = new JButton();
        lBtn.setText("L");
        lBtn.setBounds(493, 310, aBtnSize.width, aBtnSize.height);
        lBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                lBtnActionPerformed(evt);
            }
        });
        add(lBtn);

        mBtn = new JButton();
        mBtn.setText("M");
        Dimension mBtnSize = mBtn.getPreferredSize();
        mBtn.setBounds(536, 310, mBtnSize.width, mBtnSize.height);
        mBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                mBtnActionPerformed(evt);
            }
        });
        add(mBtn);

        nBtn = new JButton();
        nBtn.setText("N");
        nBtn.setBounds(20, 340, aBtnSize.width, aBtnSize.height);
        nBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                nBtnActionPerformed(evt);
            }
        });
        add(nBtn);

        oBtn = new JButton();
        oBtn.setText("O");
        oBtn.setBounds(63, 340, mBtnSize.width, mBtnSize.height);
        oBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                oBtnActionPerformed(evt);
            }
        });
        add(oBtn);

        pBtn = new JButton();
        pBtn.setText("P");
        pBtn.setBounds(106, 340, aBtnSize.width, aBtnSize.height);
        pBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pBtnActionPerformed(evt);
            }
        });
        add(pBtn);

        qBtn = new JButton();
        qBtn.setText("Q");
        qBtn.setBounds(149, 340, mBtnSize.width, mBtnSize.height);
        qBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                qBtnActionPerformed(evt);
            }
        });
        add(qBtn);

        rBtn = new JButton();
        rBtn.setText("R");
        rBtn.setBounds(192, 340, aBtnSize.width, aBtnSize.height);
        rBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                rBtnActionPerformed(evt);
            }
        });
        add(rBtn);

        sBtn = new JButton();
        sBtn.setText("S");
        sBtn.setBounds(235, 340, aBtnSize.width, aBtnSize.height);
        sBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                sBtnActionPerformed(evt);
            }
        });
        add(sBtn);

        tBtn = new JButton();
        tBtn.setText("T");
        tBtn.setBounds(278, 340, aBtnSize.width, aBtnSize.height);
        tBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                tBtnActionPerformed(evt);
            }
        });
        add(tBtn);

        uBtn = new JButton();
        uBtn.setText("U");
        uBtn.setBounds(321, 340, aBtnSize.width, aBtnSize.height);
        uBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                uBtnActionPerformed(evt);
            }
        });
        add(uBtn);

        vBtn = new JButton();
        vBtn.setText("V");
        vBtn.setBounds(364, 340, aBtnSize.width, aBtnSize.height);
        vBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                vBtnActionPerformed(evt);
            }
        });
        add(vBtn);

        wBtn = new JButton();
        wBtn.setText("W");
        Dimension wBtnSize = wBtn.getPreferredSize();
        wBtn.setBounds(407, 340, wBtnSize.width, wBtnSize.height);
        wBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                wBtnActionPerformed(evt);
            }
        });
        add(wBtn);

        xBtn = new JButton();
        xBtn.setText("X");
        xBtn.setBounds(450, 340, aBtnSize.width, aBtnSize.height);
        xBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                xBtnActionPerformed(evt);
            }
        });
        add(xBtn);

        yBtn = new JButton();
        yBtn.setText("Y");
        yBtn.setBounds(493, 340, aBtnSize.width, aBtnSize.height);
        yBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                yBtnActionPerformed(evt);
            }
        });
        add(yBtn);

        zBtn = new JButton();
        zBtn.setText("Z");
        zBtn.setBounds(536, 340, aBtnSize.width, aBtnSize.height);
        zBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                zBtnActionPerformed(evt);
            }
        });
        add(zBtn);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            scafold = ImageIO.read(new File("src\\scafold.jpg"));
            head = ImageIO.read(new File("src\\head.jpg"));

        } catch (IOException e) {
        }
        g.drawImage(scafold, 200, 50, 200, 200, this);
        if (attempts > 0) {
            g.drawImage(head, 335, 100, 30, 30, this);
        }
        if (attempts > 1) {
            g.fillRect(348, 130, 2, 30);
        }
        if (attempts > 2) {
            g.drawLine(350, 140, 360, 130);
        }
        if (attempts > 3) {
            g.drawLine(348, 140, 338, 130);
        }
        if (attempts > 4) {
            g.drawLine(350, 160, 360, 180);
        }
        if (attempts > 5) {
            g.drawLine(348, 160, 338, 180);
        }

        for (int i = 0, space = 150; i < wordSize; i++, space += 40) {
            g.fillRect(space, 290, 24, 2);
        }
    }

    private void skipBtnActionPerformed(ActionEvent evt) {
        score = 0;
        frame.hangToColorGame(score);
    }

    private void chooseWord() {
        double chance = Math.random();
        if (chance < .2) {
            chosenWord = words[0];
        } else if (chance < .4) {
            chosenWord = words[1];
        } else if (chance < .6) {
            chosenWord = words[2];
        } else if (chance < .8) {
            chosenWord = words[3];
        } else {
            chosenWord = words[4];
        }

        wordSize = chosenWord.length();
    }

    private void play(String ch) {
        if (!chosenWord.contains(ch)) {
            attempts++;
            score -= 10;
            scoreLbl.setText("Score: " + score);
            repaint();
            if (attempts == 6) {
                frame.hangToColorGame(score);
            }
        } else {
            char letter = ch.charAt(0);
            for (int i = 0; i < wordSize; i++) {
                if (chosenWord.charAt(i) == letter) {
                    lettersLeft--;
                    String str = String.valueOf(chosenWord.charAt(i));
                    addLabel(str, i);
                }
            }
            if (lettersLeft == 0) {
                frame.hangToColorGame(score);
            }
        }

    }

    private void addLabel(String str, int i) {
        JLabel newLabel = new JLabel();
        newLabel.setFont(new Font("Arial Rounded MT Bold", 1, 16));
        newLabel.setForeground(Color.BLACK);
        newLabel.setText(str);
        Dimension newLabelSize = newLabel.getPreferredSize();
        int xCor = 155 + 40 * i;
        newLabel.setBounds(xCor, 270, newLabelSize.width, newLabelSize.height);
        add(newLabel);
        repaint();
    }

    private void aBtnActionPerformed(ActionEvent evt) {
        remove(aBtn);
        play("a");

    }

    private void bBtnActionPerformed(ActionEvent evt) {
        remove(bBtn);
        play("b");
    }

    private void cBtnActionPerformed(ActionEvent evt) {
        remove(cBtn);
        play("c");
    }

    private void dBtnActionPerformed(ActionEvent evt) {
        remove(dBtn);
        play("d");
    }

    private void eBtnActionPerformed(ActionEvent evt) {
        remove(eBtn);
        play("e");
    }

    private void fBtnActionPerformed(ActionEvent evt) {
        remove(fBtn);
        play("f");
    }

    private void gBtnActionPerformed(ActionEvent evt) {
        remove(gBtn);
        play("g");
    }

    private void hBtnActionPerformed(ActionEvent evt) {
        remove(hBtn);
        play("h");
    }

    private void iBtnActionPerformed(ActionEvent evt) {
        remove(iBtn);
        play("i");
    }

    private void jBtnActionPerformed(ActionEvent evt) {
        remove(jBtn);
        play("j");
    }

    private void kBtnActionPerformed(ActionEvent evt) {
        remove(kBtn);
        play("k");
    }

    private void lBtnActionPerformed(ActionEvent evt) {
        remove(lBtn);
        play("l");
    }

    private void mBtnActionPerformed(ActionEvent evt) {
        remove(mBtn);
        play("m");
    }

    private void nBtnActionPerformed(ActionEvent evt) {
        remove(nBtn);
        play("n");
    }

    private void oBtnActionPerformed(ActionEvent evt) {
        remove(oBtn);
        play("o");
    }

    private void pBtnActionPerformed(ActionEvent evt) {
        remove(pBtn);
        play("p");
    }

    private void qBtnActionPerformed(ActionEvent evt) {
        remove(qBtn);
        play("q");
    }

    private void rBtnActionPerformed(ActionEvent evt) {
        remove(rBtn);
        play("r");
    }

    private void sBtnActionPerformed(ActionEvent evt) {
        remove(sBtn);
        play("s");
    }

    private void tBtnActionPerformed(ActionEvent evt) {
        remove(tBtn);
        play("t");
    }

    private void uBtnActionPerformed(ActionEvent evt) {
        remove(uBtn);
        play("u");
    }

    private void vBtnActionPerformed(ActionEvent evt) {
        remove(vBtn);
        play("v");
    }

    private void wBtnActionPerformed(ActionEvent evt) {
        remove(wBtn);
        play("w");
    }

    private void xBtnActionPerformed(ActionEvent evt) {
        remove(xBtn);
        play("x");
    }

    private void yBtnActionPerformed(ActionEvent evt) {
        remove(yBtn);
        play("y");
    }

    private void zBtnActionPerformed(ActionEvent evt) {
        remove(zBtn);
        play("z");
    }

}
