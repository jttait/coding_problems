package adventofcode.problem16;

import adventofcode.common.Heading;
import adventofcode.common.Position;

import java.util.Set;

public record State2(int x, int y, Heading heading, int score, Set<Position> route) {}
