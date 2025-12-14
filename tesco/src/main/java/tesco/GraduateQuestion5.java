package tesco;

import java.util.List;

public class GraduateQuestion5 {
    public static int highestPrime(List<Integer> list) {
        int result = 0;
        for (int item : list) {
            if (item == 1) {
                result = 1;
            }
            if (isPrime(item)) {
                result = Math.max(result, item);
            }
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
