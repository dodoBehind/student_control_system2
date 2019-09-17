package mine.student_control_system2.ui;

import java.awt.Image;

import javax.swing.*;

public class ImagePanel extends JPanel {

    public ImagePanel(String path,int width,int height) {
        ImageIcon image = new ImageIcon(path);
        image.setImage(image.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT));
        JLabel label = new JLabel(image);
        add(label);
        setBounds(0, 0, width, height);
    }
}