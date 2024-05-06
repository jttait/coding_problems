package leetcode.problem2487;

import java.util.List;

public class SinglyLinkedList {
    public ListNode createLinkedList(List<Integer> values) {
        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        for (int i = 1; i < values.size(); i++) {
            current.setNext(new ListNode(values.get(i)));
            current = current.getNext();
        }
        return head;
    }

    public boolean compareLinkedLists(ListNode node1, ListNode node2) {
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                return false;
            }
            if (node2 == null) {
                return false;
            }
            if (node1.getVal() != node2.getVal()) {
                return false;
            }
            node1 = node1.getNext();
            node2 = node2.getNext();
        }

        return true;
    }
}
