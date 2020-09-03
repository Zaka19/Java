package Program.Objects;

import Program.Tools.Music;
import Program.Tools.Panel;

import javax.swing.*;

public class Shield extends ObjectsRandoms {
    Panel _panel;
    Music m = new Music();
    public Shield(int name, Panel panel, int width, int height, int x, ImageIcon img) {
        super(name, panel, width, height, x, img);
        this._panel = panel;
    }

    @Override
    protected void Method() {
        m.StartMusic("/Music/estefania.wav").start();
        _panel.helmet.shield = true;
        Restart.shield(_panel);
    }
}
