package adventofcode.problem07;

import adventofcode.problem07.Equation;

import java.math.BigInteger;
import java.util.List;

public class PartTwo {
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
        return dfs(equation.numbers(), equation.numbers().get(0), equation.testValue(), 1);
    }

    private boolean dfs(List<BigInteger> numbers, BigInteger total, BigInteger testValue, int index) {
        if (index == numbers.size()) {
            return total.equals(testValue);
        }
        if (dfs(numbers, total.add(numbers.get(index)), testValue, index + 1)) {
            return true;
        }
        if (dfs(numbers, total.multiply(numbers.get(index)), testValue, index + 1)) {
            return true;
        }
        return dfs(numbers, new BigInteger(total.toString() + numbers.get(index).toString()), testValue, index + 1);
    }
}
