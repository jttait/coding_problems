package adventofcode2025.problem12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoader {
    public Problem loadAndParse(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parse(lines);
    }

    private Problem parse(List<String> lines) {
        List<Integer> presentSizes = new ArrayList<>();
        List<Tree> trees = new ArrayList<>();
        int i = 0;
        while (i < lines.size()) {
            if (lines.get(i).matches("\\d+:")) {
                int hashes = 0;
                i++;
                for (String s : lines.get(i).split("")) {
                    if (s.equals("#")) {
                        hashes++;
                    }
                }
                i++;
                for (String s : lines.get(i).split("")) {
                    if (s.equals("#")) {
                        hashes++;
                    }
                }
                i++;
                for (String s : lines.get(i).split("")) {
                    if (s.equals("#")) {
                        hashes++;
                    }
                }
                presentSizes.add(hashes);
            } else if (lines.get(i).matches("(\\d+)x(\\d+): (.+)")) {
                Pattern pattern = Pattern.compile("(\\d+)x(\\d+): (.+)");
                Matcher matcher = pattern.matcher(lines.get(i));
                if (matcher.find()) {
                    int height = Integer.parseInt(matcher.group(1));
                    int width = Integer.parseInt(matcher.group(2));
                    String[] values = matcher.group(3).split(" ");
                    List<Integer> presents = new ArrayList<>();
                    for (String value : values) {
                        presents.add(Integer.parseInt(value));
                    }
                    trees.add(new Tree(presents, height, width));
                }
            }
            i++;
        }
        return new Problem(trees, presentSizes);
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
}
