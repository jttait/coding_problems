package adventofcode.problem05;

import adventofcode.problem05.PageOrdering;

import java.util.*;

public class PartOne {
    public boolean isInValidOrder(List<PageOrdering> pageOrderings, List<Integer> pages) {
        Map<Integer, Set<Integer>> pagesThatMustBeBefore = new HashMap<>();
        for (PageOrdering pageOrdering : pageOrderings) {
            pagesThatMustBeBefore.putIfAbsent(pageOrdering.before(), new HashSet<>());
            pagesThatMustBeBefore.get(pageOrdering.before()).add(pageOrdering.after());
        }
        Set<Integer> pagesAlreadySeen = new HashSet<>();
        for (int page : pages) {
            if (pagesThatMustBeBefore.containsKey(page)) {
                Set<Integer> common = new HashSet<>(pagesThatMustBeBefore.get(page));
                common.retainAll(pagesAlreadySeen);
                if (!common.isEmpty()) {
                    return false;
                }
            }
            pagesAlreadySeen.add(page);
        }
        return true;
    }
}
