package Objects;

import BackEnd.MethodsErrors;
import FrontEnd.Inputs_User;
import FrontEnd.StringsRead_User;

import java.util.Scanner;

public class Schools {

    StringsRead_User sru = new StringsRead_User();
    Inputs_User iu = new Inputs_User();
    MethodsErrors me = new MethodsErrors();

    private Classes[] _classes;

    public Classes[] get_classes() {
        return _classes;
    }

    private String _Name;

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    private int _NumberClasses;

    public int get_NumberClasses() {
        return _NumberClasses;
    }

    public void set_NumberClasses(int _NumberClasses) {
        _classes = new Classes[_NumberClasses];  //Inicialitzem la array de classes segons el tamany que ens passin.
        this._NumberClasses = _NumberClasses;
    }

    public Schools(){

    }

    public Schools(String Name, int NumberClasses){
        this._Name = Name;
        set_NumberClasses(NumberClasses);           //Li fem un set per aixi evitar tornar a inicialitzar la array
    }

    @Override
    public String toString() {
        return this._Name + " - " + this._NumberClasses;
    }

    public void Add_Classe(){
        Scanner sc = new Scanner(System.in);

        int NumberArray = 0;

        Classes _class = iu.InputInfo_Classe(this._classes);

        for(int a = 0; a < this._classes.length;a++){
            if(this._classes[0] == null){
                NumberArray = 0;
            }
            else if(this._classes[a] == null && NumberArray == 0){
                NumberArray = a;
            }
        }

        if(!me.ArrayCompleteClass(this._classes)){
            this._classes[NumberArray] = _class;
        }
        else{
            System.out.println("Completed, delete one class.");
        }
    }

    public void View_Classes(){
        for(int a = 0; a < this._classes.length;a++){
            if(this._classes[a] != null){
                System.out.println(this._classes[a].toString() + " - " + a);
            }
        }
    }

    public void Delete_Classe() {

        String _name = iu.InputClasse_Delete();
        int x = 0;
        boolean NoFound = false;
        for(int a = 0; a < this._classes.length;a++){
            if(this._classes[a] != null) {
                if (this._classes[a].get_Name().equals(_name)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true  && me.HaveStudents(_classes[x])) {
            this._classes[x] = null;
        }
        else{
            System.out.println("Not found.");
        }
    }

    public Classes FoundClasse() {
        String _name = iu.InputSchool_Delete();
        int x = 0;
        Classes _class;
        boolean NoFound = false;
        for(int a = 0; a < this._classes.length;a++){
            if(this._classes[a] != null) {
                if (this._classes[a].get_Name().equals(_name)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true) {
            _class = _classes[x];
        }
        else{
            _class = null;
        }

        return _class;
    }

    public void UpdateClasse(){
        String _name = iu.InputSchool_Delete();
        int x = 0;
        boolean NoFound = false;
        for(int a = 0; a < this._classes.length;a++){
            if(this._classes[a] != null) {
                if (this._classes[a].get_Name().equals(_name)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true) {
            String _NameUpdate = iu.InputInfo_ClasseUpdate(this._classes);
            if(!_NameUpdate.equals("")){
                _classes[x].set_Name(_NameUpdate);
            }
        }
        else{
            _classes[x].set_Name(_classes[x].get_Name());
        }
    }
}
