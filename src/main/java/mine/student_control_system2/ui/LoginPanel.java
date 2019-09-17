package mine.student_control_system2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JLayeredPane {
    private JTextField userField;
    private JPasswordField passwordField;

    private JPanel panel;
    private MainFrame mainFrame;
    public LoginPanel(MainFrame mainFrame) {
        this.mainFrame=mainFrame;

        setBounds(0, 0, 1000, 500);
        setLayout(null);

        add(new BackgroundPanel(0, -5, 935, 398, "F:\\b.png"));
        add(new BackgroundPanel(935, -15, 45, 60, ""));
        add(new BackgroundPanel(935, 35, 45, 398 - 40, "F:\\c.png"));

        panelIni();
        add(panel);
    }

    void panelIni() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.setBounds(0, 390, 980, 500 - 390);
        panel.setBackground(Color.orange);

        panel.add(getP1(true));
        panel.add(getP2(true));
        panel.add(getP3(true));
    }

    JPanel getP1(boolean v) {
        JPanel p1 = new JPanel();
        p1.add(new JLabel("          "));
        userField = new JTextField(20);
        p1.add(userField);
        p1.setVisible(v);
        return p1;
    }

    JPanel getP2(boolean v) {
        JPanel p2 = new JPanel();
        p2.add(new JLabel( "          "));
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        p2.add(passwordField);
        p2.setVisible(v);
        return p2;
    }

    JPanel getP3(boolean v) {
        JPanel p3 = new JPanel();
        JButton b = new JButton();
        b.setPreferredSize(new Dimension(80,40));
        b.setIcon(new ImageIcon("F:\\w3.png"));

        b.addActionListener(new MyLoginButtonListener());
        p3.add(b);
        p3.setVisible(v);
        return p3;
    }

    private class MyLoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            String user = userField.getText();
            String password = String.valueOf(passwordField.getPassword());
            System.out.println(user);
            System.out.println(password);
            mainFrame.login(user,password);

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.orange);
        g.fillRect(0,390,450,500 - 300);
        g.fillRect(529,390,980-510,500 - 300);
        g.fillRect(450,390,80,78);
        g.fillRect(450,501,80,78);
        Font font=new Font("黑体",Font.BOLD,17);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("用户名",360-6,410+2);
        g.drawString("密  码",360-6,410+2+35);
    }

    public static void main(String[] args) {
//        MoveFrame f=new MoveFrame();
//        f.add(new LoginPanel());
//        f.setVisible(true);
    }
}
