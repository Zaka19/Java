import Objects.Exit;
import Objects.Hero;
import Objects.Labyrinth;

import java.awt.*;

public class FrontEnd {

    char W = '#';
    char B = '♦';
    char P = '◘';
    char N = ' ';
    char S = '■';

    public Labyrinth InitialTables(Labyrinth lab, Hero heroe) {

        char [][] LabyrinthBackEnd = new char [][]  {
                {W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W},
                {W,N,W,W,N,N,N,N,W,W,W,W,W,W,W,W,W,W,W,W},
                {W,N,W,W,N,W,W,N,W,W,W,W,W,W,W,W,W,W,W,W},
                {W,N,W,W,N,W,W,N,W,W,W,W,W,W,W,W,W,W,W,W},
                {W,N,W,W,N,W,W,N,W,W,W,W,N,W,W,W,W,W,W,W},
                {W,N,N,N,N,W,W,N,W,W,W,W,N,W,W,W,W,W,W,W},
                {W,N,W,W,W,W,W,N,W,W,W,W,N,N,N,N,N,N,W,W},
                {W,N,W,W,W,W,W,N,W,W,W,W,N,W,W,W,W,N,W,W},
                {W,N,W,W,W,W,W,N,W,W,W,W,N,W,W,W,W,N,W,W},
                {W,N,W,N,W,W,W,N,N,N,N,N,N,W,W,W,W,N,W,W},
                {W,N,W,N,W,W,W,W,W,W,W,W,W,W,W,W,W,N,W,W},
                {W,N,W,N,N,N,N,N,W,W,W,W,N,N,N,N,N,N,W,W},
                {W,N,W,N,W,W,W,N,W,W,W,W,N,W,W,W,W,W,W,W},
                {W,N,W,N,W,W,W,N,W,W,W,W,N,W,W,W,W,W,W,W},
                {W,N,W,N,W,W,W,N,W,W,N,N,N,W,W,W,W,W,W,W},
                {W,N,W,N,W,W,N,N,W,W,N,W,N,W,W,W,W,W,W,W},
                {W,N,W,N,N,W,N,W,W,W,N,W,N,W,W,N,N,N,W,W},
                {W,N,W,W,N,W,N,N,N,N,N,W,N,W,W,N,W,N,N,W},
                {W,N,N,P,N,W,W,W,W,W,W,W,N,N,N,N,W,W,N,W},
                {W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W}
        };

        char [][]LabyrinthFrontEnd = new char [][]{
                {W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,N,W},
                {W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W,W},
        };

        LabyrinthBackEnd[heroe.get_xCoordinade()][heroe.get_yCoordinade()] = heroe.get_body();
        LabyrinthFrontEnd[heroe.get_xCoordinade()][heroe.get_yCoordinade()] = heroe.get_body();

       lab.set_LabyrinthBackEnd(LabyrinthBackEnd);
       lab.set_LabyrinthFrontEnd(LabyrinthFrontEnd);
       lab.set_xSize(LabyrinthBackEnd.length);
       lab.set_ySize(LabyrinthFrontEnd.length);

       return lab;
    }

    public void ViewLabyrinth(Labyrinth lab){
        for(int a = 0; a < lab.get_xSize();a++){
            for(int b = 0; b < lab.get_ySize();b++){
                System.out.print(lab.get_LabyrinthFrontEnd()[a][b] + " ");
            }
            System.out.println();
        }
    }

    public void ViewLabyrinthTest(Labyrinth lab){
        for(int a = 0; a < lab.get_xSize();a++){
            for(int b = 0; b < lab.get_ySize();b++){
                System.out.print(lab.get_LabyrinthBackEnd()[a][b] + " ");
            }
            System.out.println();
        }
    }
}
