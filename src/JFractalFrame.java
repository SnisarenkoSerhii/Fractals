/**
 * Created by Sergey on 09.10.2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class JFractalFrame extends JFrame {
    boolean startAnimation=false;
    JPanel paintPanel;

    public JFractalFrame() {
        setTitle("FractalTree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paintPanel = new PaintPanel();
        paintPanel.setBackground(Color.DARK_GRAY);
        add(paintPanel);
        requestFocus();//Обращаем фокус на наш фрейм. Без этой строки, реакции не будет
        // А здесь отлавливаем любое нажатие на кнопку, и запускаем анимацию
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()>0 && !startAnimation){
                    pack();
                    startAnimation=true;
                    startAnimation ();
                }
            }
        });
        paintPanel.repaint();
        pack();
    }

    public void startAnimation(){
        Runnable galaxyRun = new FractalRunnable((PaintPanel) paintPanel);
        Thread t = new Thread(galaxyRun);
        t.start();
    }
}