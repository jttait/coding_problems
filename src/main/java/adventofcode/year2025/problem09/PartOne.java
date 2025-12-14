package adventofcode.year2025.problem09;

import java.util.List;

public class PartOne {
    private final List<Tile> tiles;

    public PartOne(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public long calculateLargestRectangle() {
        long result = 0;
        for (int i = 0; i < tiles.size(); i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                long xDiff = Math.abs(tiles.get(i).x() - tiles.get(j).x()) + 1;
                long yDiff = Math.abs(tiles.get(i).y() - tiles.get(j).y()) + 1;
                long area = xDiff * yDiff;
                result = Math.max(result, area);
            }
        }
        return result;
    }
}
