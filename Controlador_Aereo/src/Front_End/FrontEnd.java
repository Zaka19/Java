package Front_End;

import Objects.Air_Controller;
import Objects.Airplane;
import Objects.Battle_Plane;

import java.util.ArrayList;
import java.util.jar.JarOutputStream;

public class FrontEnd {
    public static void TextMenuControlle(){
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█                    COMMANDS AIR CONTROLLER                     █");
        System.out.println("█                                                                █");
        System.out.println("█                   1. ADD PLANE TO THE AIRSPACE                 █");
        System.out.println("█                   2. MANAGE AN AIRSPACE PLANE                  █");
        System.out.println("█                   3. SHOW CURRENT AIRSPACE                     █");
        System.out.println("█                   4. ENCRYPT COMBAT AIRCRAFT                   █");
        System.out.println("█                   5. DECIPHER COMBAT AIRCRAFT                  █");
        System.out.println("█                   0.         EXIT                              █");
        System.out.println("█                                                                █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public static void CreateAirPlane(){
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█                    COMMANDS AIR CONTROLLER                     █");
        System.out.println("█                                                                █");
        System.out.println("█                   1. ADD COMERCIAL PLANE                       █");
        System.out.println("█                   2. ADD BATTLE PLANE                          █");
        System.out.println("█                   3. ADD BATTLE PLANE ENEMY                    █");
        System.out.println("█                   0.       EXIT                                █");
        System.out.println("█                                                                █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public static void TextMenuPlaneCommercial(){
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█                    COMMANDS COMMERCIAL PLANE                   █");
        System.out.println("█                                                                █");
        System.out.println("█                   1. IGNITE ENGINE                             █");
        System.out.println("█                   2. TURN OFF ENGINE                           █");
        System.out.println("█                   3. SHOW STATS                                █");
        System.out.println("█                   4. UP / DOWN LANDING TRAIN                   █");
        System.out.println("█                   5. GET MOVING                                █");
        System.out.println("█                   0. FINISH THE SELECTED AIRCRAFT OPERATION    █");
        System.out.println("█                                                                █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public static void TextMenuPlaneBattle(){
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█                     COMMANDS BATTLE PLANE                      █");
        System.out.println("█                                                                █");
        System.out.println("█                   1. IGNITE ENGINE                             █");
        System.out.println("█                   2. TURN OFF ENGINE                           █");
        System.out.println("█                   3. SHOW STATS                                █");
        System.out.println("█                   4. UP / DOWN LANDING TRAIN                   █");
        System.out.println("█                   5. GET MOVING                                █");
        System.out.println("█                   6. SHOOT PLANE                               █");
        System.out.println("█                   0. FINISH THE SELECTED AIRCRAFT OPERATION    █");
        System.out.println("█                                                                █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
    }

    public static void Show(ArrayList<Airplane> Space, ArrayList<Airplane> SpaceEnemy){
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█  Brand     Enrollment     Model     Passenger Capacity     Crew     Origin     Destination     Coordenates     Autonomy     Course     Resistance     Enemy     Number Missils  █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        for(Airplane Plane : Space){
            System.out.println(Plane.toString());
        }

        System.out.println("");
        System.out.println("Enemy:");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█  Brand     Enrollment     Model     Passenger Capacity     Crew     Origin     Destination     Coordenates     Autonomy     Course     Resistance     Enemy     Number Missils  █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        for(Airplane Plane : SpaceEnemy){
            System.out.println(Plane.toString());
        }
        System.out.println();
        System.out.println("WARNINGS:");
        Air_Controller.Warnings();
    }

    public static void DestructionPlanes(Airplane plane,Airplane plane1) throws InterruptedException {
        System.out.println(" ******                                 ** ** **");
        System.out.println("/*////**                               /**/**/**");
        System.out.println("/*   /**   ******   ******  ********** /**/**/**");
        System.out.println("/******   **////** **////**//**//**//**/**/**/**");
        System.out.println("/*//// **/**   /**/**   /** /** /** /**/**/**/**");
        System.out.println("/*    /**/**   /**/**   /** /** /** /**// // // ");
        System.out.println("/******* //****** //******  *** /** /** ** ** **");
        System.out.println("///////   //////   //////  ///  //  // // // // ");

        Thread.sleep(1000);

        System.out.println("The plane " + plane.get_model() + " - " + plane.get_enrollment() +
                "            ____\n" +
                "  |        | ___//          /~~~|\n" +
                " _:_______|/'(..)`//_______/  | |\n" +
                "<_|``````  //__~~__/  USAF ___|_|\n" +
                "  ://_____(=========,(*),--//__|_/\n" +
                "  |       //       /---'\n" +
                "           | (*) /\n" +
                "           |____/"
        );

        Thread.sleep(1000);

        System.out.println("you have collided with "  + plane1.get_model() + " - " + plane1.get_enrollment() +
                "            ____\n" +
                "  |        | ___//          /~~~|\n" +
                " _:_______|/'(..)`//_______/  | |\n" +
                "<_|``````  //__~~__/  USAF ___|_|\n" +
                "  ://_____(=========,(*),--//__|_/\n" +
                "  |       //       /---'\n" +
                "           | (*) /\n" +
                "           |____/");

        Thread.sleep(1000);
    }

    public static void Destruction() throws InterruptedException {
        System.out.println(" ******                                 ** ** **");
        System.out.println("/*////**                               /**/**/**");
        System.out.println("/*   /**   ******   ******  ********** /**/**/**");
        System.out.println("/******   **////** **////**//**//**//**/**/**/**");
        System.out.println("/*//// **/**   /**/**   /** /** /** /**/**/**/**");
        System.out.println("/*    /**/**   /**/**   /** /** /** /**// // // ");
        System.out.println("/******* //****** //******  *** /** /** ** ** **");
        System.out.println("///////   //////   //////  ///  //  // // // // ");
        System.out.println("");
        System.out.println("You have run out of fuel and you have died, watch your autonomy!!! OR you don't landing in track");
        Thread.sleep(1000);
    }

    public static void TakeOffPlane(Airplane plane) throws InterruptedException {
        System.out.println("Starting engines ...");
        Thread.sleep(1000);
        System.out.println("Preparing take-off mechanisms ...");
        Thread.sleep(1000);
        System.out.println("Take off successfully !!!");
        Thread.sleep(1000);
    }

    public static void ShowEnemys (ArrayList<Battle_Plane> enemys){
        int a = 0;
        System.out.println("");
        System.out.println("Enemy:");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("█  Brand     Enrollment     Model     Passenger Capacity     Crew     Origin     Destination     Coordenates     Autonomy     Course     Resistance     Enemy     Number Missils  █");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        for(Battle_Plane Plane : enemys){
            System.out.print(a + " - ");
            System.out.println(Plane.toString());
            a++;
        }
    }
}
