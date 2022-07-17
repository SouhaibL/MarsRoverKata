package roverdirection;

import Other.Coordinate;
import Other.Rover;
import Other.roverdirection.RoverEast;
import Other.roverdirection.RoverSouth;
import Other.roverdirection.RoverWest;
import org.junit.Assert;
import org.junit.Test;

public class RoverSouthTest {
    Rover rover = new RoverSouth(new Coordinate(0,0));

    @Test
    public void should_move_forward_the_rover_after_forward_method_call() {
        Coordinate coordinate = rover.moveForward();
        Assert.assertEquals(coordinate.getY(), 9);
    }

    @Test
    public void should_move_backward_the_rover_after_backward_method_call() {
        Coordinate coordinate = rover.moveBackward();
        Assert.assertEquals(coordinate.getY(), 1);
    }

    @Test
    public void should_return_a_rover_east_after_turn_left() {
        Rover roverAfterTurnLeft = rover.turnLeft();
        Assert.assertEquals(roverAfterTurnLeft.getClass(), RoverEast.class);
    }

    @Test
    public void should_return_a_rover_west_after_turn_right() {
        Rover roverAfterTurnRight = rover.turnRight();
        Assert.assertEquals(roverAfterTurnRight.getClass(), RoverWest.class);
    }
}
