package adventofcode.year2024.problem8;

import java.util.*;

public class PartTwo {
    public int countAntinodes(List<List<Character>> grid) {
        Map<Character, Set<Position>> antennas = new HashMap<>();
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                char c = grid.get(row).get(col);
                if (c != '.') {
                    antennas.putIfAbsent(c, new HashSet<>());
                    antennas.get(c).add(new Position(row, col));
                }
            }
        }
        Set<Position> result = new HashSet<>();
        for (char antennaType : antennas.keySet()) {
            for (Position antenna1 : antennas.get(antennaType)) {
                for (Position antenna2 : antennas.get(antennaType)) {
                    if (antenna1 != antenna2) {
                        result.add(new Position(antenna2.row(), antenna2.col()));
                        int rowDiff = antenna1.row() - antenna2.row();
                        int colDiff = antenna1.col() - antenna2.col();
                        int newRow = antenna1.row() + rowDiff;
                        int newCol = antenna1.col() + colDiff;
                        while (inBounds(newRow, newCol, grid)) {
                            result.add(new Position(newRow, newCol));
                            newRow += rowDiff;
                            newCol += colDiff;
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
