package code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

// �� ��� ����Ϊ ����
// �� ���췽�� �й��� ���
// �Զ��� init() �������ò���
// �� show() ����������GUI����ʾ����
public class SwingDemo01{
    // ����������˵�����
    private final JFrame jFrame; // ����
    private JMenuBar jMenuBar; // �˵���
    private JMenu registerMenu; // ע��˵�
    private JMenu editMenu; // �༭�û���Ϣ�˵�
    private JMenu inquireMenu; // ��ѯ�û���Ϣ�˵�
    private JMenu authorityManagementMenu; // Ȩ�޹���˵�

    public SwingDemo01() {
        jFrame = new JFrame("�û�����ϵͳ");
        jMenuBar = new JMenuBar();
        registerMenu = new JMenu("ע��(N)");
        editMenu = new JMenu("�༭�û���Ϣ(E)");
        inquireMenu = new JMenu("��ѯ�û���Ϣ(S)");
        authorityManagementMenu = new JMenu("Ȩ�޹���(L)");
    }

    private void createMenuBar() {
        // Ϊ�˵������ȼ�
        registerMenu.setMnemonic(KeyEvent.VK_N);
        editMenu.setMnemonic(KeyEvent.VK_E);
        inquireMenu.setMnemonic(KeyEvent.VK_S);
        authorityManagementMenu.setMnemonic(KeyEvent.VK_S);
        // �����˵���
        JMenuItem jmiRegister = new JMenuItem("ע���û�(Ctrl+N)");
        JMenuItem jmiChange = new JMenuItem("�޸��û���Ϣ");
        JMenuItem jmiDelete = new JMenuItem("ɾ���û���Ϣ");
        JMenuItem jmiInquireByName = new JMenuItem("ͨ���û���");
        JMenuItem jmiInquireByAccount = new JMenuItem("ͨ���˺�");
        JMenuItem jmiUser = new JMenuItem("�û�Ȩ��");
        JMenuItem jmiAdministrator = new JMenuItem("����ԱȨ��");
        // ����˵���Ӳ˵���
        registerMenu.add(jmiRegister);
        editMenu.add(jmiChange);
        editMenu.add(jmiDelete);
        inquireMenu.add(jmiInquireByName);
        inquireMenu.add(jmiInquireByAccount);
        authorityManagementMenu.add(jmiUser);
        authorityManagementMenu.add(jmiAdministrator);
        // ���ÿ�ݼ�
        jmiRegister.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        // ���˵���ӵ��˵���
        jMenuBar.add(registerMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(inquireMenu);
        jMenuBar.add(authorityManagementMenu);
        // ���˵�����ӵ� JFrame ��this ��Ϊ��ǰ���ڶ���
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
