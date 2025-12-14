package adventofcode.problem05;

public record Range(long start, long end) {
    public boolean contains(long num) {
        return (num >= start) && (num <= end);
    }

    public boolean isOverlapping(Range range) {
        return range.start() <= this.end && this.start <= range.end();
    }
}
