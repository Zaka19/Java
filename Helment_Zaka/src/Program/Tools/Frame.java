package Program.Tools;

import javax.sound.sampled.Clip;
import javax.swing.*;

public class Frame {
    public JFrame frame;
    public Panel _panel;

    static Clip _clip;
    public Frame(String title, String _PathImage, int width, int height) throws InterruptedException {
        _panel = new Panel(80, 80, new ImageIcon(Game.class.getResource("/Images/Background.png")));
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.add(_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon(_PathImage).getImage());

        while (!_panel._finish) {
            _panel.repaint();
            if(_panel._start) {
                _panel.life();
                _panel.move();
            }
            Thread.sleep(10);
        }
    }
}
