package adventofcode.year2024.problem24;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PartTwoTest {
    @Test
    void sorter() throws Exception {
        for (int i = 0; i < 45; i++) {
            String wire = "z" + ((i < 10) ? "0" + i : i);
            System.out.println("## " + wire + " ##");
            dfs(wire, 0);
            System.out.println();
        }
    }

    private void dfs(String wire, int depth) throws Exception {
        if (depth >= 3) {
            return;
        }
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("adventofcode/year2024/problem24_input_fixed.txt");
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        for (String line; (line = reader.readLine()) != null;) {
            Pattern pattern = Pattern.compile("([0-9a-z]+) (AND|OR|XOR) ([0-9a-z]+) -> ([0-9a-z]+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (matcher.group(4).equals(wire)) {
                    System.out.println(line);
                    dfs(matcher.group(1), depth + 1);
                    dfs(matcher.group(3), depth + 1);
                }
            }
        }
    }
}