package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

// 构建主页面工具栏
public class SwingDemo02 {
// 将 组件 定义为 属性
// 在 构造方法 中构建 组件
// 自定义 init() 方法设置布局
// 在 show() 方法中设置GUI的显示属性
    private JFrame jFrame;
    private JToolBar jToolBar; // 工具栏
    private JButton jbtRegister;  // 工具按钮
    private JButton jbtEdit;
    private JButton jbtRemove;
    private JButton jbtSearch;
    private Icon imaRegister;
    private Icon imaEdit;
    private Icon imaRemove;
    private Icon imaSearch;
    private UserDao users; // user 要共享
    private FixedUsers fixedUsers;

    public SwingDemo02() {
        jFrame = new JFrame("工具按钮");
        jToolBar = new JToolBar();
        imaRegister = new ImageIcon("E:\\JavaCode\\GUIstudy\\src\\picture\\register.png");
        imaEdit = new ImageIcon("E:\\JavaCode\\GUIstudy\\src\\picture\\edit.png");
        imaRemove = new ImageIcon("E:\\JavaCode\\GUIstudy\\src\\picture\\remove.png");
        imaSearch = new ImageIcon("E:\\JavaCode\\GUIstudy\\src\\picture\\search.png");
        jbtRegister = new JButton("", imaRegister);
        jbtEdit = new JButton("", imaEdit);
        jbtRemove = new JButton("", imaRemove);
        jbtSearch = new JButton("", imaSearch);
        jbtRegister.setPreferredSize(new Dimension(32,320));
        jbtEdit.setPreferredSize(new Dimension(320,20));
        jbtRemove.setPreferredSize(new Dimension(320,20));
        jbtSearch.setPreferredSize(new Dimension(320,20));
        users = new UserDaoImpForList();
        jbtRegister.setToolTipText("注册用户");
        jbtEdit.setToolTipText("编辑用户信息");
        jbtRemove.setToolTipText("删除用户信息");
        jbtSearch.setToolTipText("浏览所有用户");
        fixedUsers = new FixedUsers();
        users = fixedUsers.copyAssignment();
    }

    private void init() {
        // 将工具按钮添加到工具栏
        jToolBar.add(jbtRegister);
        jToolBar.add(jbtEdit);
        jToolBar.add(jbtRemove);
        jToolBar.add(jbtSearch);
        // 给注册键加一个事件管理器
        addButtonListener();
        // 将工具栏添加到 JFrame, this 为当前窗口对象
        jFrame.add("North", jToolBar);
    }

    private void addButtonListener() {
        jbtRegister.addActionListener(new RegisterHandler());  // 按钮添加事件监听器
    jbtSearch.addActionListener(new SearchAllHandler());
    }

    private class RegisterHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 创建并显示注册对话框
            System.out.println("鼠标点击");
            RegisterDialog registerDialog = new RegisterDialog(jFrame, "注册用户", users);
            registerDialog.showMe();
        }
    }

private class SearchAllHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        List<User>tempUsers = users.selectAll();
        if(tempUsers.size() != 0) {
            // 浏览所有用户
            new ShowDataTableDialog(jFrame, "查询结果", tempUsers);
        }else{
            JOptionPane.showMessageDialog(null, "没有用户信息", "提示", JOptionPane.PLAIN_MESSAGE);
        }
    }
}

    private void showMe() {
        init();
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingDemo02 temp = new SwingDemo02();
        temp.showMe();
    }
}
