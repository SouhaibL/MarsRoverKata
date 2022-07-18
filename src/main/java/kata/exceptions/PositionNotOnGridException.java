package kata.exceptions;

import kata.Coordinate;
import kata.Grid;
import lombok.Getter;

@Getter
public class PositionNotOnGridException extends RuntimeException {

	private Grid grid;
	private Coordinate coordinate;
	
	public PositionNotOnGridException(Grid grid, Coordinate coordinate) {
		super("Position is not on the Grid!");
		this.grid = grid;
		this.coordinate = coordinate;
	}

}
