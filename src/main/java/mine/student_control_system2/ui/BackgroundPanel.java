package mine.student_control_system2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BackgroundPanel extends JPanel {
    public BackgroundPanel(int x, int y, int width, int high, String path) {
        setBounds(x, y, width, high);
        JLabel label = new JLabel(new ImageIcon(path));
        add(label);
        if (path.length() != 0) setBackground(Color.RED);
        else {
            setBackground(Color.YELLOW);
            addCloseButton();
        }
    }

    void addCloseButton() {
        JButton closeButton = new JButton();
        closeButton.setBounds(0, 0, 45, 45);
        closeButton.setIcon(new ImageIcon("F:\\d.png"));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(closeButton);
    }
}