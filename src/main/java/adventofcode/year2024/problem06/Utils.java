package adventofcode.year2024.problem06;

import java.util.List;

public class Utils {
    public Pose updatePose(Pose pose, List<List<Character>> grid) {
        Heading heading = pose.heading();
        int row = pose.position().row();
        int col = pose.position().col();
        if (heading == Heading.NORTH) {
            if (isObstacleInFront(pose, grid)) {
                return new Pose(new Position(row, col), Heading.EAST);
            }
            return new Pose(new Position(row-1, col), heading);
        }
        if (heading == Heading.EAST) {
            if (isObstacleInFront(pose, grid)) {
                return new Pose(new Position(row, col), Heading.SOUTH);
            }
            return new Pose(new Position(row, col+1), heading);
        }
        if (heading == Heading.SOUTH) {
            if (isObstacleInFront(pose, grid)) {
                return new Pose(new Position(row, col), Heading.WEST);
            }
            return new Pose(new Position(row+1, col), heading);
        }
        if (isObstacleInFront(pose, grid)) {
            return new Pose(new Position(row, col), Heading.NORTH);
        }
        return new Pose(new Position(row, col-1), heading);
    }

    public Pose getPoseInFront(Pose pose) {
        Heading heading = pose.heading();
        int row = pose.position().row();
        int col = pose.position().col();
        if (heading == Heading.NORTH) {
            return new Pose(new Position(row-1, col), heading);
        }
        if (heading == Heading.EAST) {
            return new Pose(new Position(row, col+1), heading);
        }
        if (heading == Heading.SOUTH) {
            return new Pose(new Position(row+1, col), heading);
        }
        return new Pose(new Position(row, col-1), heading);
    }

    public boolean isObstacleInFront(Pose pose, List<List<Character>> grid) {
        Pose poseInFront = getPoseInFront(pose);
        if (!inBounds(poseInFront, grid)) {
            return false;
        }
        int rowInFront = poseInFront.position().row();
        int colInFront = poseInFront.position().col();
        return grid.get(rowInFront).get(colInFront) == '#';
    }

    public boolean inBounds(Pose pose, List<List<Character>> grid) {
        int row = pose.position().row();
        int col = pose.position().col();
        return row >= 0 && col >= 0 && row < grid.size() && col < grid.get(0).size();
    }

    public Pose findStartingPose(List<List<Character>> grid) throws Exception {
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == '^') {
                    return new Pose(new Position(row, col), Heading.NORTH);
                }
            }
        }
        throw new Exception("Starting position not found");
    }
}
