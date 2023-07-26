package code;

import javax.swing.*;
import java.awt.*;

public class RegisterDialog extends JDialog{
    private JLabel jlbEmail; // 注册提示
    private JTextField jtfEmail; // 输入注册信息的文本框
    private JLabel jlbName; // 输入姓名的提示
    private JTextField jtfName; // 输入用户名的文本框
    private JLabel jlbSex; // 选择性别的提示标签
    private JLabel jlbMale; // 性别男
    private JLabel jlbFemale; //性别女
    private JRadioButton jrbMale; // 男的单选按钮
    private JRadioButton jrbFemale; //女的单选按钮
    private JLabel jlbHobby; // 爱好
    private String[] strHobbies;
    private JCheckBox[] hobbies;
    private JLabel[] jlbHobbies;
    private JButton jbtSave; // 保存按钮
    private JButton jbtModify; // 修改按钮
    private JButton jbtExit; // 退出按钮
    private int windowHeight; // 窗口高度
    private int windowWidth; // 窗口宽度
    private JPanel jpEmail;
    private JPanel jpName;
    private JPanel jpSex;
    private ButtonGroup bgSexRadioButton;
    private JPanel jpHobby;
    private JPanel jpOperation;
    private JPanel mainJPanel;

    public RegisterDialog(Frame owner, String title) {
        super(owner, title);
        jlbEmail = new JLabel("Email: ");
        jtfEmail = new JTextField(20);
        jlbName = new JLabel("Name: ");
        jtfName = new JTextField(20);
        jlbSex = new JLabel("Sex: ");
        jlbMale = new JLabel("Male");
        jlbFemale = new JLabel("Female");
        jrbMale = new JRadioButton();
        jrbFemale = new JRadioButton();
        jlbHobby = new JLabel("Hobby: ");
        strHobbies = new String[]{"sports", "surfing the Internet", "reading books", "playing games"};
        hobbies = new JCheckBox[4];
        jlbHobbies = new JLabel[4];
        jbtSave = new JButton("Save");
        jbtModify = new JButton("Modify");
        jbtExit = new JButton("Exit");
        windowHeight = 280;
        windowWidth = 600;
        jpEmail = new JPanel();
        jpName = new JPanel();
        jpSex = new JPanel();
        jpHobby = new JPanel();
        jpOperation = new JPanel();
        bgSexRadioButton = new ButtonGroup();
        for(int i = 0; i < strHobbies.length; i++) {
            hobbies[i] = new JCheckBox();
            jlbHobbies[i] = new JLabel();
        }
        mainJPanel = new JPanel();
     }

     // 设置布局
    private void init() {
        jpEmail.add(jlbEmail);
        jpEmail.add(jtfEmail);
        jpName.add(jlbName);
        jpName.add(jtfName);
        bgSexRadioButton.add(jrbMale);
        bgSexRadioButton.add(jrbFemale);
        jpSex.add(jlbSex);
        jpSex.add(jlbMale);
        jpSex.add(jrbMale);
        jpSex.add(jlbFemale);
        jpSex.add(jrbFemale);
        jrbFemale.setSelected(true);
        jpHobby.add(jlbHobby);
        for(int i = 0; i < strHobbies.length; i++) {
            jlbHobbies[i].setText(strHobbies[i]);
            jpHobby.add(hobbies[i]);
            jpHobby.add(jlbHobbies[i]);
        }
        jpOperation.add(jbtSave);
        jpOperation.add(jbtModify);
        jpOperation.add(jbtExit);
        mainJPanel.setLayout(new GridLayout(5, 1, 5, 5));
        mainJPanel.add(jpEmail);
        mainJPanel.add(jpName);
        mainJPanel.add(jpSex);
        mainJPanel.add(jpHobby);
        mainJPanel.add(jpOperation);
        this.add(mainJPanel); // 给Dialog加入总面板
    }

    public void showMe() {
        this.init();
//        setResizable(false); // 设置不可变大小
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);
    }
}
