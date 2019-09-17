package mine.student_control_system2.ui;

import lombok.Getter;
import lombok.Setter;
import mine.student_control_system2.domain.Departments;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;


public class InfoPanel extends JPanel {
    private MyTable table1, table2;
    @Getter
    private JPanel middlePanel, barPanel;
    private TableModel moudel, moude2;

    @Setter
    private Departments d;

    void flushMiddle() {
        table1.setModel(moudel);
        table2.setModel(moude2);

        middlePanel = new JPanel();
        middlePanel.setBackground(new Color(0x262626));
        middlePanel.setLayout(new GridBagLayout());

        JPanel pp1 = new JPanel();
        pp1.setLayout(new GridLayout());
        pp1.add(table1);
        pp1.setBackground(Color.WHITE);

//        JPanel pp2 = new JPanel();
//        pp2.setBackground(new Color(0x262626));
        JPanel pp3 = new JPanel();

        pp3.setLayout(new GridLayout());
        pp3.add(table2);
        pp3.setBackground(Color.WHITE);


        middlePanel.add(pp1, new GBC(0, 0).setIpad(200, 200).setWeight(100, 100).setFill(GridBagConstraints.BOTH));
//        middlePanel.add(pp2, new GBC(1, 0).setIpad(2, 200).setWeight(30, 100).setFill(GridBagConstraints.BOTH));
        middlePanel.add(pp3, new GBC(1, 0).setIpad(200, 200).setWeight(100, 100).setFill(GridBagConstraints.BOTH));

        add(middlePanel, new GBC(1, 1).setFill(GBC.BOTH));
    }

    public InfoPanel(TableModel m1, TableModel m2) {
        moudel = m1;
        moude2 = m2;

        setLayout(new GridBagLayout());

        ImagePanel up = new ImagePanel("F:\\1.png",1000,50);
        up.setBackground(new Color(0x262626));
        add(up, new GBC(0, 0, 3, 1)
        );

        ImagePanel left = new ImagePanel("F:\\2.png",50,398);
        left.setBackground(new Color(0x262626));
        add(left, new GBC(0, 1)
        );

        ImagePanel right = new ImagePanel("F:\\3.png",50,398);
        right.setBackground(new Color(0x262626));
        add(right, new GBC(2, 1, 1, 1)
//                .setFill(GBC.BOTH)
//                .setIpad(30, 90)
//                .setWeight(0, 100)
        );

        table1 = new MyTable(m1);
        table2 = new MyTable(m2);
        flushMiddle();

        barPanel = new JPanel();
        barPanel.setBackground(new Color(0x262626));
        barPanel.setLayout(new GridLayout());

        add(barPanel, new GBC(0, 2, 2, 1).
                setFill(GBC.BOTH).setIpad(200, 30).setWeight(100, 0));

        setSize(1000, 500);
        setVisible(true);
    }


}
