import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo03 {
    // �� ��� ����Ϊ ����
    // �� ���췽�� �й��� ���
    // �Զ��� init() �������ò���
    // �� show() ����������GUI����ʾ����
    private Frame frame;
    private TextField textField;
    private Button[] allButtons;

    // �ڹ��췽���д������
    public Demo03() {
        frame = new Frame("AWT ������");
        textField = new TextField(20);
        // �����������İ�ť
        allButtons = new Button[20];
        String str = "��C�̡�789/456*123-0.=+";
        for (int i = 0; i < 20; i++) {
            allButtons[i] = new Button(str.substring(i, i+1));
        }
    }

    // ��ʼ�����ڣ����ò���
    private void init() {
        // frame �ı�����壬Ĭ��ΪFlowLayout����
        Panel northPanel = new Panel();
        northPanel.add(textField);
        // frame���в���壺����GirdLayout����
        Panel centerPanel = new Panel();
        GridLayout gird = new GridLayout(5, 4, 2, 2);
        centerPanel.setLayout(gird);
        // ����ť������в����
        for (int i = 0; i < allButtons.length; i++) {
            centerPanel.add(allButtons[i]);
        }
        // �������ӵ�����
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
    }


    // ���ô��ڵ���ʾ����
    public void showMe() {
        init();
        addEventHandler();
        frame.pack();
        frame.setLocation(300, 200);
        frame.setResizable(false); //��ֹ�ı䴰�ڵĴ�С
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Demo03().showMe();
    }
    
    public void addEventHandler() {
        for (int i = 0; i < allButtons.length; i++) {
            allButtons[i].addActionListener(new CalculateActionHandler());
        }
    }
    
    // ȫ�ֳ�ֵ��ֻ����ֵһ��
    double op1 = 0;
    double op2 = 0;
    String operator = "";
    boolean flag = true;
    
    private class CalculateActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // ��ȡ��ť�ϵ��ı�
            if ("0123456789.".indexOf(command) != -1) { // �õ����ְ�ť����С����İ�ť
                if (flag) {
                    textField.setText(command);
                } else {
                    textField.setText(textField.getText() + command);
                }
                flag = false;
            } else if ("+-*/".indexOf(command) != -1) {
                // 1. ȡ�ı����е����ݣ���һ��������
                op1 = Double.valueOf(textField.getText());
                // 2.���������
                operator = command;
                // 3.����ı���
                textField.setText("");
            } else if (command.equalsIgnoreCase("=")) {
                // ȡ�ı���ĵڶ�������
                double res = 0;
                String text = textField.getText();
                if (text.length() > 0) {
                    op2 = Double.valueOf(text);
                    if (operator.equals("+")) {
                        res = op1 + op2;
                    } else if (operator.equals("-")) {
                        res = op1 - op2;
                    } else if (operator.equals("*")) {
                        res = op1 * op2;
                    } else if (operator.equals("/")) {
                        res = op1 / op2;
                    }
                    textField.setText(String.valueOf(res));
                }
                flag = true;
            }
        }
    }
}
