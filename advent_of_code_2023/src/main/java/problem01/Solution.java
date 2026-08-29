package problem01;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public int calculateCalibrationValueForLine(String input) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        char first = sb.charAt(0);
        char last = sb.charAt(sb.length()-1);
        return Integer.parseInt(String.valueOf(first) + last);
    }

    public int calculateCalibrationValueForLines(List<String> input) {
        int result = 0;
        for (String line : input) {
            result += calculateCalibrationValueForLine(line);
        }
        return result;
    }

    public int calculateCalibrationValueForLineWithWords(String input) {
        Pattern pattern = Pattern.compile("(?=([0-9]|one|two|three|four|five|six|seven|eight|nine))");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        Map<String, String> wordToDigit = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9"
        );
        while (matcher.find()) {
            if (wordToDigit.containsKey(matcher.group(1))) {
                sb.append(wordToDigit.get(matcher.group(1)));
            } else {
                sb.append(matcher.group(1));
            }
        }
        char first = sb.charAt(0);
        char last = sb.charAt(sb.length()-1);
        return Integer.parseInt(String.valueOf(first) + last);
    }

    public int calculateCalibrationValueForLinesWithWords(List<String> input) {
        int result = 0;
        for (String line : input) {
            result += calculateCalibrationValueForLineWithWords(line);
        }
        return result;
    }
}
