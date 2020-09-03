package Front_End;

import Objects.Air_Controller;
import Objects.Battle_Plane;
import Objects.Commercial_Plane;

import java.io.IOException;

public class Menus {

    static Create c = new Create();

    public static void AirControllerMenu(Air_Controller controller) throws InterruptedException, IOException {
        int option;
        do {
            FrontEnd.TextMenuControlle();
            System.out.print("Option: ");
            option = c.hasnextInt();
            switch (option) {
                case 1:
                    Strings.Clean();
                    AirPlaneMenu(controller);
                    break;
                case 2:
                    Strings.Clean();
                    c.SearchPlane(controller);
                    break;
                case 3:
                    Strings.Clean();
                    controller.Show();
                    break;
                case 4:
                    c.SelectPlaneEncrypt(false);
                    Thread.sleep(1000);
                    break;
                case 5:
                    c.SelectPlaneEncrypt(true);
                    Thread.sleep(1000);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Choose one option.");
                    Thread.sleep(1000);
            }
            Strings.Clean();
        } while(option != 0);
    }

    public static void AirPlaneMenu(Air_Controller controller) throws InterruptedException {
        int option;

        do {
            FrontEnd.CreateAirPlane();
            System.out.print("Option: ");
            option = c.hasnextInt();
            switch (option) {
                case 1:
                case 2:
                case 3:
                    controller.AddPlane(option);
                    break;
                case 0:
                    break;
                default:
                    Strings.Clean();
                    System.out.println("Choose one option.");
                    Thread.sleep(1000);
                    Strings.Clean();
            }
        } while(option != 0);
    }

    public static void BattlePlaneMenu(Battle_Plane plane) throws InterruptedException {
        int option;

        do {
            FrontEnd.TextMenuPlaneBattle();
            option = c.options_Menu();

            switch(option){
                case 1:
                    Strings.Clean();
                    plane.igntieEnginee();
                    Thread.sleep(1000);
                    break;
                case 2:
                    Strings.Clean();
                    plane.turnOffEnginee();
                    Thread.sleep(1000);
                    break;
                case 3:
                    Strings.Clean();
                    System.out.println(plane.toString());
                    Thread.sleep(3000);
                    break;
                case 4:
                    Strings.Clean();
                    c.TrainOption(plane);
                    break;
                case 5:
                    Strings.Clean();
                    if(c.MovePlane(plane)){
                        option = 0;
                    }
                    break;
                case 6:
                    Strings.Clean();
                    c.ShootPlane(plane);
                    break;
                case 0:
                    break;
                default:
                    Strings.Clean();
                    System.out.println("Choose one option.");
                    Thread.sleep(1000);
                    Strings.Clean();
            }
            Strings.Clean();
        } while(option != 0);
    }

    public static void CommercialPlaneMenu(Commercial_Plane plane) throws InterruptedException {
        int option;

        do {
            System.out.println("Enrollment: " + plane.get_enrollment() + " " + "Motor: " + plane.get_motor() + " " + "Train landing: " + plane.get_trainLanding());
            FrontEnd.TextMenuPlaneCommercial();
            option = c.options_Menu();

            switch(option){
                case 1:
                    Strings.Clean();
                    plane.igntieEnginee();
                    Thread.sleep(1000);
                    break;
                case 2:
                    Strings.Clean();
                    plane.turnOffEnginee();
                    Thread.sleep(1000);
                    break;
                case 3:
                    Strings.Clean();
                    System.out.println(plane.toString());
                    Thread.sleep(3000);
                    break;
                case 4:
                    Strings.Clean();
                    c.TrainOption(plane);
                    break;
                case 5:
                    Strings.Clean();
                    if(c.MovePlane(plane)){
                        option = 0;
                    }
                    break;
                case 0:
                    break;
                default:
                    Strings.Clean();
                    System.out.println("Choose one option.");
                    Thread.sleep(1000);
                    Strings.Clean();
            }
            Strings.Clean();
        } while(option != 0);
    }
}
