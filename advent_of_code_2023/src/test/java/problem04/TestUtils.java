package problem04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class TestUtils {
    public List<Scratchcard> loadFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Scratchcard> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            String[] splits = line.split("\\s+");
            Set<Integer> winningNumbers = new HashSet<>();
            int index = Integer.parseInt(splits[1].substring(0, splits[1].length()-1));
            for (int i = 2; i <= 11; i++) {
                int num = Integer.parseInt(splits[i]);
                winningNumbers.add(num);
            }
            Set<Integer> numbersYouHave = new HashSet<>();
            for (int i = 13; i <= 37; i++) {
                int num = Integer.parseInt(splits[i]);
                numbersYouHave.add(num);
            }
            result.add(new Scratchcard(index, winningNumbers, numbersYouHave));
        }
        return result;
    }
}