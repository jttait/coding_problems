package adventofcode.year2024.common;

public record Pose(Position position, Heading heading) {
    public Pose(int x, int y, Heading heading) {
        this(new Position(x, y), heading);
    }
}
