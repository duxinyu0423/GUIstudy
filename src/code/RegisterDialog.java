package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegisterDialog extends JDialog{
    private JLabel jlbEmail; // ע����ʾ
    private JTextField jtfEmail; // ����ע����Ϣ���ı���
    private JLabel jlbName; // ������������ʾ
    private JTextField jtfName; // �����û������ı���
    private JLabel jlbSex; // ѡ���Ա����ʾ��ǩ
    private JLabel jlbMale; // �Ա���
    private JLabel jlbFemale; //�Ա�Ů
    private JRadioButton jrbMale; // �еĵ�ѡ��ť
    private JRadioButton jrbFemale; //Ů�ĵ�ѡ��ť
    private JLabel jlbHobby; // ����
    private String[] strHobbies;
    private JCheckBox[] hobbies;
    private JLabel[] jlbHobbies;
    private JButton jbtSave; // ���水ť
    private JButton jbtModify; // �޸İ�ť
    private JButton jbtExit; // �˳���ť
    private int windowHeight; // ���ڸ߶�
    private int windowWidth; // ���ڿ��
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
        // ���� users
        this.users = users;
     }

     // ���ò���
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
        this.add(mainJPanel); // ��Dialog���������
    }

    // ��ȡ������Ϣ�������еİ���ƴ�ӳ�һ���ַ���
    private String getHobbiesInfo() {
        StringBuilder hobbiesInfo = new StringBuilder();
        for(int i = 0; i < hobbies.length; i++) {
            if(hobbies[i].isSelected()) { // �ð������ڵİ�ť��ѡ��
                String hobbyText = jlbHobbies[i].getText();
                hobbiesInfo.append(hobbyText).append("  ");
            }
        }
        return hobbiesInfo.toString();
    }

    // ����һ�������ķ��������水ť����¼�������
    private void addSaveListener() {
        jbtSave.addActionListener(new SaveHandler());
    }

    // ���水ť���¼���������ʵ���¼������еķ���
    private class SaveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = jtfEmail.getText();
            String name = jtfName.getText();
            String sex = jrbFemale.isSelected() ? "female" : "male";
            String hobby = getHobbiesInfo();
            // ����û�
            if (email.length() == 0) {
                JOptionPane.showMessageDialog(null, "������email", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                jtfEmail.grabFocus(); // �ѹ��ŵ�email�ı�����
            } else if (!email.matches("[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}")) {
                JOptionPane.showMessageDialog(null, "email��ʽ����", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                jtfEmail.setText(""); // ��������
                jtfEmail.grabFocus(); // �ѹ��ŵ�email�ı�����
            } else if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "������name", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                jtfName.grabFocus(); // �ѹ��ŵ�name�ı�����
            } else {
                if (users.selectByEmail(email) != null) {
                    JOptionPane.showMessageDialog(null, "�������Ѿ���ע��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                    jtfEmail.setText(""); // ��������
                    jtfEmail.grabFocus(); // �ѹ��ŵ�email�ı�����
                } else {
                    // ��װ�û�
                    User user = new User(email, name, sex, hobby);
                    users.insert(user); // �����û�
                    clear(); // ������
                }
            }
        }
    }

    public void clear() {
        // ���������ǽ������ԭΪ��ʼ״̬
        jtfEmail.setText("");
        jtfName.setText("");
        jrbFemale.setSelected(true);
        for(JCheckBox hobby : hobbies) {
            hobby.setSelected(false);
        }
    }

    public void showMe() {
        init();
//        setResizable(false); // ���ò��ɱ��С
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);
    }
}
