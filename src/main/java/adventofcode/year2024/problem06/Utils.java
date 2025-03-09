package adventofcode.year2024.problem06;

import adventofcode.year2024.common.Position;

import java.util.List;

public class Utils {
    public Pose updatePose(Pose pose, List<List<Character>> grid) {
        Heading heading = pose.heading();
        int x = pose.position().x();
        int y = pose.position().y();
        if (heading == Heading.NORTH) {
            if (isObstacleInFront(pose, grid)) {
                return new Pose(new Position(x, y), Heading.EAST);
            }
            return new Pose(new Position(x, y - 1), heading);
        }
        if (heading == Heading.EAST) {
            if (isObstacleInFront(pose, grid)) {
                return new Pose(new Position(x, y), Heading.SOUTH);
            }
            return new Pose(new Position(x + 1, y), heading);
        }
        if (heading == Heading.SOUTH) {
            if (isObstacleInFront(pose, grid)) {
                return new Pose(new Position(x, y), Heading.WEST);
            }
            return new Pose(new Position(x, y + 1), heading);
        }
        if (isObstacleInFront(pose, grid)) {
            return new Pose(new Position(x, y), Heading.NORTH);
        }
        return new Pose(new Position(x - 1, y), heading);
    }

    public Pose getPoseInFront(Pose pose) {
        Heading heading = pose.heading();
        int x = pose.position().x();
        int y = pose.position().y();
        if (heading == Heading.NORTH) {
            return new Pose(new Position(x, y - 1), heading);
        }
        if (heading == Heading.EAST) {
            return new Pose(new Position(x + 1, y), heading);
        }
        if (heading == Heading.SOUTH) {
            return new Pose(new Position(x, y + 1), heading);
        }
        return new Pose(new Position(x - 1, y), heading);
    }

    public boolean isObstacleInFront(Pose pose, List<List<Character>> grid) {
        Pose poseInFront = getPoseInFront(pose);
        if (!inBounds(poseInFront, grid)) {
            return false;
        }
        int rowInFront = poseInFront.position().y();
        int colInFront = poseInFront.position().x();
        return grid.get(rowInFront).get(colInFront) == '#';
    }

    public boolean inBounds(Pose pose, List<List<Character>> grid) {
        int x = pose.position().x();
        int y = pose.position().y();
        return x >= 0 && y >= 0 && y < grid.size() && x < grid.get(0).size();
    }

    public Pose findStartingPose(List<List<Character>> grid) throws Exception {
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == '^') {
                    return new Pose(new Position(x, y), Heading.NORTH);
                }
            }
        }
        throw new Exception("Starting position not found");
    }
}
