package adventofcode.problem13;

import java.util.HashMap;
import java.util.Map;

public class PartTwo {
    private final int ax;
    private final int ay;
    private final int bx;
    private final int by;
    private final long px;
    private final long py;
    private final Map<String, Long> costs;

    public PartTwo(int ax, int ay, int bx, int by, int px, int py) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.px = px + 10000000000000L;
        this.py = py + 10000000000000L;
        this.costs = new HashMap<>();
    }

    public long calculateCost() {
        if ((px * by - py * bx) % ((long) ax * by - (long) ay * bx) != 0) {
            return 0;
        }
        long s = (px * by - py * bx) / ((long) ax * by - (long) ay * bx);
        if ((px - ax * s) % bx != 0) {
            return 0;
        }
        long t = (px - ax * s) / bx;
        return s * 3 + t;
    }
}
