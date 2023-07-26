package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// ������ҳ�湤����
public class SwingDemo02 {
// �� ��� ����Ϊ ����
// �� ���췽�� �й��� ���
// �Զ��� init() �������ò���
// �� show() ����������GUI����ʾ����
    private JFrame jFrame;
    private JToolBar jToolBar; // ������
    private JButton jbtRegister;  // ���߰�ť
    private JButton jbtEdit;
    private JButton jbtRemove;
    private JButton jbtSearch;
    private Icon imaRegister;
    private Icon imaEdit;
    private Icon imaRemove;
    private Icon imaSearch;

    public SwingDemo02() {
        jFrame = new JFrame("���߰�ť");
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
        jbtRegister.setToolTipText("ע���û�");
        jbtEdit.setToolTipText("�༭�û���Ϣ");
        jbtRemove.setToolTipText("ɾ���û���Ϣ");
        jbtSearch.setToolTipText("��������û�");
    }

    private void init() {
        // �����߰�ť���ӵ�������
        jToolBar.add(jbtRegister);
        jToolBar.add(jbtEdit);
        jToolBar.add(jbtRemove);
        jToolBar.add(jbtSearch);
        // �����������ӵ� JFrame, this Ϊ��ǰ���ڶ���
        jFrame.add("North", jToolBar);
    }

    private void addButtonListener () {
        jbtRegister.addActionListener(new RegisterHandler());  // ��ť�����¼�������
    }

    private class RegisterHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // ��������ʾע��Ի���

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