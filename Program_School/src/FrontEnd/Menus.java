package FrontEnd;

import Objects.Classes;
import Objects.DataBase;
import Objects.Schools;
import BackEnd.*;

public class Menus {

    StringsRead_User sru = new StringsRead_User();
    Inputs_User iu = new Inputs_User();

    public void MenuSchool(DataBase _bdd){
        int x;

        do {

            System.out.println(sru.getOption_1_Schools());
            System.out.println(sru.getOption_2_Schools());
            System.out.println(sru.getOption_3_Schools());
            System.out.println(sru.getOption_4_Schools());
            System.out.println(sru.getOption_5_Schools());
            System.out.println("6. View All.");
            System.out.println(sru.getExit());
            System.out.println();

            x = iu.SelectOption();

            switch(x){
                case 1:
                    _bdd.Add_School();
                    break;
                case 2:
                    _bdd.View_Schools();
                    break;
                case 3:
                    Schools _school = _bdd.FoundSchool();
                    if(_school != null){
                        MenuClasses(_school);
                    }
                    else {
                        System.out.println("Not Found");
                    }
                    break;
                case 4:
                    _bdd.Delete_Schools();
                    break;
                case 5:
                    _bdd.UpdateSchool();
                    break;
                case 6:
                    _bdd.ViewAll();
                    break;
            }

        }while(x != 0);
    }

    public void MenuClasses(Schools _school){
        boolean a = false;
        int x;

        do {

            System.out.println(sru.getOption_1_Classes());
            System.out.println(sru.getOption_2_Classes());
            System.out.println(sru.getOption_3_Classes());
            System.out.println(sru.getOption_4_Classes());
            System.out.println(sru.getExit());

            x = iu.SelectOption();

            switch (x) {
                case 1:
                    _school.Add_Classe();
                    break;
                case 2:
                    _school.View_Classes();
                    break;
                case 3:
                    Classes _class = _school.FoundClasse();
                    if(_class != null){
                        MenuStudents(_class);
                    }
                    else {
                        System.out.println("Not Found");
                    }
                    break;
                case 4:
                    _school.Delete_Classe();
                    break;
                case 5:
                    _school.UpdateClasse();
                    break;
            }

        }while(x != 0);
    }

    public void MenuStudents(Classes _class){
        boolean a = false;
        int x;

        do {

            System.out.println(sru.getOption_1_Students());
            System.out.println(sru.getOption_2_Students());
            System.out.println(sru.getOption_3_Students());
            System.out.println(sru.getOption_4_Students());
            System.out.println(sru.getExit());

            x = iu.SelectOption();

            switch (x) {
                case 1:
                    _class.Add_Student();
                    break;
                case 2:
                    _class.View_Students();
                    break;
                case 3:
                    _class.Delete_Student();
                    break;
                case 4:
                    _class.UpdateStudent();
                    break;
            }

        }while(x != 0);
    }
}
