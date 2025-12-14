package adventofcode.problem24;

import adventofcode.problem24.Gate;
import adventofcode.problem24.Wire;
import adventofcode.problem24.WireState;

public class XorGate implements Gate {
    private final Wire input1;
    private final Wire input2;
    private Wire output;

    public XorGate(Wire input1, Wire input2, Wire output) {
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
    }

    @Override
    public WireState getInput1state() {
        return this.input1.getState();
    }

    @Override
    public WireState getInput2state() {
        return this.input2.getState();
    }

    @Override
    public WireState getOutputstate() {
        if (getInput1state() == WireState.UNKNOWN || getInput2state() == WireState.UNKNOWN) {
            return WireState.UNKNOWN;
        }
        WireState result = (getInput1state() == WireState.TRUE ^ getInput2state() == WireState.TRUE) ? WireState.TRUE : WireState.FALSE;
        output.setState(result);
        return this.output.getState();
    }

    @Override
    public Wire getOutputWire() {
        return this.output;
    }

    @Override
    public Wire getInput1wire() {
        return this.input1;
    }

    @Override
    public Wire getInput2wire() {
        return this.input2;
    }

    @Override
    public void setOutputWire(Wire wire) {
        this.output = wire;
    }
}
