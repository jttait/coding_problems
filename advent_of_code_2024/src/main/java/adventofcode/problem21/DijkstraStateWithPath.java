package adventofcode.problem21;

import adventofcode.common.Position;

import java.util.List;
import java.util.Set;

public record DijkstraStateWithPath(int x, int y, int cost, List<Character> path, Set<Position> visited) {}
