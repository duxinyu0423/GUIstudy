package code;

import javax.swing.*;
import java.awt.*;

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

     // ���ò���
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
        this.add(mainJPanel); // ��Dialog���������
    }

    public void showMe() {
        this.init();
//        setResizable(false); // ���ò��ɱ��С
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);
    }
}
