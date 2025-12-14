package adventofcode.problem25;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<List<Integer>> loadLocksFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Integer>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            if (line.equals("#####")) {
                result.add(readLock(reader));
            } else {
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
            }
        }
        return result;
    }

    private List<Integer> readLock(BufferedReader reader) throws Exception {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(0);
        }
        String line2 = reader.readLine();
        while (line2 != null && !line2.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                if (line2.charAt(i) == '#') {
                    result.set(i, result.get(i) + 1);
                }
            }
            line2 = reader.readLine();
        }
        return result;
    }

    public List<List<Integer>> loadKeysFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Integer>> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            if (line.equals(".....")) {
                result.add(readKey(reader));
            } else {
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
            }
        }
        return result;
    }

    private List<Integer> readKey(BufferedReader reader) throws Exception {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(5);
        }
        String line2 = reader.readLine();
        while (line2 != null && !line2.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                if (line2.charAt(i) == '.') {
                    result.set(i, result.get(i) - 1);
                }
            }
            line2 = reader.readLine();
        }
        return result;
    }
}
