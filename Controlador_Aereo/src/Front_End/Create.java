package Front_End;

import Objects.Air_Controller;
import Objects.Airplane;
import Objects.Battle_Plane;
import Objects.Commercial_Plane;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Create {

    private String _brand = "";
    private String _enrollment = "";
    private String _model = "";
    private int _passengerCapacity = 0;
    private int _crew = 0;
    private String _origin = "";
    private String _destination = "";
    private int _autonomy = 0;

    private void Plane() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Brand: ");
        _brand = sc.next();

        do {

            System.out.println("Enrollment: ");
            _enrollment = sc.next();

        } while (Air_Controller.FindPlane(_enrollment) != null);

        System.out.println("Model: ");
        _model = sc.next();

        System.out.println("Passager Capacity: ");

        _passengerCapacity = hasnextInt();

        System.out.println("Crew: ");

        _crew = hasnextInt();
        _crew = CompareCrew(_crew, _passengerCapacity);

        System.out.println("Origin: ");
        _origin = sc.next();

        System.out.println("Destination: ");
        _destination = sc.next();

        System.out.println("Autonomy: ");

        _autonomy = hasnextInt();
    }

    public Commercial_Plane CreateCommercial() {
        Plane();
        return new Commercial_Plane(_brand, _enrollment, _model, Math.abs(_passengerCapacity), Math.abs(_crew), _origin, _destination, Math.abs(_autonomy));
    }

    public Battle_Plane CreateBattle() {
        int _resistance;
        int _numberMisils;


        Plane();

        System.out.println("Number Misils: ");

        _numberMisils = hasnextInt();

        System.out.println("Resistance: ");

        _resistance = hasnextInt();

        return new Battle_Plane(_brand, _enrollment, _model, Math.abs(_passengerCapacity), Math.abs(_crew), _origin, _destination, Math.abs(_autonomy), Math.abs(_numberMisils), Math.abs(_resistance), false);
    }

    public Battle_Plane CreateBattleEnemy() {
        _brand = "Hitler";
        _enrollment = "88";
        _model = "Nazi";
        _passengerCapacity = 1;
        _crew = 1;
        _origin = "GER";
        _destination = "RUS";
        _autonomy = 800;

        int _resistance = 20;
        int _numberMisils = 3;

        return new Battle_Plane(_brand, _enrollment, _model, _passengerCapacity, _crew, _origin, _destination, _autonomy, _numberMisils, _resistance, true);
    }


    public int hasnextInt() {
        Scanner sc = new Scanner(System.in);

        int num = 0;

        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Introduce a number: ");
        }

        num = sc.nextInt();

        return num;
    }

    public double hasnextDouble() {
        Scanner sc = new Scanner(System.in);

        double num = 0;

        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print("Introduce a number: ");
        }

        num = sc.nextDouble();

        return num;
    }

    public int options_Menu() {
        Scanner sc = new Scanner(System.in);

        int num = 0;
        System.out.println("Options: ");

        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Introduce a number: ");
        }

        num = sc.nextInt();

        return num;
    }

    public int CompareCrew(int a, int b) {

        while (a > b) {
            System.out.println("The crew number must be less than the crew.");
            System.out.print("Introduce a number: ");
            a = hasnextInt();
        }

        return a;
    }

    public void SearchPlane(Air_Controller controller) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enrollment: ");
        String enrollment = sc.next();

        Airplane plane = controller.FindPlane(enrollment);

        if (plane == null) {
            System.out.println("No found.");
            Thread.sleep(1000);
        } else if (plane instanceof Battle_Plane) {
            Battle_Plane bplane = (Battle_Plane) plane;
            if(bplane.isEncrypt()){
                System.out.println("This plane is encrypted.");
                Thread.sleep(1000);
            }
            else {
                Strings.Clean();
                Menus.BattlePlaneMenu(bplane);
            }
        } else if (plane instanceof Commercial_Plane) {
            Commercial_Plane cplane = (Commercial_Plane) plane;
            Strings.Clean();
            Menus.CommercialPlaneMenu(cplane);
        }

    }

    public void TrainOption(Airplane plane) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Turn on or off train landing (Up or Down): ");
        String option = sc.nextLine();

        option.toLowerCase();

        while (option.equals("up") && option.equals("down")) {
            sc.next();
            System.out.print("Write a option: ");
            option = sc.nextLine();
        }

        if (option.equals("up")) {
            plane._trainLandingOn();
        } else {
            plane._trainLandingOff();
        }
    }


    public boolean MovePlane(Airplane plane) throws InterruptedException {

        boolean exit = false;
        String warning ;

        do {
            warning = "";

            int x = 0;
            int y = 0;
            int z = 0;
            double velocity = 0.0;

            System.out.print("X: ");
            x = hasnextInt();

            System.out.print("Y: ");
            y = hasnextInt();

            System.out.print("Z: ");
            z = hasnextInt();

            if (z == 0 || plane.get_coordinate().get_z() == 0) {
                velocity = Velocity(plane, z);
                warning = LandingPlane(x,y,z,plane);
                if(warning.toLowerCase().equals("no")){
                    exit = true;
                }
            }

            if(!exit &&  warning.equals("") &&  (x > 1000 || y > 1000 || z > 1000 || x < -1000 || y < -1000 || z < -1000)){
                Air_Controller.RemovePlane(plane);
                exit = true;
            }

            if (!exit &&  warning.equals("") && AutonomyPlane(plane, x, y, z)) {
                exit = true;
            }

            if (!exit && warning.equals("")) {
                warning = HitPlane(x, y, z, plane);
                if (warning.toLowerCase().equals("no")) {
                    exit = true;
                }
            }

            if (warning.equals("") && !exit) {
                plane.set_motor(true);
                plane.set_velocity(velocity);
                plane.Move(x, y, z);
                System.out.println("It has moved correctly");
            }

            if(z >= 500){
                plane.set_trainLanding(false);
            }
            else if(z < 500){
                plane.set_trainLanding(true);
            }

        } while (warning.toLowerCase().equals("yes"));

        return exit;
    }

    public String Warning() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You are about to die, do you want to correct the trajectory?");
        String a = sc.next();
        Strings.Clean();
        return a;
    }

    public int CalculateAutonomy(int x, int y, int z, Airplane plane) {
        int finish = 0;

        finish = (int) Math.floor(Math.sqrt(Math.pow(x - plane.get_coordinate().get_x(), 2) + Math.pow(y - plane.get_coordinate().get_y(), 2) + Math.pow(z - plane.get_coordinate().get_z(), 2)));

        return finish;
    }

    public double Velocity(Airplane plane, int z) {
        double velocity = 0;

        if (plane.get_coordinate().get_z() == 0) {
            System.out.println("Velocity: ");
            velocity = hasnextDouble();
            while (velocity < 250) {
                System.out.println("You need a speed of at least 250.");
                System.out.println("Velocity: ");
                velocity = hasnextDouble();
            }
        } else if (z == 0) {
            System.out.println("Velocity: ");
            velocity = hasnextDouble();

            while (velocity > 250) {
                System.out.println("You need a maximum speed of 250.");
                velocity = hasnextDouble();
            }
        }

        return velocity;
    }

    public boolean AutonomyPlane(Airplane plane, int x, int y, int z) throws InterruptedException {
        int autonomy = 0;
        boolean boom = false;

        autonomy = plane.get_autonomy() - CalculateAutonomy(x, y, z, plane);

        if (autonomy <= 0) {
            FrontEnd.Destruction();
            Air_Controller.RemovePlane(plane);
            boom = true;
        } else {
            plane.set_autonomy(autonomy);
        }

        return boom;
    }

    public String HitPlane(int x, int y, int z, Airplane plane) throws InterruptedException {

        String warning = "";

        Airplane plane1 = Air_Controller.CoordenatesPlanes(x, y, z);
        Airplane plane2 = Air_Controller.CoordenatesPlanesEnemy(x, y, z);

        if (plane1 != null && plane1 != plane) {
            if (Warning().toLowerCase().equals("no")) {
                Air_Controller.RemovePlane(plane);
                Air_Controller.RemovePlane(plane1);
                FrontEnd.DestructionPlanes(plane, plane1);
                warning = "no";
            } else {
                warning = "yes";
            }
        } else if (plane2 != null) {
            if (Warning().toLowerCase().equals("no")) {
                Air_Controller.RemovePlane(plane);
                Air_Controller.RemovePlaneEnemy(plane2);
                FrontEnd.DestructionPlanes(plane, plane2);
                warning = "no";
            } else {
                warning = "yes";
            }
        }


        return warning;
    }

    public String LandingPlane(int x, int y, int z, Airplane plane) throws InterruptedException {

        String a = "";
        Airplane plane1 = Air_Controller.CheckTrack();

        if((z == 0 && x !=100) || (z == 0 && x == 100 && (y>120 || y < 100))){
            System.out.println("You can't landing here.");
            if(Warning().toLowerCase().equals("no")){
                FrontEnd.Destruction();
                Air_Controller.RemovePlane(plane);
                a = "no";
            }
            else{
                a = "yes";
            }
        }
        else if ((x == 100 && (y <= 120 || y >= 100) && z == 0) && plane1 != null && plane1 != plane) {
           a = Warning();
           if(a.toLowerCase().equals("no")){
               Air_Controller.RemovePlane(plane);
               Air_Controller.RemovePlane(plane1);
               FrontEnd.DestructionPlanes(plane,plane1);
           }
           else{
               a = "yes";
           }
        }

        return a;
    }


    public void ShootPlane(Battle_Plane airplane) throws InterruptedException {
        int a = 0;

        ArrayList<Battle_Plane> Enemys = new ArrayList<>();

        Enemys = Air_Controller.SearchEnemy(airplane);

        if(Enemys.size() != 0) {
            FrontEnd.ShowEnemys(Enemys);

            do{
                System.out.println("Choose one enemy: ");
                a = hasnextInt();
            } while(a >= Enemys.size());

            if(airplane.getMissils().size() == 0){
                System.out.println("You don't have missils.");
                Thread.sleep(1000);
            }
            else {
                Enemys.get(a).set_resistance(Enemys.get(a).get_resistance() - airplane.getMissils().get(airplane.getMissils().size() - 1).get_damage());
                airplane.getMissils().remove(airplane.getMissils().get(airplane.getMissils().size() - 1));
                System.out.println("Pointing...");
                Thread.sleep(1000);
                System.out.println("Shooting...");
                Thread.sleep(1000);
                System.out.println("Enemy touched!!!");
                Thread.sleep(1000);
                if(Enemys.get(a).get_resistance() <= 0){
                    Air_Controller.RemovePlaneEnemy(Enemys.get(a));
                    System.out.println("Enemy dead!!!");
                    Thread.sleep(1000);
                }
            }
        }
        else{
            System.out.println("Don't find enemys.");
            Thread.sleep(1000);
        }
    }
    
    
    public void SelectPlaneEncrypt (boolean encrypt) throws IOException, InterruptedException {

        int a = 0;
        int num = 0;
        String url = "";
        String [] pro = new String[4];

        ArrayList<Battle_Plane> planes = Air_Controller.SearchBattlePlane(encrypt);

        if(planes.size() != 0){

            FrontEnd.ShowEnemys(planes);

            do{
                System.out.println("Choose one plane: ");
                a = hasnextInt();
            } while(a >= planes.size());

            CreateFolder();

            url = "Enrollment/" + planes.get(a).get_enrollment() + ".txt";
            File file = new File(url);

            if(!encrypt){
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                planes.get(a).setEncrypt(true);
                planes.get(a).set_brand(Encrypt.encriptar(planes.get(a).get_brand()));
                planes.get(a).set_model(Encrypt.encriptar(planes.get(a).get_model()));
                planes.get(a).set_origin(Encrypt.encriptar(planes.get(a).get_origin()));
                planes.get(a).set_destination(Encrypt.encriptar(planes.get(a).get_destination()));

                bw.write(planes.get(a).get_brand() + "\n" +
                    planes.get(a).get_model() + "\n" +
                    planes.get(a).get_origin() + "\n" +
                    planes.get(a).get_destination());

                System.out.println("Encrypting...");
                Thread.sleep(1000);

                bw.close();

                System.out.println("Completed!!!");
                Thread.sleep(1000);

            } else{

                if(file.exists()) {

                    String cad = "";
                    boolean corect = false;

                    BufferedReader b = new BufferedReader(new FileReader(file));

                    while ((cad = b.readLine()) != null) {
                        pro[num] = cad;
                        if (num < pro.length - 1) {
                            num++;
                        }
                    }

                    if (!pro[0].equals(planes.get(a).get_brand())) {
                        corect = true;
                    }
                    if (!pro[1].equals(planes.get(a).get_model())) {
                        corect = true;
                    }
                    if (!pro[2].equals(planes.get(a).get_origin())) {
                        corect = true;
                    }
                    if (!pro[3].equals(planes.get(a).get_destination())) {
                        corect = true;
                    }

                    if (!corect) {
                        planes.get(a).setEncrypt(false);
                        planes.get(a).set_brand(Encrypt.desencriptar(planes.get(a).get_brand()));
                        planes.get(a).set_model(Encrypt.desencriptar(planes.get(a).get_model()));
                        planes.get(a).set_origin(Encrypt.desencriptar(planes.get(a).get_origin()));
                        planes.get(a).set_destination(Encrypt.desencriptar(planes.get(a).get_destination()));

                        System.out.println("Desencrypting...");
                        Thread.sleep(1000);
                        b.close();
                        System.out.println("Completed!!!");
                        Thread.sleep(1000);

                    } else {
                        System.out.println("Happy hacking!!!");
                        Thread.sleep(1000);
                    }
                }

               else{
                    System.out.println("The file not found.");
                    Thread.sleep(1000);
                }
            }
        }
        else{
            System.out.println("Don't find planes.");
            Thread.sleep(1000);
        }
    }

    public void CreateFolder(){
        String url = "Enrollment";
        File file = new File(url);

        if(!file.exists()) {
            file.mkdir();
        }
    }
}
