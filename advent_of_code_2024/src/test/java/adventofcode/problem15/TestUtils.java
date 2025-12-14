package adventofcode.problem15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Character>> loadGridFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Character>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            if (!line.isEmpty() && line.charAt(0) == '#') {
                result.add(new ArrayList<>());
                for (char c : line.toCharArray()) {
                    result.get(result.size()-1).add(c);
                }
            }
        }
        return result;
    }

    public List<List<Character>> loadGridFromFileForPartTwo(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Character>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            if (!line.isEmpty() && line.charAt(0) == '#') {
                result.add(new ArrayList<>());
                for (char c : line.toCharArray()) {
                    if (c == '@') {
                        result.get(result.size()-1).add('@');
                        result.get(result.size()-1).add('.');
                    } else if (c == 'O') {
                        result.get(result.size()-1).add('[');
                        result.get(result.size()-1).add(']');
                    } else {
                        result.get(result.size()-1).add(c);
                        result.get(result.size()-1).add(c);
                    }
                }
            }
        }
        return result;
    }

    public List<Command> loadCommandsFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Command> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            if (!line.isEmpty() && line.charAt(0) != '#') {
                for (char c : line.toCharArray()) {
                    if (c == '^') {
                        result.add(Command.UP);
                    } else if (c == '>') {
                        result.add(Command.RIGHT);
                    } else if (c == '<') {
                        result.add(Command.LEFT);
                    } else if (c == 'v') {
                        result.add(Command.DOWN);
                    }
                }
            }
        }
        return result;
    }
}