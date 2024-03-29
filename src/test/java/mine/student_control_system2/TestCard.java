package mine.student_control_system2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestCard implements ActionListener{

    private JFrame fm=new JFrame("卡片的测试");
    private JPanel cardpan,containbtn; //cardpan为卡片显示区域， containbtn为按钮显示区域
    private JButton btn1,btn2,btn3,btn4; //此处定义诗人的按钮
    private JPanel pan1,pan2,pan3,pan4; //此处定义的面板中显示诗句
    private CardLayout card;    //定义卡片布局
    private JTextArea ta1,ta2,ta3,ta4; //定义放诗句的文本域

    public TestCard(){

        //以下为初始化组件
        cardpan=new JPanel();
        containbtn=new JPanel();

        card=new CardLayout();
        cardpan.setLayout(card);

        btn1=new JButton("李白");
        btn2=new JButton("杜甫");
        btn3=new JButton("白居易");
        btn4=new JButton("孟浩然");

        ta1=new JTextArea(30,30);
        ta2=new JTextArea(30,30);
        ta3=new JTextArea(30,30);
        ta4=new JTextArea(30,30);

        //把定义的按钮放到显示按钮的面板中
        containbtn.add(btn1);
        containbtn.add(btn2);
        containbtn.add(btn3);
        containbtn.add(btn4);

        //给按钮添加监听事件
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);


        //给定义的文本域中添加诗人相应的诗句
        ta1.append("日照香炉生紫烟，\r\n");
        ta1.append("遥看瀑布挂前川。\r\n");
        ta1.append("飞流直下三千尺，\r\n");
        ta1.append("疑是银河落九天。");

        ta2.append("两个黄鹂鸣翠柳，\r\n");
        ta2.append("一行白鹭上青天。\r\n");
        ta2.append("窗含西岭千秋雪，\r\n");
        ta2.append("门泊东吴万里船。");

        ta3.append("一道残阳铺水中，\r\n");
        ta3.append("半江瑟瑟半江红。\r\n");
        ta3.append("可怜九月初三夜，\r\n");
        ta3.append("露似珍珠月似弓。");

        ta4.append("春眠不觉晓，\r\n");
        ta4.append("处处闻啼鸟。\r\n");
        ta4.append("夜来风雨声，\r\n");
        ta4.append("花落知多少。");

        pan1=new JPanel();
        pan1.add(ta1);
        pan2=new JPanel();
        pan2.add(ta2);
        pan3=new JPanel();
        pan3.add(ta3);
        pan4=new JPanel();
        pan4.add(ta4);

        //把定义好的面板放到卡片布局的组件中
        cardpan.add("b1",pan1);
        cardpan.add("b2",pan2);
        cardpan.add("b3",pan3);
        cardpan.add("b4",pan4);


        fm.add(containbtn,BorderLayout.NORTH);//把显示按钮的组件放到上面显示
        fm.add(cardpan,BorderLayout.CENTER);//把显示文本域的组件放到中间显示

        fm.setSize(400,400);
        fm.setLocation(200,100);
        fm.setVisible(true);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestCard();
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        /**
         * e.getActionCommand（）显示的结果是对应组件上的内容标签
         * card.show(cardpan, "b1");表示对应组件和显示组件的名称
         * CardLayout.show(Container parent, String name)：显示卡片的实现方法定义
         */
        if("李白".equals(e.getActionCommand())){
            card.show(cardpan, "b1");
        }
        if("杜甫".equals(e.getActionCommand())){
            card.show(cardpan, "b2");
        }
        if("白居易".equals(e.getActionCommand())){
            card.show(cardpan, "b3");
        }
        if("孟浩然".equals(e.getActionCommand())){
            card.show(cardpan, "b4");
        }
    }
}