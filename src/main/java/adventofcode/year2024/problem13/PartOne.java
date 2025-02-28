package adventofcode.year2024.problem13;

import java.util.HashMap;
import java.util.Map;

public class PartOne {
    private final int ax;
    private final int ay;
    private final int bx;
    private final int by;
    private final int px;
    private final int py;
    private final Map<String, Integer> costs;

    public PartOne(int ax, int ay, int bx, int by, int px, int py) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.px = px;
        this.py = py;
        this.costs = new HashMap<>();
    }

    public int calculateCost() {
        dfs(px, py, 0);
        if (this.costs.containsKey("0,0")) {
            return this.costs.get("0,0");
        }
        return 0;
    }

    private void dfs(int x, int y, int cost) {
        if (x < 0 || y < 0) {
            return;
        }
        String key = x + "," + y;
        if (this.costs.containsKey(key)) {
            return;
        }
        this.costs.put(key, cost);
        dfs(x - ax, y - ay, cost + 3);
        dfs(x - bx, y - by, cost + 1);
    }
}
