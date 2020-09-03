import Objects.*;
public class Controller {

    FrontEnd fe = new FrontEnd();
    LogicProgram lp = new LogicProgram();

    public Controller(){ }

    public void Start(){
        Hero heroe = new Hero("zzghoul",5,'☻',0,1);
        Labyrinth laby = new Labyrinth();
        Exit exit = new Exit('■');

        fe.InitialTables(laby,heroe);

        lp.GenerateExit(exit,laby);

        for(int a = 0; a < 10;a++){
            fe.ViewLabyrinth(laby);
            lp.MovementHeroe(laby,heroe);
        }

    }
}
