package adventofcode.year2024.problem06;

import adventofcode.year2024.common.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartOne {
    private final Utils utils;

    public PartOne() {
        this.utils = new Utils();
    }

    public int distinctPositions(List<List<Character>> grid) throws Exception {
        Pose pose = utils.findStartingPose(grid);
        Set<Position> visited = new HashSet<>();
        visited.add(pose.position());
        while (utils.inBounds(pose, grid)) {
            pose = utils.updatePose(pose, grid);
            visited.add(pose.position());
        }
        return visited.size() - 1;
    }
}
