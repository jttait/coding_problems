package adventofcode2025.problem06;

public class PartOne {
    public long calculate(Problem problem) {
        long result = (problem.operation() == Operation.MULTIPLY) ? 1 : 0;
        for (long number : problem.numbers()) {
            if (problem.operation() == Operation.MULTIPLY) {
                result *= number;
            } else {
                result += number;
            }
        }
        return result;
    }
}
