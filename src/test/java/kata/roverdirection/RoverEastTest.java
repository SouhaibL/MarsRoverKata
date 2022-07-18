package kata.roverdirection;

import kata.Coordinate;
import kata.Rover;
import org.junit.Assert;
import org.junit.Test;

public class RoverEastTest {

    Rover rover = new RoverEast(new Coordinate(0,0));

    @Test
    public void should_move_forward_the_rover_after_forward_method_call() {
        Coordinate coordinate = rover.moveForward();
        Assert.assertEquals(coordinate.getX(), 1);
    }

    @Test
    public void should_move_backward_the_rover_after_backward_method_call() {
        Coordinate coordinate = rover.moveBackward();
        Assert.assertEquals(coordinate.getX(), 9);
    }

    @Test
    public void should_return_a_rover_north_after_turn_left() {
        Rover roverAfterTurnLeft = rover.turnLeft();
        Assert.assertEquals(roverAfterTurnLeft.getClass(), RoverNorth.class);
    }

    @Test
    public void should_return_a_rover_south_after_turn_right() {
        Rover roverAfterTurnRight = rover.turnRight();
        Assert.assertEquals(roverAfterTurnRight.getClass(), RoverSouth.class);
    }

}
