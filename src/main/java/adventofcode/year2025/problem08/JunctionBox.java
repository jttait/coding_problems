package adventofcode.year2025.problem08;

import java.util.Objects;

public record JunctionBox(long x, long y, long z) {
    public double distanceBetween(JunctionBox jb) {
        return Math.sqrt((jb.x()-this.x)*(jb.x()-this.x) + (jb.y()-this.y)*(jb.y()-this.y) + (jb.z()-this.z)*(jb.z()-this.z));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JunctionBox that = (JunctionBox) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
