package adventofcode.problem16;

import adventofcode.common.Heading;
import adventofcode.common.Pose;

public record State(Pose pose, int score) {
    public State(int x, int y, Heading heading, int score) {
        this(new Pose(x, y, heading), score);
    }
}
