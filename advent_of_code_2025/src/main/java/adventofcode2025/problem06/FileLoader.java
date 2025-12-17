package adventofcode2025.problem06;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileLoader {
    public List<Problem> loadProblemsFromFile(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parseLinesIntoProblems(lines);
    }

    public List<Problem> loadProblemsFromFileForPartTwo(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parseLinesIntoProblemsForPartTwo(lines);
    }

    private List<String> loadLines(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<String> lines = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            lines.add(line);
        }
        return lines;
    }

    private List<List<String>> splitLines(List<String> lines) {
        List<List<String>> result = new ArrayList<>();
        for (String line : lines) {
            result.add(new ArrayList<>());
            String[] splitLine = line.split(" ");
            for (String item : splitLine) {
                if (!item.isEmpty()) {
                    result.get(result.size() - 1).add(item);
                }
            }
        }
        return result;
    }

    private List<List<String>> transpose(List<List<String>> rows) {
        int numCols = rows.get(0).size();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < numCols; i++) {
            result.add(new ArrayList<>());
        }
        for (List<String> row : rows) {
            for (int j = 0; j < numCols; j++) {
                result.get(j).add(row.get(j));
            }
        }
        return result;
    }

    public List<Problem> parseLinesIntoProblems(List<String> lines) {
        List<List<String>> rows = splitLines(lines);
        List<List<String>> cols = transpose(rows);
        List<Problem> result = new ArrayList<>();
        for (List<String> col : cols) {
            List<Long> numbers = new ArrayList<>();
            for (int i = 0; i < col.size() - 1; i++) {
                numbers.add(Long.parseLong(col.get(i)));
            }
            Operation operation = col.get(col.size() - 1).charAt(0) == '*' ? Operation.MULTIPLY : Operation.ADD;
            result.add(new Problem(numbers, operation));
        }
        return result;
    }

    public List<Problem> parseLinesIntoProblemsForPartTwo(List<String> lines) {
        int maxCol = 0;
        for (String line : lines) {
            maxCol = Math.max(maxCol, line.length());
        }
        List<Problem> result = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        Operation operation = null;
        for (int col = 0; col < maxCol; col++) {
            if (col < lines.get(lines.size() - 1).length() && lines.get(lines.size()-1).charAt(col) != ' ') {
                operation = lines.get(lines.size() - 1).charAt(col) == '*' ? Operation.MULTIPLY : Operation.ADD;
            }
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < lines.size() - 1; row++) {
                if (col < lines.get(row).length() && lines.get(row).charAt(col) != ' ') {
                    sb.append(lines.get(row).charAt(col));
                }
            }
            if (sb.isEmpty()) {
                Collections.reverse(numbers);
                result.add(new Problem(List.copyOf(numbers), operation));
                numbers = new ArrayList<>();
            } else {
                numbers.add(Long.parseLong(sb.toString()));
            }
        }
        result.add(new Problem(numbers, operation));
        return result;
    }
}
