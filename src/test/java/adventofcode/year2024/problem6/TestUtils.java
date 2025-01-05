package adventofcode.year2024.problem6;

import adventofcode.year2024.problem5.PageOrdering;
import adventofcode.year2024.problem5.TestInput;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Character>> loadFile(String filename) throws Exception {
        List<List<Character>> result = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            result.add(new ArrayList<>());
            for (char c : line.toCharArray()) {
                result.get(result.size()-1).add(c);
            }
        }
        return result;
    }
}
