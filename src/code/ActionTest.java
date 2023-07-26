package code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActionTest {
    private Frame frame;
    private Button button;
    private TextArea textArea;

    public ActionTest() {
        frame = new Frame("动作检测");
        button = new Button("单击我");
        textArea = new TextArea(10, 20);
    }

    public void init() {
        frame.add(button, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
    }

    public void showMe() {
        init();
        //为事件注册监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("您刚刚点击了一次" + "\n");
            }
        });
        frame.setBounds(50, 50, 400, 160);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ActionTest().showMe();
    }
}
