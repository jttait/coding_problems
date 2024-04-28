package leetcode.problem21;

public class Solution {
    public ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode merged;
        if (list1.getVal() < list2.getVal()) {
            merged = new ListNode(list1.getVal());
            list1 = list1.getNext();
        } else {
            merged = new ListNode(list2.getVal());
            list2 = list2.getNext();
        }
        ListNode result = merged;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                merged.setNext(new ListNode(list2.getVal(), null));
                merged = merged.getNext();
                list2 = list2.getNext();
            } else if (list2 == null) {
                merged.setNext(new ListNode(list1.getVal(), null));
                merged = merged.getNext();
                list1 = list1.getNext();
            } else if (list1.getVal() < list2.getVal()) {
                merged.setNext(new ListNode(list1.getVal(), null));
                merged = merged.getNext();
                list1 = list1.getNext();
            } else {
                merged.setNext(new ListNode(list2.getVal(), null));
                merged = merged.getNext();
                list2 = list2.getNext();
            }
        }
        return result;
    }
}
