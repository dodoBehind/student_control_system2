package mine.student_control_system2.ui;

import lombok.Getter;
import mine.student_control_system2.domain.Departments;
import mine.student_control_system2.moudel.CoursesMoudel;
import mine.student_control_system2.moudel.DepartmentModel;
import mine.student_control_system2.service.CoursesService;
import mine.student_control_system2.service.DepartmentsService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends MoveFrame {
    private LoginPanel loginPanel;

    private InfoPanel infoPanel, coursePanel;

    private Departments d;

    private ApplicationContext context;


    private CoursesMoudel coursesMineMoudel, coursesAllMoudel;
    private DepartmentModel departmentModel;

    @Getter
    private CardLayout cardLayout;
    @Getter
    private JLayeredPane layeredPane;

    public MainFrame(ApplicationContext context) {
        this.context = context;
        loginPanel = new LoginPanel(this);

        layeredPane = new JLayeredPane();
        cardLayout = new CardLayout();
        layeredPane.setLayout(cardLayout);
        layeredPane.add("loginPanel", loginPanel);
        cardLayout.show(layeredPane, "loginPanel");
        add(layeredPane);
    }

    public void addButton(JPanel p) {

        if (d.getJob().charAt(0) == 'S' || d.getJob().charAt(0) == 'T') {
            JButton b1 = new ChangeButton("个人信息", this);
            JButton b2 = new ChangeButton("选课信息", this);

            JButton b3 = new JButton("修改服务");

            JButton b = new JButton("退出");
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            b.setBackground(new Color(0x8B0000));
            b.setForeground(Color.WHITE);
            b1.setBackground(new Color(0x262626));
            b1.setForeground(Color.WHITE);
            b2.setBackground(new Color(0x262626));
            b2.setForeground(Color.WHITE);
            b3.setBackground(new Color(0x262626));
            b3.setForeground(Color.WHITE);


            b3.addActionListener(new Listener());

            p.add(b1);
            p.add(b2);
            p.add(b3);
            p.add(b);
        }
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(400, 100);
            JButton b1 = new JButton("新增老师");
            JButton b2 = new JButton("新增学生");
            JButton b3 = new JButton("新增院系");
            JButton b4 = new JButton("新增课程");
            b1.addActionListener(new AddCourseListener());
            b2.addActionListener(new AddCourseListener());
            b3.addActionListener(new AddCourseListener());
            b4.addActionListener(new AddCourseListener());
            frame.add(b1);
            frame.add(b2);
            frame.add(b3);
            frame.add(b4);

            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        }

    }


    private class AddCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            System.out.println(cmd);
            if (cmd.equals("新增老师")) {
                new AddFrame('T', context,MainFrame.this);
            } else if (cmd.equals("新增学生")) {
                new AddFrame('S', context,MainFrame.this);
            } else if (cmd.equals("新增院系")) {
                new AddFrame('D', context,MainFrame.this);
            } else if (cmd.equals("新增课程")) {
                new AddFrame('C', context,MainFrame.this);
            }
        }
    }
    private CoursesService cs;
    void login(String userId, String password) {
        departmentModel = new DepartmentModel();
        coursesAllMoudel = new CoursesMoudel();
        coursesMineMoudel = new CoursesMoudel();

        DepartmentsService ds = context.getBean(DepartmentsService.class);
         cs = context.getBean(CoursesService.class);

        try {
            d = ds.getMineDepartment(userId);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "查无此人,请重新登陆", "", JOptionPane.ERROR_MESSAGE);
            return;
        }


        departmentModel.setDepartments(d);
        coursesAllMoudel.setCourses(cs.getAllCourse());

        coursesMineMoudel.setCourses(cs.getMineCourse(userId));

        infoPanel = new InfoPanel(departmentModel,
                coursesMineMoudel);
        coursePanel = new InfoPanel(coursesMineMoudel,
                coursesAllMoudel);

        setLayout(new CardLayout());
        layeredPane.add("infoPanel", infoPanel);
        layeredPane.add("coursePanel", coursePanel);

        cardLayout.show(layeredPane, "infoPanel");

        infoPanel.setD(d);
        addButton(infoPanel.getBarPanel());
        addButton(coursePanel.getBarPanel());
    }

    public void flush(){
        coursesAllMoudel.setCourses(cs.getAllCourse());
        coursesMineMoudel.setCourses(cs.getMineCourse(d.getName()));
    }

}
