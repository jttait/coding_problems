package adventofcode2025.problem10;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.*;

import java.util.*;

public class PartTwo {
    private final List<List<Integer>> buttons;
    private final List<Integer> joltageRequirements;

    public PartTwo(Machine machine) {
        this.buttons = machine.buttons();
        this.joltageRequirements = machine.joltageRequirements();
    }

    public int countRequiredPresses() {
        Loader.loadNativeLibraries();
        MPSolver solver = MPSolver.createSolver("SCIP");
        MPObjective objective = solver.objective();
        List<MPVariable> mpVariables = new ArrayList<>();
        for (int i = 0; i < this.buttons.size(); i++) {
            MPVariable mpVariable = solver.makeIntVar(0, Integer.MAX_VALUE, "n" + i);
            mpVariables.add(mpVariable);
            objective.setCoefficient(mpVariable, 1);
        }
        for (int i =0; i < this.joltageRequirements.size(); i++) {
            int joltage = this.joltageRequirements.get(i);
            MPConstraint mpConstraint = solver.makeConstraint(joltage, joltage);
            for (int j = 0; j < this.buttons.size(); j++) {
                if (this.buttons.get(j).contains(i)) {
                    mpConstraint.setCoefficient(mpVariables.get(j), 1);
                }
            }
        }
        objective.setMinimization();
        solver.solve();
        int result = 0;
        for (MPVariable mpVariable : mpVariables) {
            result += (int) mpVariable.solutionValue();
        }
        return result;
    }
}
