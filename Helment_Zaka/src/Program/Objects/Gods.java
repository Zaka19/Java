package Program.Objects;

import Program.Tools.Music;
import Program.Tools.Panel;

import javax.swing.*;

public class Gods extends ObjectsRandoms {
    Panel panel;
    Music m = new Music();
    public Gods(int name, Panel panel, int width, int height, int x, ImageIcon img) {
        super(name, panel, width, height, x, img);
        this.panel = panel;
    }

    @Override
    protected void Method() {
        m.StartMusic("/Music/eat.wav").start();
        panel.helmet.set_life(panel.helmet.get_life()+1);
    }
}
