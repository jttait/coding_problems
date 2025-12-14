package adventofcode.problem17;

import java.util.ArrayList;
import java.util.List;

public class PartOne {
    private int registerA;
    private int registerB;
    private int registerC;
    private int instructionPointer;
    private final List<Integer> program;
    private final List<Integer> out;

    public PartOne(int registerA, int registerB, int registerC, List<Integer> program) {
        this.registerA = registerA;
        this.registerB = registerB;
        this.registerC = registerC;
        this.instructionPointer = 0;
        this.program = program;
        this.out = new ArrayList<>();
    }

    public List<Integer> compute() {
        while (instructionPointer < program.size()) {
            int instruction = program.get(instructionPointer++);
            int operand = program.get(instructionPointer++);
            if (instruction == 0) {
                registerA >>= getComboOperand(operand);
            } else if (instruction == 1) {
                registerB ^= operand;
            } else if (instruction == 2) {
                registerB = getComboOperand(operand) & 7;
            } else if (instruction == 3 && registerA != 0) {
                instructionPointer = operand;
            } else if (instruction == 4) {
                registerB ^= registerC;
            } else if (instruction == 5) {
                out.add(getComboOperand(operand) & 7);
            } else if (instruction == 6) {
                registerB = registerA >> getComboOperand(operand);
            } else if (instruction == 7) {
                registerC = registerA >> getComboOperand(operand);
            }
        }
        return this.out;
    }

    public int getComboOperand(int operand) {
        if (operand <= 3) {
            return operand;
        }
        if (operand == 4) {
            return registerA;
        }
        if (operand == 5) {
            return registerB;
        }
        if (operand == 6) {
            return registerC;
        }
        return -1;
    }
}
