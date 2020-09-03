package BackEnd;

import Objects.DataBase;
import Objects.Schools;

public class Controller {

    DataBase _bdd;

    public Controller(int Size){
        _bdd = new DataBase("Schools",Size);
    }

    FrontEnd.Menus fm = new FrontEnd.Menus();

    public void StartProgram() {
        fm.MenuSchool(_bdd);
    }
}
