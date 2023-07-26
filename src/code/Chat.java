package code;

import java.awt.*;
import java.awt.event.*;

public class Chat {
    private Frame frame; // Frame窗口
    private TextField textField; // 文本框
    private TextArea textArea; // 文本域
    private Button button; // 发送按钮

    public Chat() {
        frame = new Frame("自言自语");
        button = new Button("发送");
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
        // 为事件源注册事件监听器
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

    // 成员内部类做监听器
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
