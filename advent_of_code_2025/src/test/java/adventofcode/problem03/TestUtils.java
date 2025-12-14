package adventofcode.problem03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Integer>> loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Integer>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            String[] characters = line.split("");
            List<Integer> digits = new ArrayList<>();
            for (String c : characters) {
                int i = Integer.parseInt(c);
                digits.add(i);
            }
            result.add(digits);
        }
        return result;
    }
}
