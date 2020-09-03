package Program.Objects;

import Program.Tools.Panel;

import java.util.Timer;
import java.util.TimerTask;

public class Difficulty {
    int Timer = 500;
    int TimerCreator = 1200;
    boolean a = false;
    public void start(Panel _panel){
        Timer _t = new Timer();
        TimerTask _task = new TimerTask() {
            @Override
            public void run() {
                if(_panel.helmet.points % 100 == 0 && _panel.helmet.points > 0 && !a ){
                    if(Timer != 200 && TimerCreator != 500) {
                        Timer = Timer - 100;
                        TimerCreator = TimerCreator - 200;
                        a = true;
                    }
                }
                else if(_panel.helmet.points % 100 != 0)
                    a = false;
                }
        };
        _t.schedule(_task, 0, 10);
    }
}
