package adventofcode.year2024.problem24;

public interface Gate {
    WireState getInput1state();
    WireState getInput2state();
    WireState getOutputstate();
    Wire getOutputWire();
    Wire getInput1wire();
    Wire getInput2wire();
    void setOutputWire(Wire wire);
}
