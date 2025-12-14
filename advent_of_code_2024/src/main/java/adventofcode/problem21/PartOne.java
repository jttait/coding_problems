package adventofcode.problem21;

import adventofcode.problem21.Grid;
import adventofcode.problem21.Keypad;

import java.util.ArrayList;
import java.util.List;

public class PartOne {
    private final List<Keypad> keypads;

    public PartOne(int numRobotControlledKeypads) {
        this.keypads = new ArrayList<>();
        keypads.add(new Keypad(Grid.NUMERIC));
        for (int i = 0; i < numRobotControlledKeypads; i++) {
            keypads.add(new Keypad(Grid.DIRECTIONAL));
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
