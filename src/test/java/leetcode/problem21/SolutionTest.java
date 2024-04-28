package leetcode.problem21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SolutionTest {
    private Solution solution;
    
    @BeforeEach
    void setUp() {
        solution = new Solution();
        
    }

    @Test
    void shouldBeEmptyIfBothAreEmpty() {
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode result = solution.mergeTwoLists(list1, list2);
        ListNode expected = null;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeList1IfList2IsEmpty() {
        ListNode list1 = new ListNode(1, null);
        ListNode list2 = null;
        ListNode result = solution.mergeTwoLists(list1, list2);
        ListNode expected = new ListNode(1, null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldBeList2IfList1IsEmpty() {
        ListNode list1 = null;
        ListNode list2 = new ListNode(1, null);
        ListNode result = solution.mergeTwoLists(list1, list2);
        ListNode expected = new ListNode(1, null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldMergeTwoListsOfLength1() {
        ListNode list1 = new ListNode(1, null);
        ListNode list2 = new ListNode(2, null);
        ListNode result = solution.mergeTwoLists(list1, list2);
        ListNode expected = new ListNode(1, new ListNode(2, null));
        Assertions.assertEquals(expected, result);
    }
}