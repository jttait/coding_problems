package adventofcode2025.problem10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartOne {
    private final List<Boolean> target;
    private final List<List<Integer>> buttons;

    public PartOne(Machine machine) {
        this.target = machine.lights();
        this.buttons = machine.buttons();
    }

    public int countRequiredPresses() {
        List<Boolean> lights = new ArrayList<>();
        for (int i = 0; i < target.size(); i++) {
            lights.add(false);
        }
        int presses = 0;
        Set<List<Boolean>> states = new HashSet<>();
        states.add(lights);
        while (true) {
            for (List<Boolean> state : states) {
                if (state.equals(target)) {
                    return presses;
                }
            }
            Set<List<Boolean>> queue = new HashSet<>(states);
            states = new HashSet<>();
            for (List<Integer> button : buttons) {
                for (List<Boolean> state : queue) {
                    states.add(updateLightsForButtonPress(state, button));
                }
            }
            presses++;
        }
    }

    private List<Boolean> updateLightsForButtonPress(List<Boolean> lights, List<Integer> button) {
        List<Boolean> result = new ArrayList<>(lights);
        for (int i : button) {
            result.set(i, !result.get(i));
        }
        return result;
    }
}
