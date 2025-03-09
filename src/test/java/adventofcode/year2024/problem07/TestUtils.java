package adventofcode.year2024.problem07;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public List<Equation> loadFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Equation> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            String[] splitByColon = line.split(": ");
            BigInteger testValue = new BigInteger(splitByColon[0]);
            String[] splitBySpace = splitByColon[1].split(" ");
            List<BigInteger> numbers = new ArrayList<>();
            for (String num : splitBySpace) {
                numbers.add(new BigInteger(num));
            }
            result.add(new Equation(testValue, numbers));
        }
        return result;
    }
}
