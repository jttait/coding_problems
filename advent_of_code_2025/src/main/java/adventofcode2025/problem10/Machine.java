package adventofcode2025.problem10;

import java.util.List;

public record Machine(List<Boolean> lights, List<List<Integer>> buttons, List<Integer> joltageRequirements) {}
