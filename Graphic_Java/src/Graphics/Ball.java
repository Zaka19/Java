package Graphics;

import java.awt.*;

public class Ball {

    private int _width;
    private int _height;

    private int x = 0;
    private int y = 0;
    private int xA = 1;
    private int yA = 1;

    int speed = 2;

    private JPanel_Content _panel;

    public Ball(JPanel_Content panel, int width, int height){
        this._panel = panel;
        this._width = width;
        this._height = height;
    }

    public int getxA() {
        return xA;
    }

    public void setxA(int xA) {
        this.xA = xA;
    }

    public int getyA() {
        return yA;
    }

    public void setyA(int yA) {
        this.yA = yA;
    }

    public void MoveBall(){

        if(_panel._breaks.size() == 0){
           _panel.Win();
        }

        if (x + xA < 0)
            xA = this.speed;
        else if (x + xA > _panel.getWidth() - _width)
            xA = -this.speed;
        else if (y + yA < 0)
            yA = this.speed;
        else if (y + yA > _panel.getHeight() - _height)
            _panel.gameOver();

        else if(collisionBar()){
            yA = -this.speed;
           //y = _panel._bar.getTopY() - _width;
        }

        for(int a = 0; a < _panel._breaks.size();a++) {
            if (_panel._breaks.get(a).getBounds().intersects(getBounds())) {

                System.out.println(_panel._breaks.get(a).getBounds().intersects(getBounds()));
                System.out.println(y + + this.speed + " >= " + _panel._breaks.get(a).getUnderY() + " Suelo");
                System.out.println(y + + _height - this.speed + " <= " + _panel._breaks.get(a).getTopY() + " Techo");
                System.out.println(this.x + this.speed + " >= " + _panel._breaks.get(a).getRightX() + " Borde Derecho");
                System.out.println(this.x + " <= " + _panel._breaks.get(a).get_x() + " Borde Izquierdo");

                if(this.y + this.speed >= _panel._breaks.get(a).getUnderY()){
                    System.out.println("Suelo");
                    yA = this.speed;
                }
                else if(this.y + _height - this.speed <= _panel._breaks.get(a).getTopY()){
                    System.out.println("Techo");
                    yA = -this.speed;
                }
                if(this.x + this.speed >= _panel._breaks.get(a).getRightX()){
                    System.out.println("Borde Derecho");
                    xA = this.speed;
                }
                else if(this.x <= _panel._breaks.get(a).get_x()){
                    System.out.println("Borde Izquierdo");
                    xA = -this.speed;
                }

                /*if(x <= _panel._breaks.get(a).getRightX() && x >= _panel._breaks.get(a).get_x()){
                    if(this.y >= _panel._breaks.get(a).getUnderY()){
                        System.out.println("Abajo");
                        yA = 1;
                    }
                    else if (y + _height <= _panel._breaks.get(a).getTopY()){
                        System.out.println(x + " "+ _panel._breaks.get(a).getRightX());
                        System.out.println("Arriba");
                        yA = -1;
                    }
                }
                else {
                    System.out.println("Bordes");
                    xA = xA > 0 ? -1 : 1;
                }*/

                _panel._breaks.get(a).set_life(_panel._breaks.get(a).get_life() - 1);
                if( _panel._breaks.get(a).get_life() <= 0){
                     _panel._breaks.remove(_panel._breaks.get(a));
                }
            }
        }

            x = x + xA;
            y = y + yA;

    }

    public void paint(Graphics2D _graphics2d) {
        _graphics2d.fillOval(x, y, _width, _height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, _width, _height);
    }

    public boolean collisionBar(){
        return _panel._bar.getBounds().intersects(getBounds());
    }

    //public boolean collisionsBreak() { return _panel._break.getBounds().intersects(getBounds()); }
}
