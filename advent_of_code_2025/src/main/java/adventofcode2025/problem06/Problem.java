package adventofcode2025.problem06;

import java.util.List;
import java.util.Objects;

public record Problem(List<Long> numbers, Operation operation) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(numbers, problem.numbers) && operation == problem.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operation);
    }
}
