package Program.Tools;

import Program.Objects.*;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel{

    public Helmet helmet;
    public int TimerVelocity = 1000;
    public int TimerCreator = 1200;
    public Doors _door;
    public Doors _doorStart;
    public Difficulty _d = new Difficulty();
    ImageIcon img;
    Creator _cr;
    public boolean _finish = false;
    public boolean _start = false;
    JButton button;
    Clip _clip;
    Music m = new Music();

    public Panel( int width, int height, ImageIcon img){
        this.helmet = new Helmet(this, width, height, new ImageIcon(getClass().getResource("/Images/Helmet.png")));
        this._door = new Doors(25, this, 79,150, true);
        this._doorStart = new Doors(26, this, 79,150, false);
        this.img = img;
        _clip = m.StartMusic("/Music/epic.wav");
        _clip.start();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(280));

        button = new JButton("Start");
        button.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        button.setSize(500,200);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                _clip.stop();
                start();
                on();
                _clip = m.StartMusic("/Music/launchermusic.wav");
                _clip.loop(10);
            }
        });
        add(button);

        add(Box.createVerticalGlue());
        setBackground(Color.GREEN);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                helmet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        });
        setFocusable(true);
    }

    public void start(){
        _start = true;
    }

    public void on(){
        _d.start(Panel.this);
        _cr = new Creator(this);
        _cr.StartArray();
        _cr.start();
        _door.start();
    }

    public void move() throws InterruptedException {
        helmet.Move();
    }

    public void life(){
       if(helmet.get_life() <= 0){
           _clip.stop();
           _finish = true;
           JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
       }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(_start) {
            Graphics2D _graphics2d = (Graphics2D) g;
            button.setVisible(false);
            _graphics2d.setFont(new Font("Verdana", Font.BOLD, 20));
            _graphics2d.setColor(Color.YELLOW);
            _graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            _graphics2d.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
            _graphics2d.drawString("Points: " + helmet.getPoints(),50,50);
            _graphics2d.drawString("Life: " + helmet.get_life(),50,25);
            helmet.paint(_graphics2d);
            _door.paint(_graphics2d);
            _doorStart.paint(_graphics2d);

            for (int a = 0; a < Creator.obj.size(); a++) {
                Creator.obj.get(a).paint(_graphics2d);
            }
        }
        else{
            button.setVisible(true);
            g.setColor(Color.RED);
            g.setFont(new Font("Verdana", Font.BOLD, 50));
            g.drawString("MINECRAFT",150,100);
            g.drawString("EDITION H",160,200);
            g.drawImage(new ImageIcon(getClass().getResource("/Images/minecraft_icon.gif")).getImage(),70,330,500,300,this);
        }
    }
}
