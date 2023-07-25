import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo01 {
    // 创建一个 Frame 窗口
    public static void main(String[] args) {
        Frame frame = new Frame("Frame窗口");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 设置窗口的大小
        frame.setLocation(50, 50);
        frame.setSize(300, 120);
        // 设置窗口可见性
        frame.setVisible(true);
    }
}
