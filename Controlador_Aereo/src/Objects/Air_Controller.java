package Objects;

import Front_End.Create;
import Front_End.FrontEnd;
import Front_End.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class Air_Controller {
    static Create create = new Create();

    private static ArrayList<Airplane> Space = new ArrayList<>();
    private static ArrayList<Airplane> SpaceEnemy = new ArrayList<>();
    private int MaxPlanes = 10;

    // x | y = 0 && x | y = 100 && x | y = -100
    private int[] SpaceView = new int[]{0, 1000, -1000};

    public void AddPlane(int a) throws InterruptedException {
        switch (a) {
            case 3:
                SpaceEnemy.add(create.CreateBattleEnemy());
                Strings.Clean();
                System.out.println("Created successfully!!!");
                Thread.sleep(1000);
                Strings.Clean();
                break;
            default:
                Metodo(a);
        }
    }

    public void Metodo(int option) throws InterruptedException {
        if (Space.size() <= MaxPlanes) {
            if (CheckTrack() == null) {
                switch (option) {
                    case 1:
                        Strings.Clean();
                        Space.add(create.CreateCommercial());
                        Strings.Clean();
                        System.out.println("Created successfully!!!");
                        Thread.sleep(1000);
                        Strings.Clean();
                        break;
                    case 2:
                        Strings.Clean();
                        Space.add(create.CreateBattle());
                        Strings.Clean();
                        System.out.println("Created successfully!!!");
                        Thread.sleep(1000);
                        Strings.Clean();
                        break;
                }
            }
            else {
                Strings.Clean();
                System.out.println("You can not create a plane because the track is complete.");
                Thread.sleep(1000);
                Strings.Clean();
            }
        }
        else {
            Strings.Clean();
            System.out.println("You can not create planes because the airspace is complete.");
            Thread.sleep(1000);
            Strings.Clean();
        }
    }

    public void Show() {
        Scanner sc = new Scanner(System.in);
        FrontEnd.Show(Space,SpaceEnemy);
        String a = sc.nextLine();
    }

    public static Airplane FindPlane(String _enrollment){
        Airplane plane = null;
        for(Airplane Plane : Space) {
            if(_enrollment.toLowerCase().equals(Plane.get_enrollment().toLowerCase())){
                plane = Plane;
            }
        }
        
        return plane;
    }

    public static Airplane CheckTrack(){
        Airplane x = null;

        for(Airplane Plane : Space){
            if(Plane.get_coordinate().get_x() == 100 && (Plane.get_coordinate().get_y() <= 120 || Plane.get_coordinate().get_y() >= 100) && Plane.get_coordinate().get_z() == 0){
                x = Plane;
            }
        }
        return x;
    }

    public static Airplane CoordenatesPlanes(int x, int y, int z){
        Airplane plane = null;

        for(Airplane Plane : Space) {
            if (Plane.get_coordinate().get_z() == z && Plane.get_coordinate().get_y() == y && Plane.get_coordinate().get_x() == x) {
                plane = Plane;
            }
        }

        return plane;
    }

    public static Airplane CoordenatesPlanesEnemy(int x, int y, int z){
        Airplane plane = null;

        for(Airplane Plane : SpaceEnemy) {
            if (Plane.get_coordinate().get_z() == z && Plane.get_coordinate().get_y() == y && Plane.get_coordinate().get_x() == x) {
                plane = Plane;
            }
        }

        return plane;
    }

    public static void RemovePlane (Airplane plane){
        Space.remove(plane);
    }

    public static void RemovePlaneEnemy (Airplane plane){
        SpaceEnemy.remove(plane);
    }


    public static ArrayList<Battle_Plane> SearchEnemy (Battle_Plane airplane){
        ArrayList<Battle_Plane> Enemys = new ArrayList<>();

        for(Airplane plane : SpaceEnemy){
            if(create.CalculateAutonomy(plane.get_coordinate().get_x(),plane.get_coordinate().get_y(),plane.get_coordinate().get_z(),airplane) <= airplane.get_maximumDistance()){
                Enemys.add((Battle_Plane) plane);
            }
        }

        return Enemys;
    }

    public static void Warnings(){
        boolean x = false;
        for(int a = 0;a < Space.size() ;a++){
            for(int b = a; b < Space.size() ;b++){
                if(Space.get(a) != Space.get(b)){
                    if((Math.abs(Space.get(a).get_coordinate().get_x() - Space.get(b).get_coordinate().get_x()) <= 200 && Math.abs(Space.get(a).get_coordinate().get_y() - Space.get(b).get_coordinate().get_y()) <= 200 && Space.get(a).get_coordinate().get_z() == Space.get(b).get_coordinate().get_z()) || (Math.abs(Space.get(a).get_coordinate().get_z() - Space.get(b).get_coordinate().get_z()) <= 200 && Space.get(a).get_coordinate().get_x() == Space.get(b).get_coordinate().get_x() && Space.get(a).get_coordinate().get_y() == Space.get(b).get_coordinate().get_y())){
                        System.out.println("The plane " + Space.get(a).get_model() + " and " + Space.get(b).get_model() + " they are in crashing.");
                        System.out.println(Space.get(a).get_model() + " " + Space.get(a).get_coordinate() + " " + Space.get(b).get_model() + " " + Space.get(b).get_coordinate());
                        x = true;
                    }
                }
            }
        }

        if(!x){
            System.out.println("Everything under control.");
        }
    }


    public static ArrayList<Battle_Plane> SearchBattlePlane (boolean encrypt){

        ArrayList<Battle_Plane> bplane = new ArrayList<>();

        for(Airplane plane : Space){
            if( plane instanceof Battle_Plane){
                Battle_Plane battle = (Battle_Plane) plane;
                if(battle.isEncrypt() == encrypt) {
                    bplane.add((Battle_Plane) plane);
                }
            }
        }

        return bplane;
    }
}
