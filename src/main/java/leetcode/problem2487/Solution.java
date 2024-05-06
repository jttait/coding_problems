package leetcode.problem2487;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ListNode removeNodes(ListNode node) {
        List<Integer> values = getListOfValues(node);
        List<Integer> maximumToRight = getMaximumsToRight(values);

        ListNode previous = null;
        ListNode current = node;
        int i = 0;
        while (current != null) {
            if (current.getVal() < maximumToRight.get(i)) {
                if (previous == null) {
                    node = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
            } else {
                previous = current;
            }
            current = current.getNext();
            i++;
        }

        return node;
    }

    private List<Integer> getListOfValues(ListNode node) {
        List<Integer> values = new ArrayList<>();
        ListNode current = node;
        while (current != null) {
            values.add(current.getVal());
            current = current.getNext();
        }
        return values;
    }

    private List<Integer> getMaximumsToRight(List<Integer> values) {
        List<Integer> maximumToRight = new ArrayList<>();
        int maximum = 0;
        for (int i = values.size()-1; i >= 0; i--) {
            maximum = Math.max(maximum, values.get(i));
            maximumToRight.add(maximum);
        }
        Collections.reverse(maximumToRight);
        return maximumToRight;
    }
}
