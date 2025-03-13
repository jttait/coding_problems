package adventofcode.year2024.problem21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {
    public int shortestPath(List<Character> buttons) {
        Keypad numericKeypad = new Keypad(Grid.NUMERIC);
        Keypad directionalKeypad = new Keypad(Grid.DIRECTIONAL);

        List<List<Character>> shortestPathsForDepressurisedKeypad = cartesianProduct(numericKeypad, buttons);

        List<List<Character>> hello = new ArrayList<>();
        for (List<Character> list : shortestPathsForDepressurisedKeypad) {
            hello.addAll(cartesianProduct(directionalKeypad, list));
        }

        int minLength = hello.stream().map(List::size).min(Comparator.comparingInt(a -> a)).get();
        hello = hello.stream().filter(a -> a.size() == minLength).collect(Collectors.toList());

        int result = Integer.MAX_VALUE;
        for (List<Character> list : hello) {
            List<List<Character>> shortest = cartesianProduct(directionalKeypad, list);
            int minLength2 = shortest.stream().map(List::size).min(Comparator.comparingInt(a -> a)).get();
            result = Math.min(result, minLength2);
        }

        return result;
    }

    private List<List<Character>> cartesianProduct(Keypad keypad, List<Character> buttons) {
        List<List<Character>> shortestPaths = keypad.shortestPaths('A', buttons.get(0));
        char current = buttons.get(0);
        for (int i = 1; i < buttons.size(); i++) {
            List<List<Character>> paths = keypad.shortestPaths(current, buttons.get(i));
            List<List<Character>> shortestPaths2 = new ArrayList<>();
            for (List<Character> shortestPath : shortestPaths) {
                for (List<Character> path : paths) {
                    List<Character> shortestPath2 = new ArrayList<>(shortestPath);
                    shortestPath2.addAll(path);
                    shortestPaths2.add(List.copyOf(shortestPath2));
                    shortestPath2.subList(shortestPath2.size() - path.size(), shortestPath2.size());
                }
            }
            shortestPaths = shortestPaths2;
            current = buttons.get(i);
        }
        return shortestPaths;
    }
}
