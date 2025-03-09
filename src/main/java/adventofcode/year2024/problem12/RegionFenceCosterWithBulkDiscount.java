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

    public void calculate(int x, int y) {
        this.character = this.grid.get(y).get(x);
        recursion(x, y);
        Set<Cell> above = new HashSet<>();
        Set<Cell> below = new HashSet<>();
        Set<Cell> left = new HashSet<>();
        Set<Cell> right = new HashSet<>();
        for (int y1 = 0; y1 < this.grid.size(); y1++) {
            for (int x1 = 0; x1 < this.grid.get(0).size(); x1++) {
                Cell cell = new Cell(x1, y1);
                if (this.visited.contains(cell)) {
                    if (cellAboveDoesNotContainCharacter(x1, y1)) {
                        if (cellLeftIsNotInSet(x1, y1, above)) {
                            this.edges++;
                        }
                        above.add(cell);
                    }
                    if (cellBelowDoesNotContainCharacter(x1, y1)) {
                        if (cellLeftIsNotInSet(x1, y1, below)) {
                            this.edges++;
                        }
                        below.add(cell);
                    }
                    if (cellLeftDoesNotContainCharacter(x1, y1)) {
                        if (cellAboveIsNotInSet(x1, y1, left)) {
                            this.edges++;
                        }
                        left.add(cell);
                    }
                    if (cellRightDoesNotContainCharacter(x1, y1)) {
                        if (cellAboveIsNotInSet(x1, y1, right)) {
                            this.edges++;
                        }
                        right.add(cell);
                    }
                }
            }
        }
    }

    private boolean cellAboveDoesNotContainCharacter(int x, int y) {
        return !inBounds(x, y - 1, this.grid) || this.grid.get(y - 1).get(x) != this.character;
    }

    private boolean cellBelowDoesNotContainCharacter(int x, int y) {
        return !inBounds(x, y + 1, this.grid) || this.grid.get(y + 1).get(x) != this.character;
    }

    private boolean cellLeftDoesNotContainCharacter(int x, int y) {
        return !inBounds(x - 1, y, this.grid) || this.grid.get(y).get(x - 1) != this.character;
    }

    private boolean cellRightDoesNotContainCharacter(int x, int y) {
        return !inBounds(x + 1, y, this.grid) || this.grid.get(y).get(x + 1) != this.character;
    }

    private boolean cellLeftIsNotInSet(int x, int y, Set<Cell> set) {
        return !set.contains(new Cell(x - 1, y));
    }

    private boolean cellAboveIsNotInSet(int x, int y, Set<Cell> set) {
        return !set.contains(new Cell(x, y - 1));
    }

    private void recursion(int x, int y) {
        if (!inBounds(x, y, this.grid)) {
            return;
        }
        if (this.grid.get(y).get(x) != this.character) {
            return;
        }
        Cell cell = new Cell(x, y);
        if (this.visited.contains(cell)) {
            return;
        }
        this.visited.add(cell);
        if (inBounds(x + 1, y, this.grid) && this.grid.get(y).get(x + 1) == this.character) {
            recursion(x + 1, y);
        }
        if (inBounds(x - 1, y, this.grid) && this.grid.get(y).get(x - 1) == this.character) {
            recursion(x - 1, y);
        }
        if (inBounds(x, y + 1, this.grid) && this.grid.get(y + 1).get(x) == this.character) {
            recursion(x, y + 1);
        }
        if (inBounds(x, y - 1, this.grid) && this.grid.get(y - 1).get(x) == this.character) {
            recursion(x, y - 1);
        }
        this.area++;
    }
}
