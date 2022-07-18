package kata.roverdirection;

import kata.Coordinate;
import kata.Rover;

import static kata.Grid.MAX_HEIGHT;

public class RoverSouth extends Rover {


    public RoverSouth(Coordinate coordinate) {
        super(coordinate);
        this.direction = Direction.SOUTH;
    }

    public Coordinate moveForward() {
        int y = this.coordinate.getY();
        y = (y > 0) ? y - 1 : MAX_HEIGHT - 1;
        return new Coordinate(this.coordinate.getX(), y);
    }

    public Coordinate moveBackward() {
        int y = this.coordinate.getY();
        y = (y+1) % MAX_HEIGHT;
        return new Coordinate(this.coordinate.getX(), y);
    }

    public Rover turnLeft() {
        return new RoverEast(coordinate);
    }

    public Rover turnRight() {
        return new RoverWest(coordinate);
    }
}
