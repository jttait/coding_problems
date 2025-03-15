package adventofcode.year2024.problem21;

import java.util.*;

public class PartTwo {
    private final List<Keypad2> keypads;

    public PartTwo(int numRobotControlledKeypads) {
        this.keypads = new ArrayList<>();
        keypads.add(new Keypad2(Grid.NUMERIC));
        for (int i = 0; i < numRobotControlledKeypads; i++) {
            keypads.add(new Keypad2(Grid.DIRECTIONAL));
        }
        for (int i = 0; i < keypads.size() - 1; i++) {
            keypads.get(i).setPrecedingKeypad(keypads.get(i + 1));
        }
    }

    public long solve(String s) {
        char[] array = s.toCharArray();
        List<Character> buttons = new ArrayList<>();
        buttons.add('A');
        for (char c : array) {
            buttons.add(c);
        }
        long result = 0;
        for (int i = 0; i < buttons.size() - 1; i++) {
            result += keypads.get(0).solve(buttons.get(i), buttons.get(i + 1));
        }
        return result;
    }
}
