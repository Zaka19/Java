package Program.Tools;

public class Game {
    public static void Start() {
        try {
            Frame fr = new Frame("Helmet", "Helmet.jpg", 654, 674);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
