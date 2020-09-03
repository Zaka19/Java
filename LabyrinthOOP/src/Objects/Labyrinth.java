package Objects;

public class Labyrinth {

    private char[][] _LabyrinthBackEnd;

    public char[][] get_LabyrinthBackEnd() {
        return _LabyrinthBackEnd;
    }

    public void set_LabyrinthBackEnd(char[][] _LabyrinthBackEnd) {
        this._LabyrinthBackEnd = _LabyrinthBackEnd;
    }

    private char[][] _LabyrinthFrontEnd;

    public char[][] get_LabyrinthFrontEnd() {
        return _LabyrinthFrontEnd;
    }

    public void set_LabyrinthFrontEnd(char[][] _LabyrinthFrontEnd) {
        this._LabyrinthFrontEnd = _LabyrinthFrontEnd;
    }

    private int _xSize;

    public int get_xSize() {
        return _xSize;
    }

    public void set_xSize(int _xSize) {
        this._xSize = _xSize;
    }

    private  int _ySize;

    public int get_ySize() {
        return _ySize;
    }

    public void set_ySize(int _ySize) {
        this._ySize = _ySize;
    }
}
