import java.awt.*;

/**
 * Created by Sergey on 09.10.2015.
 */
public class FractalTreeTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFractalFrame frame = new JFractalFrame();
                frame.setVisible(true);
            }
        });
    }
}
