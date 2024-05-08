package leetcode.problem506;

public record Athlete(int index, int score) implements Comparable<Athlete> {
    public int compareTo(Athlete o) {
        return o.score() - this.score();
    }
}
