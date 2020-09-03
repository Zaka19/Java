package Graphics;
import javax.swing.*;
import java.awt.*;

public class JFrame_Ventana {
    public void Start(String name_project, int width, int height, String _PathImage, JPanel_Content _panel) throws InterruptedException {
        JFrame _window = new JFrame(name_project);
        _window.setSize(width,height);
        _window.setIconImage(new ImageIcon(_PathImage).getImage());
        _window.add(_panel);
        _window.setVisible(true);
        _window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            _panel.move();
            _panel.repaint();
            Thread.sleep(10);
        }
    }
}
