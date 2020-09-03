package Objects;

import javax.swing.*;
import java.awt.*;

public class Door {
    private int width;
    private int height;
    private int x;
    private int y;
    private ImageIcon img;
    private Tools.Panel panel;

    public Door (Tools.Panel _panel, int _width, int _height){
        this.height = _height;
        this.width = _width;
        this.panel = _panel;
        this.img = new ImageIcon(getClass().getResource("/Images/DoorClose.png"));
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
        _graphics2d.drawImage(img.getImage(),0, panel.getHeight() - height,width,height,null);
        _graphics2d.drawImage(img.getImage(),panel.getWidth() - width,panel.getHeight() - height, width, height,null);
    }
}
