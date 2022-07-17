package Other;

import Other.exceptions.PositionNotOnGridException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {

    public final String OBSTACLE_STRING = "O:";

    public static int MAX_WIDTH = 10;
    public static int MAX_HEIGHT = 10;

    private List<Coordinate> obstacles = new ArrayList<>();

    public String execute(Rover rover, String commands){
        String obstacleString = "";
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                rover = rover.turnRight();
            }
            if (c == 'L') {
                rover = rover.turnLeft();
            }
            if (c == 'M') {
                if(!moveForward(rover)){
                    obstacleString = OBSTACLE_STRING;
                }
            }
            if (c == 'B') {
                if(!moveBackward(rover)){
                    obstacleString = OBSTACLE_STRING;
                }
            }
        }

        return obstacleString + rover.getCustomCoordinate();

    }

    public void addObstacle(Coordinate coordinate){
        int x = coordinate.getX();
        int y = coordinate.getY();
        if(x > -1 && x <MAX_WIDTH && y > -1 && y < MAX_HEIGHT){
            obstacles.add(coordinate);
        } else {
            throw new PositionNotOnGridException(this, coordinate);
        }
    }

    public void setObstacles(List<Coordinate> obstacles){
        obstacles.forEach(this::addObstacle);
    }
    private boolean moveForward(Rover rover) {
        Coordinate newCoordinate = rover.moveForward();
        return checkObstacle(rover, newCoordinate);
    }

    private boolean moveBackward(Rover rover) {
        Coordinate newCoordinate = rover.moveBackward();
        return checkObstacle(rover, newCoordinate);
    }

    private boolean checkObstacle(Rover rover, Coordinate coordinate){
        if(!obstacles.contains(coordinate)){
            rover.setCoordinate(coordinate);
            return true;
        }
        return false;
    }

}
