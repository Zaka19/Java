package Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    private Bar _bar;

    public Teclado(Bar bar) {
        this._bar = bar;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (KeyEvent.getKeyText(keyEvent.getKeyCode())){
            case "A":
                _bar.setxA(-1);
                break;
            case "D":
                _bar.setxA(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (KeyEvent.getKeyText(keyEvent.getKeyCode())){
            case "A":
                _bar.setxA(0);
            case "D":
                _bar.setxA(0);
                break;
        }
    }
}
