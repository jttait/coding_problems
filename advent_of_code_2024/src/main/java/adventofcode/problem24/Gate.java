package adventofcode.problem24;

import adventofcode.problem24.Wire;
import adventofcode.problem24.WireState;

public interface Gate {
    WireState getInput1state();
    WireState getInput2state();
    WireState getOutputstate();
    Wire getOutputWire();
    Wire getInput1wire();
    Wire getInput2wire();
    void setOutputWire(Wire wire);
}
