package adventofcode.year2024.problem22;

import java.util.*;

public class PartTwo {
    private final PartOne partOne = new PartOne();

    public long maximiseProfit(List<Integer> startingNumbers) {
        Set<List<Long>> sequences = new HashSet<>();
        List<Map<List<Long>, Long>> sequencesToMaximumProfit = new ArrayList<>();
        for (int startingNumberIndex = 0; startingNumberIndex < startingNumbers.size(); startingNumberIndex++) {
            sequencesToMaximumProfit.add(new HashMap<>());
            List<Long> secretNumbers = calculate2000secretNumbers(startingNumbers.get(startingNumberIndex));
            List<Long> prices = convertSecretNumbersToPrices(secretNumbers);
            List<Long> priceChanges = calculatePriceChanges(prices);
            for (int i = 4; i < priceChanges.size(); i++) {
                List<Long> sequence = List.of(priceChanges.get(i - 3), priceChanges.get(i - 2), priceChanges.get(i - 1), priceChanges.get(i));
                long price = prices.get(i);
                sequences.add(sequence);
                if (!sequencesToMaximumProfit.get(startingNumberIndex).containsKey(sequence)) {
                    sequencesToMaximumProfit.get(startingNumberIndex).put(sequence, price);
                }
            }
        }
        long result = 0;
        for (List<Long> sequence : sequences) {
            long sequenceResult = 0L;
            for (int startingNumberIndex = 0; startingNumberIndex < startingNumbers.size(); startingNumberIndex++) {
                if (sequencesToMaximumProfit.get(startingNumberIndex).containsKey(sequence)) {
                    sequenceResult += sequencesToMaximumProfit.get(startingNumberIndex).get(sequence);
                }
            }
            result = Math.max(result, sequenceResult);
        }
        return result;
    }

    private List<Long> calculatePriceChanges(List<Long> prices) {
        List<Long> result = new ArrayList<>();
        result.add(Long.MAX_VALUE);
        for (int i = 1; i < prices.size(); i++) {
            result.add(prices.get(i) - prices.get(i - 1));
        }
        return result;
    }

    private List<Long> calculate2000secretNumbers(long secretNumber) {
        List<Long> result = new ArrayList<>();
        result.add(secretNumber);
        for (int i = 1; i <= 2000; i++) {
            secretNumber = nextSecretNumber(secretNumber);
            result.add(secretNumber);
        }
        return result;
    }

    private List<Long> convertSecretNumbersToPrices(List<Long> secretNumbers) {
        List<Long> result = new ArrayList<>();
        for (long secretNumber : secretNumbers) {
            result.add(secretNumber % 10);
        }
        return result;
    }

    private long nextSecretNumber(long secretNumber) {
        secretNumber = ((secretNumber * 64) ^ secretNumber) % 16777216;
        secretNumber = ((secretNumber / 32) ^ secretNumber) % 16777216;
        secretNumber = ((secretNumber * 2048) ^ secretNumber) % 16777216;
        return secretNumber;
    }
}
