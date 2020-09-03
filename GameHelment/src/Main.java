import Tools.Frame;
import Tools.Panel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //+14
        Panel _panel = new Panel(80,80,new ImageIcon(Main.class.getResource("/Images/Background.png")));
        Frame _frame = new Frame("Minecraft", 574, 574,new ImageIcon(Main.class.getResource("/Images/Background.png")),_panel);
    }
}
