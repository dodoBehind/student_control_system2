package mine.student_control_system2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MoveFrame extends JFrame {
    private int x, y;

    public MoveFrame() throws HeadlessException {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MoveFrame.this.setLocation(
                        e.getXOnScreen() - x,
                        e.getYOnScreen() - y
                );
            }
        });
        setBounds(0, 0, 980, 510);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }
}
