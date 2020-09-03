package Objects;

import Front_End.Menus;
import Objects.Air_Controller;

import java.io.IOException;

public class ControlTower {
    Air_Controller controller = new Air_Controller();

    public void Start() throws InterruptedException, IOException {
        Menus.AirControllerMenu(controller);
    }
}
