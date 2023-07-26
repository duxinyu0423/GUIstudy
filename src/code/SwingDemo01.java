package code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

// 将 组件 定义为 属性
// 在 构造方法 中构建 组件
// 自定义 init() 方法设置布局
// 在 show() 方法中设置GUI的显示属性
public class SwingDemo01{
    // 构建主界面菜单部分
    private final JFrame jFrame; // 窗口
    private JMenuBar jMenuBar; // 菜单栏
    private JMenu registerMenu; // 注册菜单
    private JMenu editMenu; // 编辑用户信息菜单
    private JMenu inquireMenu; // 查询用户信息菜单
    private JMenu authorityManagementMenu; // 权限管理菜单

    public SwingDemo01() {
        jFrame = new JFrame("用户管理系统");
        jMenuBar = new JMenuBar();
        registerMenu = new JMenu("注册(N)");
        editMenu = new JMenu("编辑用户信息(E)");
        inquireMenu = new JMenu("查询用户信息(S)");
        authorityManagementMenu = new JMenu("权限管理(L)");
    }

    private void createMenuBar() {
        // 为菜单设置热键
        registerMenu.setMnemonic(KeyEvent.VK_N);
        editMenu.setMnemonic(KeyEvent.VK_E);
        inquireMenu.setMnemonic(KeyEvent.VK_S);
        authorityManagementMenu.setMnemonic(KeyEvent.VK_S);
        // 创建菜单项
        JMenuItem jmiRegister = new JMenuItem("注册用户(Ctrl+N)");
        JMenuItem jmiChange = new JMenuItem("修改用户信息");
        JMenuItem jmiDelete = new JMenuItem("删除用户信息");
        JMenuItem jmiInquireByName = new JMenuItem("通过用户名");
        JMenuItem jmiInquireByAccount = new JMenuItem("通过账号");
        JMenuItem jmiUser = new JMenuItem("用户权限");
        JMenuItem jmiAdministrator = new JMenuItem("管理员权限");
        // 并向菜单添加菜单项
        registerMenu.add(jmiRegister);
        editMenu.add(jmiChange);
        editMenu.add(jmiDelete);
        inquireMenu.add(jmiInquireByName);
        inquireMenu.add(jmiInquireByAccount);
        authorityManagementMenu.add(jmiUser);
        authorityManagementMenu.add(jmiAdministrator);
        // 设置快捷键
        jmiRegister.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        // 将菜单添加到菜单栏
        jMenuBar.add(registerMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(inquireMenu);
        jMenuBar.add(authorityManagementMenu);
        // 将菜单栏添加到 JFrame ，this 作为当前窗口对象
        jFrame.setJMenuBar(jMenuBar);
    }

    private void showMe() {
        createMenuBar();
        jFrame.pack();
        jFrame.setLocation(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingDemo01().showMe();
    }
}
