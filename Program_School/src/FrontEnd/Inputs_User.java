package FrontEnd;

import BackEnd.MethodsErrors;
import Objects.Classes;
import Objects.Schools;
import Objects.Students;

import java.util.Scanner;

public class Inputs_User {

    StringsRead_User sr = new StringsRead_User();
    MethodsErrors me = new MethodsErrors();

    public int SelectOption() {
        Scanner sc = new Scanner(System.in);
        String option;

            System.out.println(sr.getSelect_Option());
            option = sc.nextLine();

            while(!me.isNumeric(option)){
                System.out.println(sr.getSelect_Option());
                option = sc.nextLine();
            }

            int _option = (int) Integer.valueOf(option);

        return _option;
    }

    public Schools InputInfo_School(Schools[] _schools){
        Scanner sc = new Scanner(System.in);

        String _Name;
        String _NumberClasses;

        System.out.println(sr.getName_School());
        _Name = sc.nextLine();

        while(me.Repeat_Name_Schools(_schools,_Name) || _Name.equals("")){
            System.out.println(sr.getRepeatName() + "..." + sr.getName_School());
            _Name = sc.nextLine();
        }

        System.out.println(sr.getNumberClasses());
        _NumberClasses = sc.nextLine();

        while(!me.isNumeric(_NumberClasses)){
            System.out.println(sr.getNumberClasses());
            _NumberClasses = sc.nextLine();
        }

        int NumberClasses = (int) Integer.valueOf(_NumberClasses);

        return new Schools(_Name,NumberClasses);
    }

    public String InputSchool_Delete(){
        Scanner sc = new Scanner(System.in);

        String _Name;
        System.out.println(sr.getName_School());
        _Name = sc.nextLine();

        return _Name;
    }

    public String InputInfo_SchoolUpdate(Schools[] _schools){
        Scanner sc = new Scanner(System.in);

        String _Name;
        int _NumberClasses;
        int NumberArray = 0;

        System.out.println(sr.getName_School());
        _Name = sc.nextLine();

        while(me.Repeat_Name_Schools(_schools,_Name)){
            System.out.println(sr.getRepeatName() + "..." + sr.getName_School());
            _Name = sc.nextLine();
        }

        return _Name;
    }

    public Classes InputInfo_Classe(Classes[] _classes){
        Scanner sc = new Scanner(System.in);

        String _Name;
        String _NumberStudents;

        System.out.println(sr.getName_Classe());
        _Name = sc.nextLine();

        while(me.Repeat_Name_Classes(_classes,_Name) || _Name.equals("")){
            System.out.println(sr.getRepeatName() + "..." + sr.getName_School());
            _Name = sc.nextLine();
        }

        System.out.println(sr.getNumberStudents());
        _NumberStudents = sc.nextLine();

        while(!me.isNumeric(_NumberStudents)){
            System.out.println(sr.getNumberStudents());
            _NumberStudents = sc.nextLine();
        }

        int NumberStudents = (int) Integer.valueOf(_NumberStudents);

        return new Classes(_Name,NumberStudents);
    }

    public String InputClasse_Delete(){
        Scanner sc = new Scanner(System.in);

        String _Name;
        System.out.println(sr.getName_School());
        _Name = sc.nextLine();

        return _Name;
    }

    public String InputInfo_ClasseUpdate(Classes[] _classes){
        Scanner sc = new Scanner(System.in);

        String _Name;

        System.out.println(sr.getName_School());
        _Name = sc.nextLine();

        while(me.Repeat_Name_Classes(_classes,_Name)){
            System.out.println(sr.getRepeatName() + "..." + sr.getName_School());
            _Name = sc.nextLine();
        }

        return _Name;
    }

    public Students InputInfo_Student(Students[] students) {
        Scanner sc = new Scanner(System.in);

        String _Name;
        String _Enrolment;
        String Academic_Degree;
        int _Academic_Degree;
        System.out.println(sr.getName_Student());
        _Name = sc.next();;
        sc.nextLine();

        while(_Name.equals("")){
            System.out.println(sr.getName_Student());
            _Name = sc.next();;
            sc.nextLine();
        }

        System.out.println(sr.getEnrolment());
        _Enrolment = sc.next();
        sc.nextLine();

        while(me.Repeat_Enrolment_Students(students,_Enrolment) || _Enrolment.equals("")){
            System.out.println(sr.getEnrolment());
            _Enrolment = sc.next();
            sc.nextLine();
        }

        do {

            System.out.println(sr.getAcademicDegree() + "(0 - 9)");
            Academic_Degree = sc.nextLine();

            while (!me.isNumeric(Academic_Degree)) {
                System.out.println(sr.getAcademicDegree());
                Academic_Degree = sc.nextLine();
            }

             _Academic_Degree = Integer.valueOf(Academic_Degree);

        }while(_Academic_Degree >= 10);


        return new Students(_Name,_Academic_Degree,_Enrolment);
    }

    public String InputClasse_Student(){
        Scanner sc = new Scanner(System.in);

        String _Enrolment;
        System.out.println(sr.getEnrolment());
        _Enrolment = sc.nextLine();

        return _Enrolment;
    }

    public Students InputInfo_StudentUpdate(Students _student){
        Scanner sc = new Scanner(System.in);

        Students student = new Students();
        String _Name;
        String _Enrolment;
        String Academic_Degree;
        int _Academic_Degree;

        System.out.println(sr.getName_Student());
        _Name = sc.nextLine();;

            System.out.println(sr.getAcademicDegree() + "(0 - 9) and next write -1");
            Academic_Degree = sc.nextLine();

            while (!me.isNumeric(Academic_Degree)) {
                System.out.println(sr.getNumberClasses());
                Academic_Degree = sc.nextLine();
            }

            _Academic_Degree = Integer.valueOf(Academic_Degree);

        if(!_Name.equals("")){
            student.set_Name(_Name);
        }
        else{
            student.set_Name(_student.get_Name());
        }
        if(_Academic_Degree != -1){
            student.set_Academic_Degree(_Academic_Degree);
        }
        else{
            student.set_Academic_Degree(_student.get_Academic_Degree());
        }
        student.set_Enrolment(_student.get_Enrolment());

        return student;
    }

}
