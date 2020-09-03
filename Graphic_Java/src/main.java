import Graphics.*;

import javax.swing.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
        JPanel_Content _panel = new JPanel_Content(new ImageIcon("cerezos.gif"),100,10);
        JFrame_Ventana _jf = new JFrame_Ventana();
        _jf.Start("My Window", 500, 500,"F.jpg",_panel);
    }
}
