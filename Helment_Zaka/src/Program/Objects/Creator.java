package Program.Objects;

import Program.Tools.Panel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Creator extends Thread {

    public enum Types{
        Killers, God, Shield, Demon, EvilGod
    }

    private Panel JPanel;

    private int x = 0;
    private int autonum = 0;

    public static ArrayList<ObjectsRandoms> obj = new ArrayList<>();

    //int [] colum = new int[]{80, 160, 240, 320, 400};
    ArrayList<Integer> colum = new ArrayList<>();

    public Creator (Panel panel) {
        this.JPanel = panel;
    }

    public void StartArray(){
        System.out.println(JPanel.getWidth());
        for(int a = JPanel.helmet.get_width(); a < JPanel.getWidth(); a += JPanel.helmet.get_width()){
            colum.add(a);
        }
    }

    @Override
    public void run(){
        while(JPanel.helmet.get_life() > 0) {
            int a=(int)Math.floor(Math.random() * (colum.size() - 1) + 0);
            switch (getRandomType()){
                case Killers:
                    obj.add(new Killers(autonum, JPanel, 80, 80, colum.get(a), new ImageIcon(getClass().getResource("/Images/Killer.png"))));
                    break;
                case God:
                    obj.add(new Gods(autonum, JPanel, 80, 80, colum.get(a),  new ImageIcon(getClass().getResource("/Images/Gods.png"))));
                    break;
                case Shield:
                    obj.add(new Shield(autonum, JPanel, 80, 80, colum.get(a),  new ImageIcon(getClass().getResource("/Images/Shield.png"))));
                    break;
                case Demon:
                    obj.add(new Demon(autonum, JPanel, 80, 80, colum.get(a),  new ImageIcon(getClass().getResource("/Images/Demon.png"))));
                    break;
                case EvilGod:
                    obj.add(new EvilGod(autonum, JPanel, 80, 80, colum.get(a),  new ImageIcon(getClass().getResource("/Images/EvilGod.png"))));
                    break;
            }
            obj.get(obj.size() - 1).start();
            System.out.println("Creando " + autonum);
            try {
                Thread.sleep(/*JPanel._d.Timer*/JPanel._d.TimerCreator);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            autonum++;
        }
    }

    public static void destroy(ObjectsRandoms o){
        obj.remove(o);
    }

    public static Types getRandomType() {
        Random random = new Random();
        return Types.values()[random.nextInt(Types.values().length)];
    }
}
