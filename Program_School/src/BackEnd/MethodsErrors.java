package BackEnd;

import Objects.Classes;
import Objects.Schools;
import Objects.Students;

public class MethodsErrors {

    public boolean Repeat_Name_Schools(Schools[] _schools, String _name){

        boolean Repeat_Name = false;

        for(int a = 0; a < _schools.length;a++){
            if(_schools[a] != null) {
                if (_schools[a].get_Name().equals(_name)) {
                    Repeat_Name = true;
                }
            }
        }

        return Repeat_Name;
    }

    public boolean Repeat_Name_Classes(Classes[] _classes, String _name){

        boolean Repeat_Name = false;

        for(int a = 0; a < _classes.length;a++){
            if(_classes[a] != null) {
                if (_classes[a].get_Name().equals(_name)) {
                    Repeat_Name = true;
                }
            }
        }

        return Repeat_Name;
    }

    public boolean Repeat_Enrolment_Students(Students[] _students, String _enrolment){

        boolean Repeat_Enrolment = false;

        for(int a = 0; a < _students.length;a++){
            if(_students[a] != null) {
                if (_students[a].get_Enrolment().equals(_enrolment)) {
                    Repeat_Enrolment = true;
                }
            }
        }

        return Repeat_Enrolment;
    }

    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public boolean ArrayCompleteSchool(Schools[] _school){
        int x = 0;
        boolean re = false;
        for(int a = 0; a < _school.length ; a++){
            if(_school[a] != null){
                x++;
            }
        }

        if(x == _school.length - 1){
            re = true;
        }

        return re;
    }

    public boolean ArrayCompleteClass(Classes[] _class){
        int x = 0;
        boolean re = false;
        for(int a = 0; a < _class.length ; a++){
            if(_class[a] != null){
                x++;
            }
        }

        if(x == _class.length){
            re = true;
        }

        return re;
    }

    public boolean ArrayCompleteStudents(Students[] students) {
        int x = 0;
        boolean re = false;
        for(int a = 0; a < students.length ; a++){
            if(students[a] != null){
                x++;
            }
        }

        if(x == students.length){
            re = true;
        }

        return re;
    }

    public boolean HaveClass(Schools _school){
        int a = 0;
        boolean x = false;
        for(int b = 0; b < _school.get_classes().length;b++){
            if(_school.get_classes()[a] == null){
                a++;
            }
        }

        if(a == _school.get_classes().length){
            x = true;
        }
        return x;
    }

    public boolean HaveStudents(Classes aClass) {
        int a = 0;
        boolean x = false;
        for(int b = 0; b < aClass.get_students().length;b++){
            if(aClass.get_students()[a] == null){
                a++;
            }
        }

        if(a == aClass.get_students().length){
            x = true;
        }
        return x;
    }
}
