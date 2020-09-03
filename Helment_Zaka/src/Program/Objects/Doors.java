package Program.Objects;

import Program.Tools.Panel;

import javax.swing.*;
import java.awt.*;

public class Doors extends Thread{
    private int name;
    private int _width;
    private int _height;
    private int y = 0;
    private int x = 0;
    private Color color = Color.RED;
    private Panel panel;
    boolean cf = false;
    ImageIcon img;

    public Doors(int name, Panel panel , int width, int height, boolean c){
        this.name = name;
        this._width = width;
        this._height = height;
        this.panel = panel;
        cf = c;
        img = new ImageIcon(getClass().getResource("/Images/DoorClose.png"));
    }

    @Override
    public void run(){
        while (!panel._finish) {
            //color = color == Color.RED ? Color.GREEN : Color.RED;
            if(color == Color.RED){
                color = Color.GREEN;
                img = new ImageIcon(getClass().getResource("/Images/DoorOpen.png"));
            }
            else{
                color = Color.RED;
                img = new ImageIcon(getClass().getResource("/Images/DoorClose.png"));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int get_name(){
        return name;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(Graphics2D _graphics2d){
        if(cf){
            x = panel.getWidth() - _width;
        }
        else{
            x = 0;
        }
        System.out.println("Tamaño: " + panel.getWidth());
        y = panel.getWidth() - _height;
        _graphics2d.drawImage(img.getImage(), x, y,_width,_height, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, _width, _height);
    }
}

