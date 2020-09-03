package Program.Objects;

public class Players {
    String Name;
    int Points;

    public Players(String name, int points) {
        Name = name;
        Points = points;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    @Override
    public String toString() {
        return "Name='" + Name + ", Points=" + Points;
    }
}
