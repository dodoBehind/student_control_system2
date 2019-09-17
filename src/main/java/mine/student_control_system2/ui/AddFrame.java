package mine.student_control_system2.ui;

import mine.student_control_system2.domain.Courses;
import mine.student_control_system2.domain.Departments;
import mine.student_control_system2.service.CoursesService;
import mine.student_control_system2.service.DepartmentsService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class AddFrame extends JFrame implements ActionListener {
    private char type;

    private JButton button;
    private JButton buttonClear;

    private ApplicationContext context;

    private ArrayList<JLabel> labels;
    private ArrayList<JTextField> fields;

    private int notNull;
    private  MainFrame mf;

    public AddFrame(char type, ApplicationContext context,MainFrame mf) {
        this.type = type;
        this.context = context;
        this.mf=mf;

        labels = new ArrayList<>();
        fields = new ArrayList<>();

        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        setLayout(new FlowLayout());

        if (type == 'D') {
            setTitle("新建院系");
            labels.add(new JLabel("输入院系名称"));
            add(newPanel(0, "*"));
            notNull = 1;
            button = new JButton("新建院系");
        } else if (type == 'S') {
            setTitle("新建学生");
            setSize(350, 200);

            labels.add(new JLabel("输入学生院系"));
            labels.add(new JLabel("输入学生名字"));
            notNull = 2;

            add(newPanel(0, "*"));
            add(newPanel(1, "*"));

            button = new JButton("新建学生");
        } else if (type == 'T') {
            setTitle("新建老师");
            setSize(350, 200);

            labels.add(new JLabel("输入老师院系"));
            labels.add(new JLabel("输入老师名字"));
            notNull = 2;

            add(newPanel(0, "*"));
            add(newPanel(1, "*"));

            button = new JButton("新建老师");
        } else if (type == 'C') {
            setTitle("新建课程");
            setSize(350, 300);

            labels.add(new JLabel("输入课程名称"));
            labels.add(new JLabel("输入你的名字"));
            labels.add(new JLabel("输入你的院系"));
            notNull = 3;

            add(newPanel(0, "*"));
            add(newPanel(1, "*"));
            add(newPanel(2, "*"));

            button = new JButton("新建课程");
        }

        buttonClear = new JButton("清除");
        button.addActionListener(this::actionPerformed);
        buttonClear.addActionListener(this::actionPerformed);
        JPanel p = new JPanel();
        p.add(button);
        p.add(buttonClear);
        add(p);

        setVisible(true);
    }

    private JPanel newPanel(int index, String s) {
        JPanel panel = new JPanel();

        panel.add(labels.get(index));
        JTextField field = new JTextField(20);
        fields.add(field);
        panel.add(field);
        panel.add(newLable(s));

        return panel;
    }

    private JLabel newLable(String s) {
        JLabel label = new JLabel(s);
        label.setForeground(Color.red);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("清除")) {
            for (JTextField f : fields) f.setText("");
        } else {
            if (cmd.equals("新建院系")) {
                DepartmentsService ds = context.getBean(DepartmentsService.class);
                Departments d = new Departments();
                d.setDname(fields.get(0).getText());
                d.setJob("D");
                ds.createDepartment(d);
            } else if (cmd.equals("新建老师")) {
                DepartmentsService ds = context.getBean(DepartmentsService.class);
                Departments d = new Departments();
                d.setDname(fields.get(0).getText());
                d.setName(fields.get(1).getText());
                d.setJob("T");
                ds.createPoeple(d);
            } else if (cmd.equals("新建学生")) {
                DepartmentsService ds = context.getBean(DepartmentsService.class);
                Departments d = new Departments();
                d.setDname(fields.get(0).getText());
                d.setName(fields.get(1).getText());
                d.setJob("S");
                ds.createPoeple(d);
            } else if (cmd.equals("新建课程")) {
                CoursesService cs = context.getBean(CoursesService.class);
                Courses c = new Courses();

                c.setCname(fields.get(0).getText());
                if (fields.get(1).getText().trim().length()==0)c.setName("null");
                else c.setName(fields.get(1).getText());
                c.setDname(fields.get(2).getText());
                cs.createCourse(c);
            }
            mf.flush();
            setVisible(false);
        }
    }

    private String getDate() {
        String date = new Date().toString();
        return date.substring(date.length() - 4);
    }

}
