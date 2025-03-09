package adventofcode.year2024.problem16;

import adventofcode.year2024.common.Heading;
import adventofcode.year2024.common.Position;

public record Pose(Position position, Heading heading) {
    public Pose(int x, int y, Heading heading) {
        this(new Position(x, y), heading);
    }
}
