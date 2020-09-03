package Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Bar {

    private int _width;
    private int _height;
    private int x = -1;
    private int y ;
    private int xA = 0;

    private JPanel_Content _panel;

    public Bar(JPanel_Content panel , int width, int height){
        this._width = width;
        this._height = height;
        this._panel = panel;
    }

    public int getxA() {
        return xA;
    }

    public void setxA(int xA) {
        this.xA = xA;
    }

    public void Move(){
        if (x + xA > 0 && x + xA < _panel.getWidth() - _width)
            x = x + xA;
    }

    public void paint(Graphics2D _graphics2d){
        if(x < 0){
            x = _panel.getWidth()/2;
        }
        y = _panel.getHeight() - (_height*2);
        _graphics2d.fillRect(x ,y,_width,_height);
    }


    public void keyReleased(KeyEvent e) {
        xA = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xA = -2;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xA = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, _width, _height);
    }

    public int getTopY() {
        return y - _height;
    }
}
