package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class JPanel_Content extends JPanel{

     private ImageIcon _image;
     private Ball _ball = new Ball(this,8,10);
     ArrayList<Break> _breaks = new ArrayList<Break>();
     //Break _break = new Break(this,50,10,100,50);
     Bar _bar;

    public JPanel_Content(ImageIcon image, int width, int height){
        this._image = image;
        this._bar = new Bar(this,width,height);
        //_breaks.add(new Break(this, 200, 200, 100, 100,15284));

       for(int a = 100; a < 300; a+=60){
            for(int b = 100; b < 300; b+=60) {
                _breaks.add(new Break(this, 50, 10, a, b,3));
            }
        }
        /*Teclado _teclado = new Teclado(_bar);
        addKeyListener(_teclado);
        setFocusable(true);*/
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                _bar.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                _bar.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    public void move(){
        _bar.Move();
        _ball.MoveBall();
    }

    public void Win(){
        JOptionPane.showMessageDialog(this, "You win!!!", "WIN", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D _graphics2d = (Graphics2D) g;
        _graphics2d.drawImage(_image.getImage(),0,0,getWidth(),getHeight(),this);
        _graphics2d.setColor(Color.BLUE);
        _graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        _bar.paint(_graphics2d);
        _ball.paint(_graphics2d);
        _graphics2d.drawString(String.valueOf(_ball.speed),10,10);

        int b = 20;

        for(int a = 0; a < _breaks.size();a++){
            if(_breaks.get(a).get_life() == 2){
                _graphics2d.setColor(Color.YELLOW);
            }
            else if(_breaks.get(a).get_life() == 1){
                _graphics2d.setColor(Color.RED);
            }
            else{
                _graphics2d.setColor(Color.BLUE);
            }
                _breaks.get(a).paint(_graphics2d);
                //_graphics2d.drawString( a + ": " + String.valueOf(_breaks.get(a).get_life()),_breaks.get(a).get_y() + 10,_breaks.get(a).get_x());
        }
    }

 /*   @Override
    public void paint(Graphics _graphics){
        //super.paint(_graphics);
        Graphics2D _graphics2d = (Graphics2D) _graphics;
        _graphics2d.drawImage(_image.getImage(),0,0,getWidth(),getHeight(),this);
        _graphics2d.setColor(Color.BLUE);
        _graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        _graphics2d.fillOval(x, y, 30, 30);
        /*_graphics2d.draw3DRect (25, 10, 50, 75, true);
        _graphics2d.draw3DRect (25, 110, 50, 75, false);
        _graphics2d.fill3DRect (100, 10, 50, 75, true);
        _graphics2d.fill3DRect (100, 110, 50, 75, false);
        _graphics2d.fillArc(200, 450, 50, 50, 50, 50);
        _graphics2d.drawString("THIS GAME",100,100);
        for(int a = 10; a < _maxLenght;a += 50) {
            for(int b = 10; b < _maxLenght; b += 50) {
                _graphics2d.fillRect(a,b,_width,_height);
            }
        }
        _graphics2d.fill3DRect(50,50,50,50,true);
    }
  */
}
