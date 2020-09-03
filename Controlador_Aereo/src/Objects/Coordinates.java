package Objects;

import java.util.Objects;

public class Coordinates {

    private int _x;
    private int _y;
    private int _z;

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public int get_z() {
        return _z;
    }

    public void set_z(int _z) {
        this._z = _z;
    }

    public Coordinates(int _x, int _y, int _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }
}
