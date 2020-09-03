package Objects;

import BackEnd.MethodsErrors;
import FrontEnd.Inputs_User;
import FrontEnd.StringsRead_User;

import java.util.Scanner;

public class DataBase {

    StringsRead_User sru = new StringsRead_User();
    Inputs_User iu = new Inputs_User();
    MethodsErrors me = new MethodsErrors();

    private Schools[] _schools;

    public Schools[] get_schools() {
        return _schools;
    }

    private String _Name;

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    private int _NumberSchools;

    public int get_NumberSchools() {
        return _NumberSchools;
    }

    public void set_NumberSchools(int NumberSchools) {
        this._schools = new Schools[NumberSchools];  //Inicialitzem la array de classes segons el tamany que ens passin.
        this._NumberSchools = NumberSchools;
    }

    public DataBase(){

    }

    public DataBase(String Name, int NumberClasses){
        this._Name = Name;
        set_NumberSchools(NumberClasses); //Li fem un set per aixi evitar tornar a inicialitzar la array
    }

    @Override
    public String toString() {
        return this._Name + " - " + this._NumberSchools;
    }

    public void Add_School(){
        Scanner sc = new Scanner(System.in);

        int NumberArray = 0;

        Schools _school = iu.InputInfo_School(this._schools);

        for(int a = 0; a < this._schools.length;a++){
            if(this._schools[0] == null){
                NumberArray = 0;
            }
            else if(this._schools[a] == null && NumberArray == 0){
                NumberArray = a;
            }
        }

        if(!me.ArrayCompleteSchool(this._schools)){
            this._schools[NumberArray] = _school;
        }
        else{
            System.out.println("Completed, delete one school.");
        }
    }

    public void View_Schools(){
        for(int a = 0; a < _schools.length;a++){
            if(this._schools[a] != null){
                System.out.println(this._schools[a].toString() + " - " + a);
            }
        }
    }

    public void Delete_Schools() {

        String _name = iu.InputSchool_Delete();
        int x = 0;
        boolean NoFound = false;
        for(int a = 0; a < this._schools.length;a++){
            if(this._schools[a] != null) {
                if (this._schools[a].get_Name().equals(_name)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true && me.HaveClass(_schools[x])) {
            this._schools[x] = null;
        }
        else{
            System.out.println("Not found or you class in this school.");
        }
    }

    public Schools FoundSchool() {
        String _name = iu.InputSchool_Delete();
        int x = 0;
        Schools _school;
        boolean NoFound = false;
        for(int a = 0; a < this._schools.length;a++){
            if(this._schools[a] != null) {
                if (this._schools[a].get_Name().equals(_name)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true) {
            _school = _schools[x];
        }
        else{
            _school = null;
        }

        return _school;
    }

    public void UpdateSchool(){
        String _name = iu.InputSchool_Delete();
        int x = 0;
        boolean NoFound = false;
        for(int a = 0; a < this._schools.length;a++){
            if(this._schools[a] != null) {
                if (this._schools[a].get_Name().equals(_name)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true) {
            String _NameUpdate = iu.InputInfo_SchoolUpdate(this._schools);
            if(!_NameUpdate.equals("")){
                _schools[x].set_Name(_NameUpdate);
            }
        }
        else{
            _schools[x].set_Name(_schools[x].get_Name());
        }
    }

    public void ViewAll() {
        Schools sc = FoundSchool();
        if (sc != null) {
                System.out.println("School: ");
                System.out.println(sc.toString());
                System.out.println("Classes: ");
                for (int a = 0; a < sc.get_classes().length; a++) {
                    if (sc.get_classes()[a] != null) {
                        System.out.println(sc.get_classes()[a].toString());
                        for (int b = 0; b < sc.get_classes()[a].get_students().length; b++) {
                            if (sc.get_classes()[a].get_students()[b] != null) {
                                System.out.println(sc.get_classes()[a].get_students()[b].toString());
                            }
                        }
                    }
                    else{
                        System.out.println("You don't have class in " + a);
                    }
                }
            }
            else{
                System.out.println("Not found");
            }
        }
    }
