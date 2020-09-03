package Objects;

import BackEnd.MethodsErrors;
import FrontEnd.Inputs_User;
import FrontEnd.StringsRead_User;

import java.util.Scanner;

public class Classes {

    StringsRead_User sru = new StringsRead_User();
    Inputs_User iu = new Inputs_User();
    MethodsErrors me = new MethodsErrors();

    private Students [] _students;

    public Students[] get_students() {
        return _students;
    }

    private String _Name;

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    private int _NumberStudents;

    public int get_NumberStudents() {
        return _NumberStudents;
    }

    public void set_NumberStudents(int _NumberStudents) {
        this._students = new Students[_NumberStudents];  //Inicialitzem la array d'alumnes segons el tamany que ens passin.
        this._NumberStudents = _NumberStudents;
    }

    public Classes(){

    }

    public Classes(String Name, int NumberStudents){
        this._Name = Name;
        set_NumberStudents(NumberStudents);           //Li fem un set per aixi evitar tornar a inicialitzar la array
    }

    @Override
    public String toString() {
        return this._Name + " - " + this._NumberStudents;
    }

    public void Add_Student(){
        Scanner sc = new Scanner(System.in);

        int NumberArray = 0;

        Students _student = iu.InputInfo_Student(this._students);

        for(int a = 0; a < this._students.length;a++){
            if(this._students[0] == null){
                NumberArray = 0;
            }
            else if(this._students[a] == null && NumberArray == 0){
                NumberArray = a;
            }
        }

        if(!me.ArrayCompleteStudents(this._students)){
            this._students[NumberArray] = _student;
        }
        else{
            System.out.println("Completed, delete one student.");
        }
    }

    public void View_Students(){
        for(int a = 0; a < this._students.length;a++){
            if(this._students[a] != null){
                System.out.println(this._students[a].toString() + " - " + a);
            }
        }
    }

    public void Delete_Student() {

        String _enrolment = iu.InputClasse_Student();
        int x = 0;
        boolean NoFound = false;
        for(int a = 0; a < this._students.length;a++){
            if(this._students[a] != null) {
                if (this._students[a].get_Enrolment().equals(_enrolment)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true) {
            this._students[x] = null;
        }
        else{
            System.out.println("Not found.");
        }
    }

    public void UpdateStudent(){
        String _enrolment = iu.InputClasse_Student();
        int x = 0;
        boolean NoFound = false;
        for(int a = 0; a < this._students.length;a++){
            if(this._students[a] != null) {
                if (this._students[a].get_Enrolment().equals(_enrolment)) {
                    x = a;
                    NoFound = true;
                }
            }
        }

        if(NoFound == true ) {
            Students student = iu.InputInfo_StudentUpdate(this._students[x]);
            if(student.get_Academic_Degree() + _students[x].get_Academic_Degree() >= 10) {
                _students[x] = null;
            }
            else{
                student.set_Academic_Degree(student.get_Academic_Degree()+_students[x].get_Academic_Degree());
                _students[x] = student;
            }
        }
        else{
            System.out.println("Not found.");
        }
    }
}
