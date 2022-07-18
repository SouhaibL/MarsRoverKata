package kata;

import kata.Coordinate;
import kata.Grid;
import kata.exceptions.PositionNotOnGridException;
import kata.roverdirection.Direction;
import kata.RoverManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GridTest {

    private RoverManager roverManager;
    private Grid grid;

    @Before
    public void initialise() {
        roverManager = new RoverManager(new Coordinate(0, 0), Direction.NORTH);
        grid = new Grid();
    }

    @Test
    @Parameters({
        "R, 0:0:E",
        "RR, 0:0:S",
        "RRR, 0:0:W",
        "RRRR, 0:0:N"
    })
    public void should_rotate_right(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",
        "LLLL, 0:0:N"
    })
    public void should_rotate_left(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
        "M, 0:1:N",
        "MMM, 0:3:N"
    })
    public void should_move_up(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
            "B, 0:9:N",
            "BBB, 0:7:N"
    })
    public void should_back_up(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
        "MMMMMMMMMM, 0:0:N",
        "MMMMMMMMMMMMMMM, 0:5:N",
    })
    public void should_wrap_from_top_to_bottom_when_moving_north(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
            "BBBBBBBBBB, 0:0:N",
            "BBBBBBBBBBBBBBB, 0:5:N",
    })
    public void should_wrap_from_bottom_to_top_when_moving_north(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
        "RM, 1:0:E",
        "RMMMMM, 5:0:E",
    })
    public void should_move_right(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
        "RMMMMMMMMMM, 0:0:E",
        "RMMMMMMMMMMMMMMM, 5:0:E",
    })
    public void should_wrap_from_right_to_left_when_moving_east(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
            "LM, 9:0:W",
            "LMMMMM, 5:0:W",
    })
    public void should_move_left(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
            "LLM, 0:9:S",
            "LLMMMMM, 0:5:S",
    })
    public void should_move_south(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
            "LLB, 0:1:S",
            "LLBBBBB, 0:5:S",
    })
    public void should_move_north(String commands, String position) {
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test
    @Parameters({
            "MMMM, O:0:3:N",
            "RMMMMMM, O:1:0:E"
    })

    public void should_stop_at_obstacle_and_report(String commands, String position) {
        Coordinate obstacle_0x4 = new Coordinate(0, 4);
        Coordinate obstacle_2x0 = new Coordinate(2, 0);
        grid.setObstacles(asList(obstacle_0x4, obstacle_2x0));
        assertThat(grid.execute(roverManager.getRover(), commands), is(position));
    }

    @Test(expected = PositionNotOnGridException.class)
    public void should_throws_an_exception_when_position_is_not_in_grid(){
        Coordinate obstacle_0x100 = new Coordinate(0, 100);
        grid.addObstacle(obstacle_0x100);
    }
}