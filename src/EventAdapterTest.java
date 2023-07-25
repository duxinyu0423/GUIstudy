import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventAdapterTest {
    // 为 AWT 窗口编写一个 关闭功能
    private Frame frame;

    public EventAdapterTest() {
        frame = new Frame();
    }

    public void showMe() {
        frame.addWindowListener(new WindowCloseHandler());
        frame.setBounds(100, 100, 200, 200);
        frame.setVisible(true);
    }

    private class WindowCloseHandler extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new EventAdapterTest().showMe();
    }
}
