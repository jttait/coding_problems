package leetcode.problem786;

public class DivisionResult implements Comparable<DivisionResult> {
    private final int firstValue;
    private final int secondValue;
    private final double divisionResult;

    public DivisionResult(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.divisionResult = (double) firstValue / (double) secondValue;
    }

    @Override
    public int compareTo(DivisionResult o) {
        if (o.divisionResult > this.divisionResult) {
            return -1;
        } else if (o.divisionResult < this.divisionResult) {
            return 1;
        }
        return 0;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }
}
