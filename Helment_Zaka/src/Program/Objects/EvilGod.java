package Program.Objects;

import Program.Tools.Music;
import Program.Tools.Panel;

import javax.swing.*;

public class EvilGod extends ObjectsRandoms {
    Panel _panel;
    Music m = new Music();

    public EvilGod(int name, Panel panel, int width, int height, int x, ImageIcon img) {
        super(name, panel, width, height, x, img);
        this._panel = panel;
    }

    @Override
    protected void Method() {
        m.StartMusic("/Music/dead.wav").start();
        _panel.helmet.set_life(_panel.helmet.get_life()-1);
        _panel.helmet.invers = true;
        Restart.invers(_panel);
    }
}
