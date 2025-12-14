package adventofcode.problem06;

import adventofcode.common.Pose;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PartTwo {
    private final Utils utils;

    public PartTwo() {
        this.utils = new Utils();
    }

    public int possibleObstacles(List<List<Character>> grid) throws Exception {
        int result = 0;
        List<List<Character>> copyOfGrid = grid.stream().map(ArrayList::new).collect(Collectors.toList());
        for (int obstacleY = 0; obstacleY < copyOfGrid.size(); obstacleY++) {
            for (int obstacleX = 0; obstacleX < copyOfGrid.get(0).size(); obstacleX++) {
                if (copyOfGrid.get(obstacleY).get(obstacleX) == '.') {
                    copyOfGrid.get(obstacleY).set(obstacleX, '#');
                    if (hasCycle(copyOfGrid)) {
                        result++;
                    }
                    copyOfGrid.get(obstacleY).set(obstacleX, '.');
                }
            }
        }
        return result;
    }

    private boolean hasCycle(List<List<Character>> grid) throws Exception {
        Pose pose = utils.findStartingPose(grid);
        Set<Pose> visited = new HashSet<>();
        visited.add(pose);
        while (utils.inBounds(pose, grid)) {
            pose = utils.updatePose(pose, grid);
            boolean notAlreadyVisited = visited.add(pose);
            if (!notAlreadyVisited) {
                return true;
            }
        }
        return false;
    }
}
