package Tools;

import Objects.Door;
import Objects.Steve;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private ImageIcon img;

    private Steve _steve;

    private Door Doors;

    public Panel(int width, int height, ImageIcon _img){
        this.img = _img;
        this._steve = new Steve(this,80,80, new ImageIcon(getClass().getResource("/Images/Helmet.png")));
        this.Doors = new Door(this,80,150);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D _graphics2d = (Graphics2D) g;
        _graphics2d.drawImage(img.getImage(),0,0,getWidth(),getHeight(),this);
        _graphics2d.setColor(Color.BLUE);
        _graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        _graphics2d.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
        this._steve.paint(_graphics2d);
        this.Doors.paint(_graphics2d);
    }
}
