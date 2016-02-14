package QuarterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CreditsPanel extends JPanel {

    private JLabel creditsLabel;
    private JLabel nameLabel;
    private JButton backBtn;

    MyFrame frame;

    public CreditsPanel(MyFrame f) {
        frame = f;

        setLayout(null);
        creditsLabel = new JLabel();
        creditsLabel.setFont(new Font("Bauhaus 93", 3, 40));
        creditsLabel.setForeground(Color.RED);
        creditsLabel.setText("CREDITS");
        Dimension highScoresLabelSize = creditsLabel.getPreferredSize();
        creditsLabel.setBounds(220, 50, highScoresLabelSize.width, highScoresLabelSize.height);
        add(creditsLabel);

        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Arial Rounded MT Bold", 1, 20));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setText("Joshua Tellez, 010304476");
        Dimension nameLabelSize = nameLabel.getPreferredSize();
        nameLabel.setBounds(170, 190, nameLabelSize.width, nameLabelSize.height);
        add(nameLabel);

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
        frame.switchCreditsToMain();
    }

}
