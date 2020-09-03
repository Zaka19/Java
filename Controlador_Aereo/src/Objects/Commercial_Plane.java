package Objects;

public class Commercial_Plane extends Airplane {
    public Commercial_Plane(String _brand, String _enrollment, String _model, int _passengerCapacity, int _crew, String _origin, String _destination, int _autonomy) {
        super(_brand, _enrollment, _model, _passengerCapacity, _crew, _origin, _destination, _autonomy);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
