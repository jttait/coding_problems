package adventofcode.problem08;

import adventofcode.common.Position;

import java.util.*;

public class PartOne {
    public int countAntiNodes(List<List<Character>> grid) {
        Map<Character, Set<Position>> antennas = new HashMap<>();
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                char c = grid.get(y).get(x);
                if (c != '.') {
                    antennas.putIfAbsent(c, new HashSet<>());
                    antennas.get(c).add(new Position(x, y));
                }
            }
        }
        Set<Position> result = new HashSet<>();
        for (char antennaType : antennas.keySet()) {
            for (Position antenna1 : antennas.get(antennaType)) {
                for (Position antenna2 : antennas.get(antennaType)) {
                    if (antenna1 != antenna2) {
                        int rowDiff = antenna1.y() - antenna2.y();
                        int colDiff = antenna1.x() - antenna2.x();
                        int newRow = antenna1.y() + rowDiff;
                        int newCol = antenna1.x() + colDiff;
                        if (inBounds(newRow, newCol, grid)) {
                            result.add(new Position(newRow, newCol));
                        }
                    }
                }
            }
        }
        return result.size();
    }

    private boolean inBounds(int x, int y, List<List<Character>> grid) {
        return (x >= 0 && y >= 0 && x < grid.size() && y < grid.get(0).size());
    }
}
