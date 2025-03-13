package adventofcode.year2024.problem21;

import adventofcode.year2024.common.Position;

import java.util.List;
import java.util.Set;

public record DijkstraStateWithPath(int x, int y, int cost, List<Character> path, Set<Position> visited) {}
