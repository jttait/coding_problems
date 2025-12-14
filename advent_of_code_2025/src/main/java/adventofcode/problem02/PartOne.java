package adventofcode.problem02;

public class PartOne {
    public boolean isValid(long num) {
        String s = String.valueOf(num);
        if (s.length() % 2 != 0) {
            return true;
        }
        return !(s.substring(0, s.length()/2).equals(s.substring(s.length()/2)));
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
