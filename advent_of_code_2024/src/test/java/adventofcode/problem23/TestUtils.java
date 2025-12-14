package adventofcode.problem23;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    public Set<Connection> loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        Set<Connection> result = new HashSet<>();
        for (String line; (line = reader.readLine()) != null;) {
            Pattern pattern = Pattern.compile("([a-z]+)-([a-z]+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                result.add(new Connection(matcher.group(1), matcher.group(2)));
            }
        }
        return result;
    }
}
