package adventofcode2025.problem02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Long>> loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = reader.readLine();
        String[] ranges = line.split(",");
        List<List<Long>> result = new ArrayList<>();
        for (String range : ranges) {
            String[] ends = range.split("-");
            long start = Long.parseLong(ends[0]);
            long end = Long.parseLong(ends[1]);
            result.add(List.of(start, end));
        }
        return result;
    }
}
