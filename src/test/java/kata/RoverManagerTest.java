package kata;

import kata.Coordinate;
import kata.Rover;
import kata.RoverManager;
import kata.roverdirection.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RoverManagerTest {

    private RoverManager roverManager;
    private Coordinate coordinates;

    @Before
    public void setUp() {
        coordinates = new Coordinate(0,0);
    }

    @Test
    public void should_return_a_rover_north_after_instantiate_rover_manager_with_that_direction() {
        roverManager = new RoverManager(coordinates, Direction.NORTH);
        Assert.assertEquals(roverManager.getRover().getClass(), RoverNorth.class);
    }

    @Test
    public void should_return_a_rover_south_after_instantiate_rover_manager_with_that_direction() {
        roverManager = new RoverManager(coordinates, Direction.SOUTH);
        Assert.assertEquals(roverManager.getRover().getClass(), RoverSouth.class);
    }

    @Test
    public void should_return_a_rover_east_after_instantiate_rover_manager_with_that_direction() {
        roverManager = new RoverManager(coordinates, Direction.EAST);
        Assert.assertEquals(roverManager.getRover().getClass(), RoverEast.class);
    }


    @Test
    public void should_return_a_rover_west_after_instantiate_rover_manager_with_that_direction() {
        roverManager = new RoverManager(coordinates, Direction.WEST);
        Assert.assertEquals(roverManager.getRover().getClass(), RoverWest.class);
    }

    @Test
    @Parameters(method = "roverParameters")
    public void should_overwrite_rover_after_turn_left(Rover rover) {
        Rover newRover = rover.turnLeft();
        Assert.assertNotEquals(newRover.getClass(), rover.getClass());
    }

    @Test
    @Parameters(method = "roverParameters")
    public void should_overwrite_rover_after_turn_right(Rover rover) {
        Rover newRover = rover.turnRight();
        Assert.assertNotEquals(newRover.getClass(), rover.getClass());
    }

    private Rover[] roverParameters() {
        return new Rover[]{
                new RoverNorth(coordinates),
                new RoverSouth(coordinates),
                new RoverEast(coordinates),
                new RoverWest(coordinates)
        };
    }


}
