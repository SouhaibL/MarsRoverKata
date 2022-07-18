package kata;

import kata.roverdirection.*;
import lombok.Getter;
public class RoverManager{
    @Getter
    private Rover rover;

    public RoverManager(Coordinate coordinate, char direction) {
        initializeRover(coordinate, direction);
    }

    private void initializeRover(Coordinate coordinate, char direction) {
        switch (direction) {
            case Direction.NORTH:
                rover = new RoverNorth(coordinate);
                break;
            case Direction.SOUTH:
                rover = new RoverSouth(coordinate);
                break;
            case Direction.EAST:
                rover = new RoverEast(coordinate);
                break;
            case Direction.WEST:
                rover = new RoverWest(coordinate);
                break;
        }
    }
}
