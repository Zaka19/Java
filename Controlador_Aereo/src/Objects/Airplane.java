package Objects;

public abstract class  Airplane {

    private String _brand;
    private String _enrollment;
    private String _model;
    private int _passengerCapacity;
    private int _crew;
    private String _origin;
    private String _destination;
    private boolean _trainLanding;
    private Double _velocity;
    private Coordinates _coordinate;
    private boolean _motor;
    private int _autonomy;
    private Double _course;

    public String get_brand() {
        return _brand;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public String get_enrollment() {
        return _enrollment;
    }

    public void set_enrollment(String _enrollment) {
        this._enrollment = _enrollment;
    }

    public String get_model() {
        return _model;
    }

    public void set_model(String _model) {
        this._model = _model;
    }

    public int get_passengerCapacity() {
        return _passengerCapacity;
    }

    public void set_passengerCapacity(int _passengerCapacity) {
        this._passengerCapacity = _passengerCapacity;
    }

    public int get_crew() {
        return _crew;
    }

    public void set_crew(int _crew) {
        this._crew = _crew;
    }

    public String get_origin() {
        return _origin;
    }

    public void set_origin(String _origin) {
        this._origin = _origin;
    }

    public String get_destination() {
        return _destination;
    }

    public void set_destination(String _destination) {
        this._destination = _destination;
    }

    public boolean get_trainLanding() {
        return _trainLanding;
    }

    public void set_trainLanding(boolean _trainLanding) {
        this._trainLanding = _trainLanding;
    }

    public Double get_velocity() {
        return _velocity;
    }

    public void set_velocity(Double _velocity) {
        this._velocity = _velocity;
    }

    public Coordinates get_coordinate() {
        return _coordinate;
    }

    public void set_coordinate(double x, double y, double z) {
        this._coordinate.set_x((int) x);
        this._coordinate.set_y((int) y);
        this._coordinate.set_z((int) z);
    }

    public boolean get_motor() {
        return _motor;
    }

    public void set_motor(boolean _motor) {
        this._motor = _motor;
    }

    public int get_autonomy() {
        return _autonomy;
    }

    public void set_autonomy(int _autonomy) {
        this._autonomy = _autonomy;
    }

    public Double get_course() {
        return _course;
    }

    public void set_course(Double _course) {
        this._course = _course;
    }

    public Airplane(String _brand, String _enrollment, String _model, int _passengerCapacity, int _crew, String _origin, String _destination, int _autonomy) {
        this._brand = _brand;
        this._enrollment = _enrollment;
        this._model = _model;
        this._passengerCapacity = _passengerCapacity;
        this._crew = _crew;
        this._origin = _origin;
        this._destination = _destination;
        this._trainLanding = true;
        this._velocity = 0.0;
        this._coordinate = new Coordinates(100,(int) Math.floor(Math.random() * (120 - 100)) + 100,0);
        this._motor = false;
        this._autonomy = _autonomy;
        this._course = 0.0;
    }

    @Override
    public String toString() {
        return "  " + _brand + "     " + _enrollment + "     " + _model + "     " + _passengerCapacity + "     " + _crew + "     " + _origin + "     " + _destination + "     " + "     " + _coordinate.toString() + "     " + "     " + _autonomy + "     " + _course + "     ";
    }

    public void igntieEnginee() throws InterruptedException {
        if(_motor){ System.out.println("The engine is already on.");  Thread.sleep(1000);}
        else {this._motor = true; System.out.println("The engine is on."); Thread.sleep(1000);}
    }

    public void turnOffEnginee() throws InterruptedException {
        if(!_motor){ System.out.println("The engine is already off."); Thread.sleep(1000);}
        else if(this.get_coordinate().get_z() == 0){this._motor = false; System.out.println("The engine is off."); Thread.sleep(1000);}
        else if (this.get_coordinate().get_z() > 0){
            System.out.println("You are in the air.");
            Thread.sleep(1000);
        }
    }

    public void _trainLandingOn() throws InterruptedException {
        if(_trainLanding){ System.out.println("The train landing is already on."); Thread.sleep(1000);}
        else if(this._coordinate.get_z() >= 500){ System.out.println("The height is height."); Thread.sleep(1000);}
        else if(this._coordinate.get_z() < 500) {this._trainLanding = true; System.out.println("The train landing is on."); Thread.sleep(1000);}
    }

    public void _trainLandingOff() throws InterruptedException {
        if(!_trainLanding){ System.out.println("The train landing is already off."); Thread.sleep(1000);}
        else if(this._coordinate.get_z() == 0 || this._coordinate.get_z() < 500){ System.out.println("The height is low."); Thread.sleep(1000);}
        else if (this._coordinate.get_z() >= 500) {this._trainLanding = false; System.out.println("The train landing is off."); Thread.sleep(1000);}
    }

    public void Move(int x , int y, int z){
        set_coordinate(x,y,z);
    }
}
