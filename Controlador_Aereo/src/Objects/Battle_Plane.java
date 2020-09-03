package Objects;

import Objects.Airplane;

import java.util.ArrayList;

public class Battle_Plane extends Airplane {

    private ArrayList<Missiles> missils = new ArrayList<Missiles>();
    private Double _maximumDistance;
    private int _resistance;
    private boolean _enemy;
    private boolean encrypt;

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public ArrayList<Missiles> getMissils() {
        return missils;
    }

    public Double get_maximumDistance() {
        return _maximumDistance;
    }

    public void set_maximumDistance(Double _maximumDistance) {
        this._maximumDistance = _maximumDistance;
    }

    public int get_resistance() {
        return _resistance;
    }

    public void set_resistance(int _resistance) {
        this._resistance = _resistance;
    }

    public boolean is_enemy() {
        return _enemy;
    }

    public void set_enemy(boolean _enemy) {
        this._enemy = _enemy;
    }

    public Battle_Plane(String _brand, String _enrollment, String _model, int _passengerCapacity, int _crew, String _origin, String _destination, int _autonomy,int numberMisils,int _resistance, boolean _enemy) {
        super(_brand, _enrollment, _model, _passengerCapacity, _crew, _origin, _destination, _autonomy);
        if(_enemy) {
            super.set_coordinate(Math.random() * 1000,Math.random() * 1000,Math.random() * 1000 + 100);
            this._maximumDistance = 100.00;
            this._resistance = _resistance;
            this._enemy = true;
            this.encrypt = false;
            CreateMisils(numberMisils);
        }
        else {
            this._maximumDistance = 100.00;
            this._resistance = _resistance;
            this._enemy = false;
            this.encrypt = false;
            CreateMisils(numberMisils);
        }
    }

    public void CreateMisils(int number){
        for(int a = 0; a < number;a++){
            missils.add(new Missiles(50));
        }
    }

    @Override
    public String toString() {
        String to = "";

        if(isEncrypt()){
            to = this.get_enrollment() + " ENCRYPT";
        }

        else{
            to = super.toString() + _resistance + "     " + _enemy + "     " + missils.size() + "  ";
        }

        return to;
    }
}
