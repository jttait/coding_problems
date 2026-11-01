package problem04;

import java.util.List;
import java.util.Set;

public record Scratchcard(int index, Set<Integer> winningNumbers, Set<Integer> numbersYouHave) {
}
