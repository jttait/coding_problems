package projecteuler.problem1;

public class Solution {

    public int sumOfMultiples(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }
        }
        return result;
    }
}
