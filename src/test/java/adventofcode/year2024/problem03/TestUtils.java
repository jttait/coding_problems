package adventofcode.year2024.problem03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TestUtils {
    public String loadFileToListOfStrings(String filename) throws Exception {
        StringBuilder result = new StringBuilder();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            result.append(line);
        }
        return result.toString();
    }
}
