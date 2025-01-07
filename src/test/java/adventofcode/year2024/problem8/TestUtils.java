package adventofcode.year2024.problem8;

import adventofcode.year2024.problem7.Equation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Character>> loadFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Character>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            result.add(new ArrayList<>());
            for (char c : line.toCharArray()) {
                result.get(result.size()-1).add(c);
            }
        }
        return result;
    }
}
