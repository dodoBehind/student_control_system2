package mine.student_control_system2.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeButton extends JButton {
    private MainFrame mainFrame;

    public ChangeButton(String text, MainFrame mainFrame) {
        super(text);
        this.mainFrame = mainFrame;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("个人信息")){
                    mainFrame.getCardLayout().show(mainFrame.getLayeredPane(),"infoPanel");
                }else if (e.getActionCommand().equals("选课信息")){
                    mainFrame.getCardLayout().show(mainFrame.getLayeredPane(),"coursePanel");
                }
            }
        });
    }
}
