package problem03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private final List<List<Character>> grid;
    private final Set<Symbol> symbols;
    private final Set<Number> numbers;

    public Solution(List<List<Character>> grid) {
        this.grid = grid;
        this.symbols = populateSymbols();
        this.numbers = populateNumbers();
    }

    public int sumParts() {
        int result = 0;
        for (Number number : numbers) {
            if (number.isTouchingSymbol()) {
                result += number.num();
            }
        }
        return result;
    }

    private Set<Symbol> populateSymbols() {
        Set<Symbol> result = new HashSet<>();
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.getFirst().size(); col++) {
                char c = grid.get(row).get(col);
                if (!Character.isDigit(c) && c != '.') {
                    result.add(new Symbol(c, row, col));
                }
            }
        }
        return result;
    }

    private Set<Number> populateNumbers() {
        Set<Number> result = new HashSet<>();
        for (int row = 0; row < grid.size(); row++) {
            int col = 0;
            while (col < grid.getFirst().size()) {
                char c = grid.get(row).get(col);
                if (Character.isDigit(c)) {
                    int startCol = col;
                    StringBuilder sb = new StringBuilder();
                    while (col < grid.getFirst().size() && Character.isDigit(grid.get(row).get(col))) {
                        c = grid.get(row).get(col);
                        sb.append(c);
                        col++;
                    }
                    int num = Integer.parseInt(sb.toString());
                    int endCol = col - 1;
                    if (isTouchingSymbol(row, startCol, endCol)) {
                        result.add(new Number(num, row, startCol, endCol, isTouchingSymbol(row, startCol, endCol)));
                    }
                } else {
                    col++;
                }
            }
        }
        return result;
    }

    private boolean isTouchingSymbol(int row, int startCol, int endCol) {
        int startRow = Math.max(row - 1, 0);
        startCol = Math.max(startCol - 1, 0);
        int endRow = Math.min(row + 1, grid.size() - 1);
        endCol = Math.min(endCol + 1, grid.get(0).size() - 1);
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                char ch = grid.get(r).get(c);
                if (!Character.isDigit(ch) && ch != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Number> findTouchingNumbers(int row, int col) {
        int startRow = Math.max(row - 1, 0);
        int endRow = Math.min(row + 1, grid.size() - 1);
        int startCol = Math.max(col - 1, 0);
        int endCol = Math.min(col + 1, grid.getFirst().size() - 1);
        Set<Number> result = new HashSet<>();

        for (Number number : numbers) {
            if (number.row() >= startRow
                    && number.row() <= endRow
                    && startCol <= number.endCol()
                    && endCol >= number.startCol()) {
                result.add(number);
            }
        }
        return result;
    }

    public int findGearRatio() {
        int result = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.getFirst().size(); col++) {
                char c = grid.get(row).get(col);
                if (c == '*') {
                    Set<Number> touchingNumbers = findTouchingNumbers(row, col);
                    if (touchingNumbers.size() == 2) {
                        int product = 1;
                        for (Number number : touchingNumbers) {
                            product *= number.num();
                        }
                        result += product;
                    }
                }
            }
        }
        return result;
    }
}
