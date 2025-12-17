package adventofcode2025.problem09;

import java.util.*;

public class PartTwo {
    private final List<Tile> tiles;
    private final Set<Tile> boundary;

    public PartTwo(List<Tile> tiles) {
        this.tiles = tiles;
        this.boundary = calculateBoundary();
    }

    public long calculateLargestRectangle() {
        long result = 0;
        for (int i = 0; i < tiles.size(); i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                if (isValid(tiles.get(i), tiles.get(j))) {
                    long xDiff = tiles.get(i).x() - tiles.get(j).x();
                    long yDiff = tiles.get(i).y() - tiles.get(j).y();
                    long xDiffAbs = Math.abs(xDiff) + 1;
                    long yDiffAbs = Math.abs(yDiff) + 1;
                    long area = xDiffAbs * yDiffAbs;
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    private Set<Tile> calculateBoundary() {
        Set<Tile> result = new HashSet<>();
        for (int i = 0; i < tiles.size() - 1; i++) {
            addBoundaryBetween(tiles.get(i), tiles.get(i+1), result);
        }
        addBoundaryBetween(tiles.get(tiles.size()-1), tiles.get(0), result);
        for (int i = 0; i < tiles.size() - 1; i++) {
            removeTilesOnEdge(tiles.get(i), tiles.get(i+1), result);
        }
        removeTilesOnEdge(tiles.get(tiles.size()-1), tiles.get(0), result);
        return result;
    }

    private void addBoundaryBetween(Tile tile1, Tile tile2, Set<Tile> result) {
        int x = tile1.x();
        int y = tile1.y();
        if (x == tile2.x() && y > tile2.y()) { // up
            while (y >= tile2.y()) {
                result.add(new Tile(x-1, y));
                y--;
            }
        } else if (x == tile2.x() && y < tile2.y()) { // down
            while (y <= tile2.y()) {
                result.add(new Tile(x+1, y));
                y++;
            }
        } else if (y == tile2.y() && x > tile2.x()) { // left
            while (x >= tile2.x()) {
                result.add(new Tile(x, y+1));
                x--;
            }
        } else { // right
            while (x <= tile2.x()) {
                result.add(new Tile(x, y-1));
                x++;
            }
        }
    }

    private void removeTilesOnEdge(Tile tile1, Tile tile2, Set<Tile> result) {
        int x = tile1.x();
        int y = tile1.y();
        if (x == tile2.x() && y > tile2.y()) { // up
            while (y >= tile2.y()) {
                result.remove(new Tile(x, y));
                y--;
            }
        } else if (x == tile2.x() && y < tile2.y()) { // down
            while (y <= tile2.y()) {
                result.remove(new Tile(x, y));
                y++;
            }
        } else if (y == tile2.y() && x > tile2.x()) { // left
            while (x >= tile2.x()) {
                result.remove(new Tile(x, y));
                x--;
            }
        } else { // right
            while (x <= tile2.x()) {
                result.remove(new Tile(x, y));
                x++;
            }
        }
    }

    private boolean isValid(Tile tile1, Tile tile2) {
        int topLeftX = Math.min(tile1.x(), tile2.x());
        int topLeftY = Math.min(tile1.y(), tile2.y());
        int bottomRightX = Math.max(tile1.x(), tile2.x());
        int bottomRightY = Math.max(tile1.y(), tile2.y());
        for (int x = topLeftX; x < bottomRightX; x++) {
            if (boundary.contains(new Tile(x, topLeftY))) {
                return false;
            }
            if (boundary.contains(new Tile(x, bottomRightY))) {
                return false;
            }
        }
        for (int y = topLeftY; y < bottomRightY; y++) {
            if (boundary.contains(new Tile(topLeftX, y))) {
                return false;
            }
            if (boundary.contains(new Tile(bottomRightX, y))) {
                return false;
            }
        }
        return true;
    }
}
