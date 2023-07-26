package code;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo02 {
    // 使用 panel 装在基本组件，并添加到 Frame
    public static void main(String[] args) {
        Frame frame = new Frame("我的Frame窗口");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setLocation(50, 50);
        // 创建一个 Panel 容器
        Panel panel = new Panel();
        // 向容器中添加一个 Label 和 TextField 组件
        panel.add(new Label("name"));
        panel.add(new TextField(20));
        // 将 panel 添加到 frame
        frame.add(panel);
        // 设置 Frame 的自适应大小
        frame.pack();
        frame.setVisible(true);
    }
}
