package adventofcode.year2024.problem24;

import adventofcode.year2024.problem23.Connection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
    public Map<String, Wire> loadWiresFromFile(String filename) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        Map<String, Wire> result = new HashMap<>();
        for (String line; (line = reader.readLine()) != null;) {
            Pattern pattern1 = Pattern.compile("([a-z0-9]+): ([0-1]+)");
            Matcher matcher1 = pattern1.matcher(line);
            if (matcher1.find()) {
                result.put(matcher1.group(1), new Wire(matcher1.group(2).equals("1") ? WireState.TRUE : WireState.FALSE, matcher1.group(1)));
            }
            Pattern pattern2 = Pattern.compile("([0-9a-z]+) (AND|OR|XOR) ([0-9a-z]+) -> ([0-9a-z]+)");
            Matcher matcher2 = pattern2.matcher(line);
            if (matcher2.find()) {
                if (!result.containsKey(matcher2.group(1))) {
                    result.put(matcher2.group(1), new Wire(WireState.UNKNOWN, matcher2.group(1)));
                }
                if (!result.containsKey(matcher2.group(3))) {
                    result.put(matcher2.group(3), new Wire(WireState.UNKNOWN, matcher2.group(3)));
                }
                if (!result.containsKey(matcher2.group(4))) {
                    result.put(matcher2.group(4), new Wire(WireState.UNKNOWN, matcher2.group(4)));
                }
            }
        }
        return result;
    }

    public List<Gate> loadGatesFromFile(String filename, Map<String, Wire> wires) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List<Gate> result = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            Pattern pattern = Pattern.compile("([0-9a-z]+) (AND|OR|XOR) ([0-9a-z]+) -> ([0-9a-z]+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (matcher.group(2).equals("AND")) {
                    result.add(new AndGate(wires.get(matcher.group(1)), wires.get(matcher.group(3)), wires.get(matcher.group(4))));
                } else if (matcher.group(2).equals("OR")) {
                    result.add(new OrGate(wires.get(matcher.group(1)), wires.get(matcher.group(3)), wires.get(matcher.group(4))));
                } else if (matcher.group(2).equals("XOR")) {
                    result.add(new XorGate(wires.get(matcher.group(1)), wires.get(matcher.group(3)), wires.get(matcher.group(4))));
                }
            }
        }
        return result;
    }

    public long convertBinaryStringToDecimalNumber(String s) {
        long multiplier = 1;
        long result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - '0') * multiplier;
            multiplier *= 2;
        }
        return result;
    }

    public String convertWiresToBinaryString(Map<String, Wire> wires) {
        List<String> wiresStartingWithZ = new ArrayList<>();
        for (Map.Entry<String, Wire> entry : wires.entrySet()) {
            if (entry.getKey().startsWith("z")) {
                wiresStartingWithZ.add(entry.getKey());
            }
        }
        List<String> sortedWires = wiresStartingWithZ.stream().sorted().toList();
        StringBuilder sb = new StringBuilder();
        for (String sortedWire : sortedWires) {
            if (wires.get(sortedWire).getState() == WireState.TRUE) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public void convertBinaryStringToWires(String s, String prefix, Map<String, Wire> wires) {
        for (Map.Entry<String, Wire> entry : wires.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                int i = Integer.parseInt(entry.getValue().getName().substring(1));
                entry.getValue().setState((s.charAt(i) == '1') ? WireState.TRUE : WireState.FALSE);
            }
        }
    }
}
