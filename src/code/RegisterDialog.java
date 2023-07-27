package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private UserDao users;

    public RegisterDialog(Frame owner, String title, UserDao users) {
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
        // 接受 users
        this.users = users;
     }

     // 设置布局
    private void init() {
        addSaveListener();
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

    // 获取爱好信息，将所有的爱好拼接成一个字符串
    private String getHobbiesInfo() {
        StringBuilder hobbiesInfo = new StringBuilder();
        for(int i = 0; i < hobbies.length; i++) {
            if(hobbies[i].isSelected()) { // 该爱好所在的按钮被选择
                String hobbyText = jlbHobbies[i].getText();
                hobbiesInfo.append(hobbyText).append("  ");
            }
        }
        return hobbiesInfo.toString();
    }

    // 定义一个单独的方法给保存按钮添加事件监听器
    private void addSaveListener() {
        jbtSave.addActionListener(new SaveHandler());
    }

    // 保存按钮的事件监听器，实现事件监听中的方法
    private class SaveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = jtfEmail.getText();
            String name = jtfName.getText();
            String sex = jrbFemale.isSelected() ? "female" : "male";
            String hobby = getHobbiesInfo();
            // 添加用户
            if (email.length() == 0) {
                JOptionPane.showMessageDialog(null, "请输入email", "提示", JOptionPane.PLAIN_MESSAGE);
                jtfEmail.grabFocus(); // 把光标放到email文本框内
            } else if (!email.matches("[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}")) {
                JOptionPane.showMessageDialog(null, "email格式错误", "提示", JOptionPane.PLAIN_MESSAGE);
                jtfEmail.setText(""); // 清空输入框
                jtfEmail.grabFocus(); // 把光标放到email文本框内
            } else if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "请输入name", "提示", JOptionPane.PLAIN_MESSAGE);
                jtfName.grabFocus(); // 把光标放到name文本框内
            } else {
                if (users.selectByEmail(email) != null) {
                    JOptionPane.showMessageDialog(null, "该邮箱已经被注册", "提示", JOptionPane.PLAIN_MESSAGE);
                    jtfEmail.setText(""); // 清空输入框
                    jtfEmail.grabFocus(); // 把光标放到email文本框内
                } else {
                    // 封装用户
                    User user = new User(email, name, sex, hobby);
                    users.insert(user); // 储存用户
                    clear(); // 清空组件
                }
            }
        }
    }

    public void clear() {
        // 清空组件就是将组件还原为初始状态
        jtfEmail.setText("");
        jtfName.setText("");
        jrbFemale.setSelected(true);
        for(JCheckBox hobby : hobbies) {
            hobby.setSelected(false);
        }
    }

    public void showMe() {
        init();
//        setResizable(false); // 设置不可变大小
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);
    }
}
