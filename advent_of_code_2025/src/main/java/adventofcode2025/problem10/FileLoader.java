package adventofcode2025.problem10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoader {
    public List<Machine> loadAndParse(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parse(lines);
    }

    private List<Machine> parse(List<String> lines) {
        List<Machine> result = new ArrayList<>();
        for (String line : lines) {
            List<Boolean> lights = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\[([.#]+)]");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String[] items = matcher.group(1).split("");
                for (String item : items) {
                    lights.add(item.equals("#"));
                }
            }
            List<List<Integer>> buttons = new ArrayList<>();
            pattern = Pattern.compile("\\((\\d(?:,\\d)*)\\)");
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                String[] items = matcher.group(1).split(",");
                List<Integer> presses = new ArrayList<>();
                for (String item : items) {
                    presses.add(Integer.parseInt(item));
                }
                buttons.add(presses);
            }
            List<Integer> joltageRequirements = new ArrayList<>();
            pattern = Pattern.compile("\\{(\\d+(?:,\\d+)*)}");
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                String[] items = matcher.group(1).split(",");
                for (String item : items) {
                    joltageRequirements.add(Integer.parseInt(item));
                }
            }
            result.add(new Machine(lights, buttons, joltageRequirements));
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
