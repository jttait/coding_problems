package adventofcode.problem09;

public class Gap {
    private int start;
    private int size;

    public Gap(int start, int size) {
        this.start = start;
        this.size = size;
    }

    public int getStart() {
        return this.start;
    }

    public int getSize() {
        return this.size;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
