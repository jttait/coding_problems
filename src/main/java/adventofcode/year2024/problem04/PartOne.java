package adventofcode.year2024.problem04;

import java.util.List;

public class PartOne {

    private List<Direction> directions;

    public PartOne() {
        this.directions = List.of(
                new Direction(-1, 0),
                new Direction(-1, 1),
                new Direction(0, 1),
                new Direction(1, 1),
                new Direction(1, 0),
                new Direction(1, -1),
                new Direction(0, -1),
                new Direction(-1, -1)
        );
    }

    public int findXmas(List<List<Character>> grid) {
        int result = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == 'X') {
                    result += checkAllDirections(row, col, grid);
                }
            }
        }
        return result;
    }

    private int checkAllDirections(int row, int col, List<List<Character>> grid) {
        int result = 0;
        for (Direction direction : directions) {
            result += checkDirection(direction, row, col, grid);
        }
        return result;
    }

    private int checkDirection(Direction direction, int row, int col, List<List<Character>> grid) {
        List<Character> expected = List.of('X', 'M', 'A', 'S');
        int numRows = grid.size();
        int numCols = grid.get(0).size();
        int index = 0;
        while (row >= 0 && col >= 0 && row < numRows && col < numCols && grid.get(row).get(col) == expected.get(index)) {
            row += direction.rowDelta();
            col += direction.colDelta();
            index++;
            if (index >= 4) {
                return 1;
            }
        }
        return 0;
    }
}
