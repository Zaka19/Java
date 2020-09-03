package Graphics;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Break {

    private int _width;
    private int _height;
    private int _x;
    private int _y;
    int _life;

    private JPanel_Content _panel;

    public Break(JPanel_Content panel , int width, int height, int y, int x , int life){
        this._width = width;
        this._height = height;
        this._panel = panel;
        this._x = x;
        this._y = y;
        this._life = life;
    }

    public int get_x() {
        return _x;
    }

    public int get_life() {
        return _life;
    }

    public void set_life(int _life) {
        this._life = _life;
    }

    public void paint(Graphics2D _graphics2d){
        _graphics2d.fillRect(_x, _y, _width, _height);
    }

    public Rectangle getBounds() {
        return new Rectangle(_x, _y, _width, _height);
    }

    public int getUnderY() {
        return _y + _height;
    }

    public int getTopY() {
        return _y;
    }

    public int getRightX() {
        return _x + _width;
    }
}
