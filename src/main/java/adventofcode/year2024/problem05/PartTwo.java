package adventofcode.year2024.problem05;

import java.util.*;

public class PartTwo {
    private final PartOne partOne;

    public PartTwo() {
        this.partOne = new PartOne();
    }

    public int sortAndGetMiddleValueIfNotValid(List<PageOrdering> pageOrderings, List<Integer> pages) {
        if (!partOne.isInValidOrder(pageOrderings, pages)) {
            return sortIntoValidOrderAndTakeMiddleValue(pageOrderings, pages);
        }
        return 0;
    }

    public int sortIntoValidOrderAndTakeMiddleValue(List<PageOrdering> pageOrderings, List<Integer> pages) {
        Map<Integer, Set<Integer>> pagesThatMustBeAfter = new HashMap<>();
        for (PageOrdering pageOrdering : pageOrderings) {
            if (pages.contains(pageOrdering.after()) && pages.contains(pageOrdering.before())) {
                pagesThatMustBeAfter.putIfAbsent(pageOrdering.after(), new HashSet<>());
                pagesThatMustBeAfter.get(pageOrdering.after()).add(pageOrdering.before());
            }
        }
        Set<Integer> pagesSet = new HashSet<>(pages);
        List<Integer> sortedPages = new ArrayList<>();
        int size = pagesSet.size();
        while (sortedPages.size() < size) {
            int toBeRemoved = -1;
            for (int page : pagesSet) {
                if (!pagesThatMustBeAfter.containsKey(page) || pagesThatMustBeAfter.get(page).isEmpty()) {
                    sortedPages.add(page);
                    toBeRemoved = page;
                }
            }
            pagesSet.remove(toBeRemoved);
            for (int page2 : pagesSet) {
                pagesThatMustBeAfter.get(page2).remove(toBeRemoved);
            }

        }
        return sortedPages.get(sortedPages.size()/2);
    }
}
