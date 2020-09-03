package Objects;

public class Hero {

    //NOMBRE DEL HEROE
    private String _name;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    //POSICION
    private int _xCoordinade;

    public int get_xCoordinade() {
        return _xCoordinade;
    }

    public void set_xCoordinade(int _xCoordinade) {
        this._xCoordinade = _xCoordinade;
    }

    private int _yCoordinade;

    public int get_yCoordinade() {
        return _yCoordinade;
    }

    public void set_yCoordinade(int _yCoordinade) {
        this._yCoordinade = _yCoordinade;
    }

    //CUERPO DEL HEROE
    private char _body;

    public char get_body() {
        return _body;
    }

    public void set_body(char _body) {
        this._body = _body;
    }

    //VIDA
    private int Life;

    public int getLife() {
        return Life;
    }

    public void setLife(int life) {
        Life = life;
    }

    //PICO
    private boolean Pick;

    public boolean isPick() {
        return Pick;
    }

    public void setPick(boolean pick) {
        Pick = pick;
    }

    public Hero(String Name, int Live, char Body, int x, int y){
        set_name(Name);
        set_xCoordinade(x);
        set_yCoordinade(y);
        set_body(Body);
        setLife(Live);
    }

    public void s(){
        this._xCoordinade++;
    }

    public void w(){
        this._xCoordinade--;
    }

    public void a(){
        this._yCoordinade--;
    }

    public void d(){
        this._yCoordinade++;
    }
}

