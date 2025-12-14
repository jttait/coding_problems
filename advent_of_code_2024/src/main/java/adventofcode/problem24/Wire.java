package adventofcode.problem24;

public class Wire {
    private WireState state;
    private final String name;

    public Wire(WireState state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(WireState state) {
        this.state = state;
    }

    public WireState getState() {
        return this.state;
    }

    public String getName() {
        return this.name;
    }
}
