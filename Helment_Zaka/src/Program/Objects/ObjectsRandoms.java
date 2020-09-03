package Program.Objects;

import Program.Tools.Panel;

import javax.swing.*;
import java.awt.*;

public abstract class ObjectsRandoms extends Thread{
    private int name;
    private int _width;
    private int _height;
    private int y = -80;
    private int x;
    private boolean cho = false;
    ImageIcon _img;
    private Panel panel;

    public ObjectsRandoms(int name, Panel panel , int width, int height, int x, ImageIcon img){
        this.name = name;
        this._width = width;
        this._height = height;
        this.panel = panel;
        this.x = x;
        this._img = img;
    }

    @Override
    public void run(){
        while(this.y + _width < panel.getHeight() - _height) {
            Move();
            try {
                System.out.println("tEMPS: " + panel._d.Timer);
                Thread.sleep(panel._d.Timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Creator.destroy(this);
        System.out.println("Destruir " + name);
    }

    public int get_name(){
        return name;
    }

    public boolean isCho() {
        return cho;
    }

    public void setCho(boolean cho) {
        this.cho = cho;
    }

    public int get_width() {
        return _width;
    }

    public void set_width(int _width) {
        this._width = _width;
    }

    public int get_height() {
        return _height;
    }

    public void set_height(int _height) {
        this._height = _height;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Move(){
        y += 80;
    }

    protected abstract void Method();

    public void paint(Graphics2D _graphics2d){
        _graphics2d.drawImage(_img.getImage(),x,y,_width,_height,null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, _width, _height);
    }
}
