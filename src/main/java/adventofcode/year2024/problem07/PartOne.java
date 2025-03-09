package adventofcode.year2024.problem07;

import java.math.BigInteger;
import java.util.List;

public class PartOne {
    public BigInteger totalCalibrationResult(List<Equation> equations) {
        BigInteger result = BigInteger.ZERO;
        for (Equation equation : equations) {
            if (possiblyTrue(equation)) {
                result = result.add(equation.testValue());
            }
        }
        return result;
    }

    private boolean possiblyTrue(Equation equation) {
        return dfs(equation.numbers(), BigInteger.ZERO, equation.testValue());
    }

    private boolean dfs(List<BigInteger> numbers, BigInteger total, BigInteger testValue) {
        if (numbers.isEmpty()) {
            return total.equals(testValue);
        }
        if (dfs(numbers.subList(1, numbers.size()), total.add(numbers.get(0)), testValue)) {
            return true;
        }
        return dfs(numbers.subList(1, numbers.size()), total.multiply(numbers.get(0)), testValue);
    }
}
