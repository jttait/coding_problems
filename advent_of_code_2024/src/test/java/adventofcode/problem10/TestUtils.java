package adventofcode.problem10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Integer>> loadFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Integer>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            result.add(new ArrayList<>());
            for (char c : line.toCharArray()) {
                result.get(result.size()-1).add(c - '0');
            }
        }
        return result;
    }
}
