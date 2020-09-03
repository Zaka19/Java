package Tools;

import javax.swing.*;

public class Frame {
    JFrame _frame;
    public Frame(String title, int width, int height, ImageIcon img, Panel panel) throws InterruptedException {
        _frame = new JFrame(title);
        _frame.add(panel);
        _frame.setSize(width, height);
        _frame.setVisible(true);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            panel.repaint();
            Thread.sleep(10);
        }
    }
}
