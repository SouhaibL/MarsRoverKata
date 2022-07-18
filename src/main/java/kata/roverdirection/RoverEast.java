package kata.roverdirection;

import kata.Coordinate;
import kata.Rover;

import static kata.Grid.MAX_WIDTH;


public class RoverEast extends Rover {

    public RoverEast(Coordinate coordinate) {
        super(coordinate);
        this.direction = Direction.EAST;
    }

    public Coordinate moveForward() {
        int x = this.coordinate.getX();
        x = (x+1) % MAX_WIDTH;
        return new Coordinate(x, this.coordinate.getY());
    }

    public Coordinate moveBackward() {
        int x = this.coordinate.getX();
        x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
        return new Coordinate(x, this.coordinate.getY());
    }

    public Rover turnLeft() {
        return new RoverNorth(coordinate);
    }

    public Rover turnRight() {
        return new RoverSouth(coordinate);
    }
}
