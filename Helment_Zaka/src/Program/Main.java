package Program;

import Program.Tools.EndGame;
import Program.Tools.Frame;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Frame fr = new Frame("Helmet", "Helmet.jpg", 654, 674);

        EndGame _end = new EndGame();
        _end.introduceName(fr._panel.helmet.getPoints(), fr);
    }

}