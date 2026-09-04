package problem02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    public List<Game> loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Game> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            List<Reveal> reveals = new ArrayList<>();
            String[] sections1 = line.split(":");
            String allRevealsString = sections1[1];
            String[] revealsString = allRevealsString.split(";");
            for (String revealString : revealsString) {
                int red = 0;
                int green = 0;
                int blue = 0;
                String[] colorCountsString = revealString.split(",");
                for (String colorCountString : colorCountsString) {
                    String[] colorString = colorCountString.split(" ");
                    if (colorString[2].equals("red")) {
                        red = Integer.parseInt(colorString[1]);
                    } else if (colorString[2].equals("green")) {
                        green = Integer.parseInt(colorString[1]);
                    } else if (colorString[2].equals("blue")) {
                        blue = Integer.parseInt(colorString[1]);
                    }
                }
                reveals.add(new Reveal(red, green, blue));
            }
            int id = 0;
            Pattern pattern = Pattern.compile("Game ([0-9]+):.*");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));
            }
            result.add(new Game(id, reveals));
        }
        return result;
    }
}
