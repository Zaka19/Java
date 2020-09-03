package Objects;

public class Students {
    private String _Name;

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    private int _Academic_Degree;

    public int get_Academic_Degree() {
        return _Academic_Degree;
    }

    public void set_Academic_Degree(int _Academic_Degree) {
        this._Academic_Degree = _Academic_Degree;
    }

    private String _Enrolment;

    public String get_Enrolment() {
        return _Enrolment;
    }

    public void set_Enrolment(String _Enrolment) {
        this._Enrolment = _Enrolment;
    }

    public Students(){

    }

    public Students(String Name, int Academic_Degree,String Enrolment){
        this._Name = Name;
        this._Academic_Degree = Academic_Degree;
        this._Enrolment = Enrolment;
    }

    @Override
    public String toString() {
        return this._Name + " - " + this._Academic_Degree + " - " + this._Enrolment;
    }
}
