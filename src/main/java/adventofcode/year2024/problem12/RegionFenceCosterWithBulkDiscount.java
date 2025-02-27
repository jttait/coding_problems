package adventofcode.year2024.problem12;

import adventofcode.year2024.common.Cell;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static adventofcode.year2024.common.Utils.inBounds;

public class RegionFenceCosterWithBulkDiscount {
    private int area;
    private int edges;
    private final List<List<Character>> grid;
    private Character character;
    private Set<Cell> visited;

    public RegionFenceCosterWithBulkDiscount(List<List<Character>> grid) {
        this.area = 0;
        this.edges = 0;
        this.grid = grid;
        this.character = ' ';
        this.visited = new HashSet<>();
    }

    public int getArea() {
        return this.area;
    }

    public int getEdges() {
        return this.edges;
    }

    public Set<Cell> getVisited() {
        return this.visited;
    }

    public void calculate(int row, int col) {
        this.character = this.grid.get(row).get(col);
        recursion(row, col);
        Set<Cell> above = new HashSet<>();
        Set<Cell> below = new HashSet<>();
        Set<Cell> left = new HashSet<>();
        Set<Cell> right = new HashSet<>();
        for (int r = 0; r < this.grid.size(); r++) {
            for (int c = 0; c < this.grid.get(0).size(); c++) {
                Cell cell = new Cell(r, c);
                if (this.visited.contains(cell)) {
                    if (cellAboveDoesNotContainCharacter(r, c)) {
                        if (cellLeftIsNotInSet(r, c, above)) {
                            this.edges++;
                        }
                        above.add(cell);
                    }
                    if (cellBelowDoesNotContainCharacter(r, c)) {
                        if (cellLeftIsNotInSet(r, c, below)) {
                            this.edges++;
                        }
                        below.add(cell);
                    }
                    if (cellLeftDoesNotContainCharacter(r, c)) {
                        if (cellAboveIsNotInSet(r, c, left)) {
                            this.edges++;
                        }
                        left.add(cell);
                    }
                    if (cellRightDoesNotContainCharacter(r, c)) {
                        if (cellAboveIsNotInSet(r, c, right)) {
                            this.edges++;
                        }
                        right.add(cell);
                    }
                }
            }
        }
    }

    private boolean cellAboveDoesNotContainCharacter(int row, int col) {
        return !inBounds(row -1, col, this.grid) || this.grid.get(row - 1).get(col) != this.character;
    }

    private boolean cellBelowDoesNotContainCharacter(int row, int col) {
        return !inBounds(row + 1, col, this.grid) || this.grid.get(row + 1).get(col) != this.character;
    }

    private boolean cellLeftDoesNotContainCharacter(int row, int col) {
        return !inBounds(row, col - 1, this.grid) || this.grid.get(row).get(col - 1) != this.character;
    }

    private boolean cellRightDoesNotContainCharacter(int row, int col) {
        return !inBounds(row, col + 1, this.grid) || this.grid.get(row).get(col + 1) != this.character;
    }

    private boolean cellLeftIsNotInSet(int row, int col, Set<Cell> set) {
        return !set.contains(new Cell(row, col - 1));
    }

    private boolean cellAboveIsNotInSet(int row, int col, Set<Cell> set) {
        return !set.contains(new Cell(row - 1, col));
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
        if (inBounds(row + 1, col, this.grid) && this.grid.get(row + 1).get(col) == this.character) {
            recursion(row + 1, col);
        }
        if (inBounds(row - 1, col, this.grid) && this.grid.get(row - 1).get(col) == this.character) {
            recursion(row - 1, col);
        }
        if (inBounds(row, col + 1, this.grid) && this.grid.get(row).get(col + 1) == this.character) {
            recursion(row, col + 1);
        }
        if (inBounds(row, col - 1, this.grid) && this.grid.get(row).get(col - 1) == this.character) {
            recursion(row, col - 1);
        }
        this.area++;
    }
}
