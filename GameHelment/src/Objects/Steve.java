package Objects;

import javax.swing.*;
import java.awt.*;

public class Steve {
    private int width;
    private int height;
    private int x;
    private int y;
    private ImageIcon img;
    private Tools.Panel panel;

    public Steve (Tools.Panel _panel, int _width, int _height, ImageIcon _img){
        this.height = _height;
        this.width = _width;
        this.img = _img;
        this.panel = _panel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics2D _graphics2d){
        y = panel.getHeight() - width;
        x = width;
        _graphics2d.drawImage(img.getImage(),x , y,width,height,null);
    }
}
