package code;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowDataTableDialog extends JDialog {
    private int windowHeight = 300; // 窗口高度
    private int windowWidth = 450;
    private JTable jTable;

    public ShowDataTableDialog(Frame owner, String title, List<User>users) {
        super(owner, "用户列表", true);
        jTable = new JTable();
        // 创建 TableModel
        UserTableModel tableModel = new UserTableModel(users);
        // 为 JTable 设置 TableModel
        jTable.setModel(tableModel);
    }

    public void showMe(JFrame parent) {
        // 为每一列设置列宽
        jTable.getColumn("IDX").setPreferredWidth(30);
        jTable.getColumn("email").setPreferredWidth(100);
        jTable.getColumn("name").setPreferredWidth(60);
        jTable.getColumn("sex").setPreferredWidth(60);
        jTable.getColumn("hobby").setPreferredWidth(200);
        // 关闭 JTable 的自动调节功能
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // 将 JTable 加入滚动条面板
        JScrollPane rollPane = new JScrollPane(jTable);
        // 将滚动条加入窗口
        this.add(rollPane);
        // 计算对话框的显示位置
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
