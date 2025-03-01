package adventofcode.year2024.problem14;

import java.util.List;

public class PartOne {
    private final List<Robot> robots;
    private final int width;
    private final int height;

    public PartOne(List<Robot> robots, int width, int height) {
        this.robots = robots;
        this.width = width;
        this.height = height;
    }

    public int calculateSafetyFactor(int numTicks) {
        for (int tick = 0; tick < numTicks; tick++) {
            for (Robot robot : robots) {
                robot.tick(width, height);
            }
        }
        int topLeft = 0;
        int topRight = 0;
        int bottomLeft = 0;
        int bottomRight = 0;
        for (Robot robot : robots) {
            int x = robot.getPositionX();
            int y = robot.getPositionY();
            if (x < width / 2 && y < height / 2) {
                topLeft++;
            } else if (x > width / 2 && y < height / 2) {
                topRight++;
            } else if (x < width / 2 && y > height / 2) {
                bottomLeft++;
            } else if (x > width / 2 && y > height / 2) {
                bottomRight++;
            }
        }
        return topLeft * topRight * bottomLeft * bottomRight;
    }
}
