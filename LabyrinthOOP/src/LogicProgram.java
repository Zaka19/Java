import Objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicProgram {

    FrontEnd fe = new FrontEnd();

    List<String> Movements = new ArrayList<String>();

    public Labyrinth GenerateExit(Exit _exit, Labyrinth lab){

        int x = (int) (Math.random() * lab.get_xSize());
        int y = (int) (Math.random() * lab.get_ySize());

        _exit.set_x(x);
        _exit.set_y(y);

        lab.get_LabyrinthBackEnd()[_exit.get_x()][_exit.get_y()] = _exit.get_body();

        return lab;
    }

    public Labyrinth MovementHeroe(Labyrinth lab,Hero hero) {
        Scanner sc = new Scanner(System.in);

        String Movement = null;
        System.out.println("Adalt(W) | Abaix(S) | Esquerra(A) | Dreta(D) | Ajuda(H)");
        Movement = sc.next();
        Movement.toUpperCase();

        if(!CheckMovement(Movement) && !CheckWalls(Movement,lab,hero) && hero.isPick() == false){
            /*
            CheckBombs(Movement);
            CheckPick(Movement);
            */
            lab = Movement(Movement,lab,hero);
        }

        /*
        else if(!CheckMovement(Movement) && HavePick == true && !checkWallsWithPicks(Movement)){
            CheckBombs(Movement);
            Movement(Movement);
        }
        */

        return lab;
    }

    public boolean CheckMovement(String Movement) {
        boolean x = false;

        if(!Movement.equals("W") && !Movement.equals("A") && !Movement.equals("S") && !Movement.equals("D") && !Movement.equals("H")){
            x = true;
        }
        return x;
    }

    public boolean CheckWalls(String Movement,Labyrinth lab,Hero hero) {
        boolean x = false;
        if(Movement.equals("W") && hero.get_xCoordinade() != 0) {
            if (lab.get_LabyrinthBackEnd()[hero.get_xCoordinade() - 1][hero.get_yCoordinade()] == fe.W) {
                x = true;
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade() - 1][hero.get_yCoordinade()] = fe.W;
            }
        }
        else if (Movement.equals("A") && hero.get_yCoordinade() != 0) {
            if (lab.get_LabyrinthBackEnd()[hero.get_xCoordinade()][hero.get_yCoordinade() - 1] == fe.W) {
                x = true;
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade() - 1] = fe.W;
            }
        }
        else if(Movement.equals("S") && hero.get_xCoordinade() != lab.get_xSize() - 1){
            if (lab.get_LabyrinthBackEnd()[hero.get_xCoordinade() + 1][hero.get_yCoordinade()] == fe.W) {
                x = true;
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade() + 1][hero.get_yCoordinade()] = fe.W;
             }
        }
        else if (Movement.equals("D") && hero.get_yCoordinade() != lab.get_ySize() - 1){
             if (lab.get_LabyrinthBackEnd()[hero.get_xCoordinade()][hero.get_yCoordinade() + 1] == fe.W) {
                x = true;
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade() + 1] = fe.W;
            }
        }
        else{
            x=true;
        }
        return x;
    }

    public Labyrinth Movement(String Movement,Labyrinth lab,Hero hero){

        switch(Movement){
            case "W":
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade() - 1][hero.get_yCoordinade()] = lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()];
                    if (Movements.size() == 0) {
                        lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                        lab.get_LabyrinthBackEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                    } else {
                        lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = '+';
                    }
                    //hero.set_xCoordinade(hero.get_xCoordinade() - 1);
                    hero.w();
                    Movements.add(Movement);
                break;
            case "A":
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade() - 1] = lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()];
                if(Movements.size() == 0){
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                    lab.get_LabyrinthBackEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                }
                else{
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = '+';
                }
                //hero.set_yCoordinade(hero.get_yCoordinade() - 1);
                hero.a();
                Movements.add(Movement);
                break;
            case "S":
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade() + 1][hero.get_yCoordinade()] = lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()];
                if(Movements.size() == 0){
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                    lab.get_LabyrinthBackEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                }
                else{
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = '+';
                }
                //hero.set_xCoordinade(hero.get_xCoordinade() + 1);
                hero.s();
                Movements.add(Movement);
                break;
            case "D":
                lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade() + 1] = lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()];
                if(Movements.size() == 0){
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                    lab.get_LabyrinthBackEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = fe.W;
                }
                else{
                    lab.get_LabyrinthFrontEnd()[hero.get_xCoordinade()][hero.get_yCoordinade()] = '+';
                }
                //hero.set_yCoordinade(hero.get_yCoordinade() + 1);
                hero.d();
                Movements.add(Movement);
                break;
                /*
            case "H":
                HelpPlayer();
                break;
                 */
        }
        return lab;
    }
}
