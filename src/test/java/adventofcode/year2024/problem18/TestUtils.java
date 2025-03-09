package adventofcode.year2024.problem18;

import adventofcode.year2024.common.Position;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    public List<Position> loadFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Position> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                result.add(new Position(y, x));
            }
        }
        return result;
    }
}
