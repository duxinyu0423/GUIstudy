package code;

import java.awt.*;
import java.awt.event.*;

public class Chat {
    private Frame frame; // Frame����
    private TextField textField; // �ı���
    private TextArea textArea; // �ı���
    private Button button; // ���Ͱ�ť

    public Chat() {
        frame = new Frame("��������");
        button = new Button("����");
        textArea = new TextArea(10, 30);
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
        textArea.setEditable(false);
        textField = new TextField(26);
    }

    public void init() {
        Panel panelCenter = new Panel();
        panelCenter.add(textArea);
        Panel panelSouth = new Panel();
        panelSouth.add(textField);
        panelSouth.add(button);
        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelCenter, BorderLayout.CENTER);
    }

    public void addEventHandler() {
        // Ϊ�¼�Դע���¼�������
        button.addActionListener(new TextButtonActionHandler());
        textField.addActionListener(new TextButtonActionHandler());
        textField.addTextListener(new TextFieldChangeHandler());
    }

    public void showMe() {
        init();
        addEventHandler();
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // ��Ա�ڲ�����������
    private class TextButtonActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append(textField.getText() + "\n");
            textField.setText(" ");
        }
    }
    private class TextFieldChangeHandler implements TextListener {
        @Override
        public void textValueChanged(TextEvent e) {
            if (textField.getText().equals("hehe")) {
                textArea.append("aaa\n");
                textField.setText(" ");
            }
        }
    }

    public static void main(String[] args) {
        new Chat().showMe();
    }
}
