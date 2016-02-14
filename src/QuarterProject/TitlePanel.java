package QuarterProject;

import java.awt.*;
import javax.swing.*;

public class TitlePanel extends JPanel {

    private JLabel authorLabel;
    private JLabel titleLabel;

    public TitlePanel() {
        this.setBackground(new java.awt.Color(0, 0, 0));
        this.setForeground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial Black", 3, 36));
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setText("CS 245 Quarter Project");
        Dimension titleLabelSize = titleLabel.getPreferredSize();
        titleLabel.setBounds(40, 10, titleLabelSize.width, titleLabelSize.height);
        add(titleLabel);
        
        authorLabel = new JLabel();
        authorLabel.setFont(new Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        authorLabel.setForeground(new Color(255, 255, 255));
        authorLabel.setText("By: Joshua Tellez");
        Dimension authorLabelSize = authorLabel.getPreferredSize();
        authorLabel.setBounds(250, 360, authorLabelSize.width, authorLabelSize.height);
        add(authorLabel);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    
}
