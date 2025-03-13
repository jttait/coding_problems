package adventofcode.year2024.problem21;

import java.util.ArrayList;
import java.util.List;

public class PartTwo {

    public long lengthOfShortestPath(int numRobotControlledDirectionalKeypads) {
        List<Keypad2> keypads = new ArrayList<>();
        keypads.add(new Keypad2(Grid.NUMERIC));
        for (int i = 0; i < numRobotControlledDirectionalKeypads; i++) {
            keypads.add(new Keypad2(Grid.DIRECTIONAL));
        }

        for (int i = 0; i < keypads.size() - 1; i++) {
            keypads.get(i).setPrecedingKeypad(keypads.get(i+1));
        }

        long result = 0;
        long presses = 0;
        presses += keypads.get(0).lengthOfShortestPath('A', '5');
        presses += keypads.get(0).lengthOfShortestPath('5', '3');
        presses += keypads.get(0).lengthOfShortestPath('3', '9');
        presses += keypads.get(0).lengthOfShortestPath('9', 'A');
        result += presses * 539;

        presses = 0;
        presses += keypads.get(0).lengthOfShortestPath('A', '9');
        presses += keypads.get(0).lengthOfShortestPath('9', '6');
        presses += keypads.get(0).lengthOfShortestPath('6', '4');
        presses += keypads.get(0).lengthOfShortestPath('4', 'A');
        result += presses * 964;

        presses = 0;
        presses += keypads.get(0).lengthOfShortestPath('A', '8');
        presses += keypads.get(0).lengthOfShortestPath('8', '0');
        presses += keypads.get(0).lengthOfShortestPath('0', '3');
        presses += keypads.get(0).lengthOfShortestPath('3', 'A');
        result += presses * 803;

        presses = 0;
        presses += keypads.get(0).lengthOfShortestPath('A', '1');
        presses += keypads.get(0).lengthOfShortestPath('1', '4');
        presses += keypads.get(0).lengthOfShortestPath('4', '9');
        presses += keypads.get(0).lengthOfShortestPath('9', 'A');
        result += presses * 149;

        presses = 0;
        presses += keypads.get(0).lengthOfShortestPath('A', '7');
        presses += keypads.get(0).lengthOfShortestPath('7', '8');
        presses += keypads.get(0).lengthOfShortestPath('8', '9');
        presses += keypads.get(0).lengthOfShortestPath('9', 'A');
        result += presses * 789;

        return result;
    }
}
