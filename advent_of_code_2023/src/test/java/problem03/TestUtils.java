package problem03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Character>> loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Character>> result = new ArrayList<>();
        int row = 0;
        for (String line; (line = reader.readLine()) != null;) {
            result.add(new ArrayList<>());
            for (char c : line.toCharArray()) {
                result.get(row).add(c);
            }
            row++;
        }
        return result;
    }
}
