package adventofcode.year2024.problem16;

import adventofcode.year2024.common.Heading;

public record State(Pose pose, int score) {
    public State(int x, int y, Heading heading, int score) {
        this(new Pose(x, y, heading), score);
    }
}
