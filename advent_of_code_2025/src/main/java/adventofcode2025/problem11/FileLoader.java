package adventofcode2025.problem11;

import adventofcode2025.problem10.Machine;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoader {
    public Map<String, Set<String>> loadAndParse(String filename) throws Exception {
        List<String> lines = loadLines(filename);
        return parse(lines);
    }

    private Map<String, Set<String>> parse(List<String> lines) {
        Map<String, Set<String>> result = new HashMap<>();
        for (String line : lines) {
            Pattern pattern = Pattern.compile("(.+):(.+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String key = matcher.group(1);
                result.put(key, new HashSet<>());
                String[] values = matcher.group(2).split(" ");
                for (String value : values) {
                    result.get(key).add(value);
                }
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
