package Program.Objects;

import Program.Tools.Music;
import Program.Tools.Panel;

import javax.swing.*;

public class Demon extends ObjectsRandoms {
    Panel _panel;
    Music m = new Music();
    public Demon(int name, Panel panel, int width, int height, int x, ImageIcon img) {
        super(name, panel, width, height, x, img);
        this._panel = panel;
    }

    @Override
    protected void Method() {
        m.StartMusic("/Music/dead.wav").start();
        _panel.helmet.set_life(_panel.helmet.get_life()-2);
        _panel.helmet.setX(_panel.helmet.get_width());
    }
}
