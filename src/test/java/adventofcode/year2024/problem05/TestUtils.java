package adventofcode.year2024.problem05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public TestInput loadFile(String filename) throws Exception {
        List<PageOrdering> pageOrderings = new ArrayList<>();
        List<List<Integer>> sections = new ArrayList<>();
        boolean populatingPageOrderings = true;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            if (line.isEmpty()) {
                populatingPageOrderings = false;
            } else if (populatingPageOrderings) {
                String[] parts = line.split("\\|");
                int firstPart = Integer.parseInt(parts[0]);
                int secondPart = Integer.parseInt(parts[1]);
                pageOrderings.add(new PageOrdering(firstPart, secondPart));
            } else {
                String[] parts = line.split(",");
                List<Integer> section = new ArrayList<>();
                for (String part : parts) {
                    section.add(Integer.parseInt(part));
                }
                sections.add(section);
            }
        }
        return new TestInput(pageOrderings, sections);
    }
}
