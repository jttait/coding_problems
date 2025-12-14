package adventofcode.problem12;

import adventofcode.common.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static adventofcode.common.Utils.inBounds;

public class RegionFenceCoster {
    private int area;
    private int perimeter;
    private final List<List<Character>> grid;
    private Character character;
    private Set<Position> visited;

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

    public Set<Position> getVisited() {
        return this.visited;
    }

    public void calculate(int x, int y) {
        this.character = this.grid.get(y).get(x);
        recursion(x, y);
    }

    private void recursion(int x, int y) {
        if (!inBounds(x, y, this.grid)) {
            return;
        }
        if (this.grid.get(y).get(x) != this.character) {
            return;
        }
        Position position = new Position(x, y);
        if (this.visited.contains(position)) {
            return;
        }
        this.visited.add(position);
        int adjacentCells = 0;
        if (inBounds(x + 1, y, this.grid) && this.grid.get(y).get(x + 1) == this.character) {
            recursion(x + 1, y);
            adjacentCells++;
        }
        if (inBounds(x - 1, y, this.grid) && this.grid.get(y).get(x - 1) == this.character) {
            recursion(x - 1, y);
            adjacentCells++;
        }
        if (inBounds(x, y + 1, this.grid) && this.grid.get(y + 1).get(x) == this.character) {
            recursion(x, y + 1);
            adjacentCells++;
        }
        if (inBounds(x, y - 1, this.grid) && this.grid.get(y - 1).get(x) == this.character) {
            recursion(x, y - 1);
            adjacentCells++;
        }
        this.area++;
        this.perimeter += 4 - adjacentCells;
    }
}
