package adventofcode.year2025.problem05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {
    public IngredientsDatabase loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Range> freshIngredients = new ArrayList<>();
        Set<Long> availableIngredients = new HashSet<>();
        boolean fresh = true;
        for (String line; (line = reader.readLine()) != null;) {
            if (line.isEmpty()) {
                fresh = false;
            } else if (fresh) {
                String[] split = line.split("-");
                long start = Long.parseLong(split[0]);
                long end = Long.parseLong(split[1]);
                freshIngredients.add(new Range(start, end));
            } else {
                availableIngredients.add(Long.parseLong(line));
            }
        }
        return new IngredientsDatabase(freshIngredients, availableIngredients);
    }
}
