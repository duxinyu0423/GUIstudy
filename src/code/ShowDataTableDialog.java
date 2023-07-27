package code;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowDataTableDialog extends JDialog {
    private int windowHeight = 300; // ���ڸ߶�
    private int windowWidth = 450;
    private JTable jTable;

    public ShowDataTableDialog(Frame owner, String title, List<User>users) {
        super(owner, "�û��б�", true);
        jTable = new JTable();
        // ���� TableModel
        UserTableModel tableModel = new UserTableModel(users);
        // Ϊ JTable ���� TableModel
        jTable.setModel(tableModel);
    }

    public void showMe(JFrame parent) {
        // Ϊÿһ�������п�
        jTable.getColumn("IDX").setPreferredWidth(30);
        jTable.getColumn("email").setPreferredWidth(100);
        jTable.getColumn("name").setPreferredWidth(60);
        jTable.getColumn("sex").setPreferredWidth(60);
        jTable.getColumn("hobby").setPreferredWidth(200);
        // �ر� JTable ���Զ����ڹ���
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // �� JTable ������������
        JScrollPane rollPane = new JScrollPane(jTable);
        // �����������봰��
        this.add(rollPane);
        // ����Ի������ʾλ��
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
