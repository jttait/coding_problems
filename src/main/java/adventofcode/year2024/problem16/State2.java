package adventofcode.year2024.problem16;

import adventofcode.year2024.common.Position;

import java.util.Set;

public record State2(int x, int y, Heading heading, int score, Set<Position> route) {}
