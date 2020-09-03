package Program.Objects;

import Program.Tools.Panel;

import java.util.Timer;
import java.util.TimerTask;

public class Restart {

    public static void start(Panel _panel) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() { if(_panel.helmet.stun){
                    _panel.helmet.stun = false;
                } }
        };
        timer.schedule(task, 2000);
    }

    public static void shield(Panel _panel){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(_panel.helmet.shield){
                    _panel.helmet.shield = false;
                }
            }
        };
        timer.schedule(task, 5000);
    }

    public static void invers(Panel _panel){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(_panel.helmet.invers){
                    _panel.helmet.invers = false;
                }
            }
        };
        timer.schedule(task, 3000);
    }

}
