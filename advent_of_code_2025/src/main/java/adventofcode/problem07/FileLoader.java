package adventofcode.problem07;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public List<List<Character>> loadAndParse(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parse(lines);
    }

    public List<List<Character>> parse(List<String> lines) {
        List<List<Character>> result = new ArrayList<>();
        for (String line : lines) {
            result.add(new ArrayList<>());
            String[] elements = line.split("");
            for (String element : elements) {
                result.get(result.size()-1).add(element.charAt(0));
            }
        }
        return result;
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
