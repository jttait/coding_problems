package projecteuler.problem2;

public class Solution {

    public int sumOfEvenFibonacciNumbersBelow(int n) {
        if (n < 3) {
            return 2;
        }
        int previousPrevious = 1;
        int previous = 2;
        int current = previous + previousPrevious;
        int result = 2;
        while (current < n) {
            if (current % 2 == 0) {
                result += current;
            }
            previousPrevious = previous;
            previous = current;
            current = previous + previousPrevious;
        }
        return result;
    }
}
