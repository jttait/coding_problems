package adventofcode.year2024.problem14;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    public List<Robot> loadFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Robot> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            Pattern pattern = Pattern.compile("p=([-]*[0-9]+),([-]*[0-9]+) v=([-]*[0-9]+),([-]*[0-9]+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                int num3 = Integer.parseInt(matcher.group(3));
                int num4 = Integer.parseInt(matcher.group(4));
                result.add(new Robot(num1, num2, num3, num4));
            }
        }
        return result;
    }
}