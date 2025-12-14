package adventofcode.problem22;

public class PartOne {
    public long getNthSecretNumber(long number, int n) {
        for (int i = 0; i < n; i++) {
            number = nextSecretNumber(number);
        }
        return number;
    }

    private long nextSecretNumber(long secretNumber) {
        secretNumber = ((secretNumber * 64) ^ secretNumber) % 16777216;
        secretNumber = ((secretNumber / 32) ^ secretNumber) % 16777216;
        secretNumber = ((secretNumber * 2048) ^ secretNumber) % 16777216;
        return secretNumber;
    }
}
