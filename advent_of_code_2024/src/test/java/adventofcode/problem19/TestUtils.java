package adventofcode.problem19;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public List<String> loadAvailableTowelsFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = reader.readLine();
        String[] arr = line.split(", ");
        return new ArrayList<>(Arrays.asList(arr));
    }

    public List<String> loadDesignsFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        reader.readLine();
        reader.readLine();
        List<String> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            result.add(line);
        }
        return result;
    }
}
