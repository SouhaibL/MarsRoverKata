package kata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Rover {

    protected Coordinate coordinate;
    protected char direction;

    public Rover(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getCustomCoordinate(){
        return coordinate.getX() + ":" + coordinate.getY() + ":" + direction;
    }

    public abstract Coordinate moveForward();

    public abstract Coordinate moveBackward();

    public abstract Rover turnLeft();

    public abstract Rover turnRight();

}
