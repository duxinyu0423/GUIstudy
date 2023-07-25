import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo03 {
    // 将 组件 定义为 属性
    // 在 构造方法 中构建 组件
    // 自定义 init() 方法设置布局
    // 在 show() 方法中设置GUI的显示属性
    private Frame frame;
    private TextField textField;
    private Button[] allButtons;

    // 在构造方法中创建组件
    public Demo03() {
        frame = new Frame("AWT 计算器");
        textField = new TextField(20);
        // 创建计算器的按钮
        allButtons = new Button[20];
        String str = "←C√±789/456*123-0.=+";
        for (int i = 0; i < 20; i++) {
            allButtons[i] = new Button(str.substring(i, i+1));
        }
    }

    // 初始化窗口，设置布局
    private void init() {
        // frame 的北部面板，默认为FlowLayout布局
        Panel northPanel = new Panel();
        northPanel.add(textField);
        // frame的中部面板：设置GirdLayout布局
        Panel centerPanel = new Panel();
        GridLayout gird = new GridLayout(5, 4, 2, 2);
        centerPanel.setLayout(gird);
        // 将按钮添加至中部面板
        for (int i = 0; i < allButtons.length; i++) {
            centerPanel.add(allButtons[i]);
        }
        // 将面板添加到窗口
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
    }


    // 设置窗口的显示属性
    public void showMe() {
        init();
        addEventHandler();
        frame.pack();
        frame.setLocation(300, 200);
        frame.setResizable(false); //禁止改变窗口的大小
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
    
    // 全局初值，只被赋值一次
    double op1 = 0;
    double op2 = 0;
    String operator = "";
    boolean flag = true;
    
    private class CalculateActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // 获取按钮上的文本
            if ("0123456789.".indexOf(command) != -1) { // 得到数字按钮或者小数点的按钮
                if (flag) {
                    textField.setText(command);
                } else {
                    textField.setText(textField.getText() + command);
                }
                flag = false;
            } else if ("+-*/".indexOf(command) != -1) {
                // 1. 取文本框中的数据：第一个操作数
                op1 = Double.valueOf(textField.getText());
                // 2.记下运算符
                operator = command;
                // 3.清空文本框
                textField.setText("");
            } else if (command.equalsIgnoreCase("=")) {
                // 取文本框的第二个数字
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
