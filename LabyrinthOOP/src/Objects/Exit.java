package Objects;

public class Exit {
    private int _x;

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    private int _y;

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    private char _body;

    public char get_body() {
        return _body;
    }

    public void set_body(char _body) {
        this._body = _body;
    }

    public Exit(char body){
        set_body(body);
    }
}
