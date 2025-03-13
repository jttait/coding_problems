package adventofcode.year2024.problem21;

import adventofcode.year2024.common.Position;

import java.util.List;
import java.util.Set;

public record DijkstraState2(int x, int y, long cost, Set<Position> visited, char prev) {}
