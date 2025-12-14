package adventofcode.problem02;

public class PartTwo {
    public boolean isValid(long num) {
        String s = String.valueOf(num);
        for (int l = 1; l < s.length(); l++) {
            if (!isValidForSubstringLength(s, l)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidForSubstringLength(String s, int l) {
        if (s.length() % l != 0) {
            return true;
        }
        int i = 0;
        int j = l;
        while (j < s.length()) {
            if (!s.substring(i, j).equals(s.substring(j, j + l))) {
                return true;
            }
            i += l;
            j += l;
        }
        return false;
    }

    public long sumInvalidNumbers(long start, long end) {
        long result = 0;
        for (long i = start; i <= end; i++) {
            if (!isValid(i)) {
                result += i;
            }
        }
        return result;
    }
}
