package adventofcode.year2024.problem12;

import adventofcode.year2024.common.Cell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static adventofcode.year2024.common.Utils.inBounds;

public class RegionFenceCoster {
    private int area;
    private int perimeter;
    private final List<List<Character>> grid;
    private Character character;
    private Set<Cell> visited;

    public RegionFenceCoster(List<List<Character>> grid) {
        this.area = 0;
        this.perimeter = 0;
        this.grid = grid;
        this.character = ' ';
        this.visited = new HashSet<>();
    }

    public int getArea() {
        return this.area;
    }

    public int getPerimeter() {
        return this.perimeter;
    }

    public Set<Cell> getVisited() {
        return this.visited;
    }

    public void calculate(int row, int col) {
        this.character = this.grid.get(row).get(col);
        recursion(row, col);
    }

    private void recursion(int row, int col) {
        if (!inBounds(row, col, this.grid)) {
            return;
        }
        if (this.grid.get(row).get(col) != this.character) {
            return;
        }
        Cell cell = new Cell(row, col);
        if (this.visited.contains(cell)) {
            return;
        }
        this.visited.add(cell);
        int adjacentCells = 0;
        if (inBounds(row + 1, col, this.grid) && this.grid.get(row + 1).get(col) == this.character) {
            recursion(row + 1, col);
            adjacentCells++;
        }
        if (inBounds(row - 1, col, this.grid) && this.grid.get(row - 1).get(col) == this.character) {
            recursion(row - 1, col);
            adjacentCells++;
        }
        if (inBounds(row, col + 1, this.grid) && this.grid.get(row).get(col + 1) == this.character) {
            recursion(row, col + 1);
            adjacentCells++;
        }
        if (inBounds(row, col - 1, this.grid) && this.grid.get(row).get(col - 1) == this.character) {
            recursion(row, col - 1);
            adjacentCells++;
        }
        this.area++;
        this.perimeter += 4 - adjacentCells;
    }
}
