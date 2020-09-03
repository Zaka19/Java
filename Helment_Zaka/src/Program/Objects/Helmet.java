package Program.Objects;
import Program.Tools.Music;
import Program.Tools.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Helmet {
        private int _width;
        private int _height;
        private int x = 80;
        private int _life = 3;
        private int y;
        private int xA = 0;
        int points = 95;
        ImageIcon _img;
        boolean stun = false;
        boolean shield = false;
        boolean invers = false;
        Music m = new Music();

        private Panel panel;

        public Helmet(Panel panel , int width, int height, ImageIcon img){
            this._width = width;
            this._height = height;
            this.panel = panel;
            this._img = img;
        }

        public void Move() throws InterruptedException {
            if (x + xA  >= 80 && x + xA < panel.getWidth() - _width){
                x = x + xA;
            }
            else if(x + xA > panel.getWidth() - (_width*2) && panel._door.getColor() == Color.GREEN){
                x = x + xA;
            }
            if(panel._door.getBounds().intersects(getBounds()) && panel._door.getColor() == Color.GREEN){
                //panel._door.setCho(true);
                this.x = 80;
                points += 5;
                m.StartMusic("/Music/point.wav").start();
            }

            for(int a = 0; a < Creator.obj.size();a++){
                if(Creator.obj.get(a).getBounds().intersects(getBounds()) && !Creator.obj.get(a).isCho()){
                    if(!shield) {
                        Creator.obj.get(a).Method();
                        Creator.obj.get(a).setCho(true);
                    }
                }
            }
            xA = 0;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int get_life() {
            return _life;
        }

        public void set_life(int _life) {
            this._life = _life;
        }

        public int get_width() {
            return _width;
        }

        public void set_width(int _width) {
            this._width = _width;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public void paint(Graphics2D _graphics2d){
            _graphics2d.drawImage(_img.getImage(),x , panel.getHeight() - _height,_width,_height,null);
        }

        public void keyReleased(KeyEvent e) {
            if(!stun) {
                if(!invers) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT)
                        System.out.println(_width);
                    xA = -_width;
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                        xA = _width;
                }
                else{
                    if (e.getKeyCode() == KeyEvent.VK_LEFT)
                        System.out.println(_width);
                    xA = _width;
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                        xA = -_width;
                }
            }
        }

        public Rectangle getBounds() {
            return new Rectangle(x, panel.getHeight() - _height, _width, _height);
    }
}
