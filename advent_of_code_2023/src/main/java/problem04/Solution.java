package problem04;

import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public long calculatePoints(Scratchcard scratchcard) {
        Set<Integer> winningNumbers = scratchcard.winningNumbers();
        Set<Integer> numbersYouHave = scratchcard.numbersYouHave();
        long matchingCount = numbersYouHave.stream().filter(winningNumbers::contains).count();
        if (matchingCount == 0) {
            return 0;
        }
        if (matchingCount == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 2; i < matchingCount; i++) {
            result *= 2;
        }
        return result;
    }

    private long countMatches(Scratchcard scratchcard) {
        Set<Integer> winningNumbers = scratchcard.winningNumbers();
        Set<Integer> numbersYouHave = scratchcard.numbersYouHave();
        return numbersYouHave.stream().filter(winningNumbers::contains).count();
    }

    public long countWonScratchcards(List<Scratchcard> scratchcards) {
        Stack<Scratchcard> stack = new Stack<>();
        for (Scratchcard scratchcard : scratchcards) {
            stack.push(scratchcard);
        }
        long result = 0;
        while (!stack.isEmpty()) {
            result++;
            Scratchcard scratchcard = stack.pop();
            int index = scratchcard.index();
            long matches = countMatches(scratchcard);
            for (int i = 1; i <= matches && index + i - 1 < scratchcards.size(); i++) {
                stack.push(scratchcards.get(index + i - 1));
            }
        }
        return result;
    }
}
