package adventofcode.year2024.problem13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    public List<List<Integer>> loadFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<List<Integer>> result = new ArrayList<>();
        int lineCounter = 0;
        for (String line; (line = reader.readLine()) != null;) {
            if (lineCounter % 4 == 0) {
                result.add(new ArrayList<>());
                Pattern pattern = Pattern.compile("Button A: X\\+([0-9]+), Y\\+([0-9]+)");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    result.get(result.size() - 1).add(num1);
                    int num2 = Integer.parseInt(matcher.group(2));
                    result.get(result.size() - 1).add(num2);
                }
            } else if (lineCounter % 4 == 1) {
                Pattern pattern = Pattern.compile("Button B: X\\+([0-9]+), Y\\+([0-9]+)");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    result.get(result.size() - 1).add(num1);
                    int num2 = Integer.parseInt(matcher.group(2));
                    result.get(result.size() - 1).add(num2);
                }
            } else if (lineCounter % 4 == 2) {
                Pattern pattern = Pattern.compile("Prize: X=([0-9]+), Y=([0-9]+)");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    result.get(result.size() - 1).add(num1);
                    int num2 = Integer.parseInt(matcher.group(2));
                    result.get(result.size() - 1).add(num2);
                }
            }
            lineCounter++;
        }
        return result;
    }
}