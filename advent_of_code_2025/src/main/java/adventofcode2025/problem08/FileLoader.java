package adventofcode2025.problem08;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public List<JunctionBox> loadAndParse(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parse(lines);
    }

    public List<JunctionBox> parse(List<String> lines) {
        List<JunctionBox> result = new ArrayList<>();
        for (String line : lines) {
            String[] items = line.split(",");
            long x = Integer.parseInt(items[0]);
            long y = Integer.parseInt(items[1]);
            long z = Integer.parseInt(items[2]);
            result.add(new JunctionBox(x, y, z));
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
