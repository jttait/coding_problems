package leetcode.problem2812;

import java.util.*;

public class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        List<Cell> thieves = findThieves(grid);
        int[][] safenessGrid = generateSafenessGrid(thieves, grid.size(), grid.get(0).size());
        return findMaximumSafeness(safenessGrid);
    }

    private int findMaximumSafeness(int[][] safenessGrid) {
        int result = safenessGrid[0][0];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> b.getSafeness() - a.getSafeness());
        Set<String> seen = new HashSet<>();
        pq.add(new Cell(0, 0, safenessGrid[0][0]));
        seen.add("0,0");
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int currentRow = current.getRow();
            int currentCol = current.getCol();
            int currentSafeness = current.getSafeness();
            result = Math.min(result, currentSafeness);
            if (currentRow == safenessGrid.length-1 && currentCol == safenessGrid[0].length-1) {
                return result;
            }
            if (currentRow - 1 >= 0 && !seen.contains((currentRow-1) + "," + currentCol)) {
                pq.add(new Cell(currentRow-1, currentCol, safenessGrid[currentRow-1][currentCol]));
                seen.add((currentRow-1) + "," + currentCol);
            }
            if (currentCol - 1 >= 0 && !seen.contains(currentRow + "," + (currentCol-1))) {
                pq.add(new Cell(currentRow, currentCol-1, safenessGrid[currentRow][currentCol-1]));
                seen.add(currentRow + "," + (currentCol-1));
            }
            if (currentRow + 1 < safenessGrid.length && !seen.contains((currentRow+1) + "," + currentCol)) {
                pq.add(new Cell(currentRow + 1, currentCol, safenessGrid[currentRow+1][currentCol]));
                seen.add((currentRow+1) + "," + currentCol);
            }
            if (currentCol + 1 < safenessGrid[0].length && !seen.contains(currentRow + "," + (currentCol+1))) {
                pq.add(new Cell(currentRow, currentCol + 1, safenessGrid[currentRow][currentCol+1]));
                seen.add(currentRow + "," + (currentCol+1));
            }
        }
        return -1;
    }

    private int[][] generateSafenessGrid(List<Cell> thieves, int numRows, int numCols) {
        int[][] safenessGrid = new int[numRows][numCols];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(Cell::getSafeness));
        pq.addAll(thieves);
        Set<String> seen = new HashSet<>();
        for (Cell thief : thieves) {
            seen.add(thief.getRow() + "," + thief.getCol());
        }
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int currentRow = current.getRow();
            int currentCol = current.getCol();
            int currentSafeness = current.getSafeness();
            if (safenessGrid[currentRow][currentCol] == 0) {
                safenessGrid[currentRow][currentCol] = currentSafeness;
            }
            if (currentRow - 1 >= 0 && !seen.contains((currentRow-1) + "," + currentCol)) {
                pq.add(new Cell(currentRow-1, currentCol, currentSafeness+1));
                seen.add((currentRow-1) + "," + currentCol);
            }
            if (currentCol - 1 >= 0 && !seen.contains(currentRow + "," + (currentCol-1))) {
                pq.add(new Cell(currentRow, currentCol-1, currentSafeness+1));
                seen.add(currentRow + "," + (currentCol-1));
            }
            if (currentRow + 1 < numRows && !seen.contains((currentRow+1) + "," + currentCol)) {
                pq.add(new Cell(currentRow + 1, currentCol, currentSafeness+1));
                seen.add((currentRow+1) + "," + currentCol);
            }
            if (currentCol + 1 < numCols && !seen.contains(currentRow + "," + (currentCol+1))) {
                pq.add(new Cell(currentRow, currentCol + 1, currentSafeness+1));
                seen.add(currentRow + "," + (currentCol+1));
            }
        }
        return safenessGrid;
    }

    private List<Cell> findThieves(List<List<Integer>> grid) {
        List<Cell> result = new ArrayList<>();
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == 1) {
                    result.add(new Cell(row, col));
                }
            }
        }
        return result;
    }
}
