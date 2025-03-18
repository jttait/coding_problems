package adventofcode.year2024.problem24;

import java.util.List;
import java.util.Set;

public class PartOne {
    private final List<Gate> gates;

    public PartOne(List<Gate> gates) {
        this.gates = gates;
    }

    public void simulate() {
        int unknownWiresCount = Integer.MAX_VALUE;
        while (unknownWiresCount > 0) {
            unknownWiresCount = 0;
            for (Gate gate : gates) {
                WireState state = gate.getOutputstate();
                if (state == WireState.UNKNOWN) {
                    unknownWiresCount++;
                }
            }
        }
    }
}
