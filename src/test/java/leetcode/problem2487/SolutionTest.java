package leetcode.problem2487;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class SolutionTest {
    private Solution solution;
    private SinglyLinkedList linkedList;

    @BeforeEach
    void setUp() {
        solution = new Solution();
        linkedList = new SinglyLinkedList();
    }

    @Test
    void shouldBeUnchangedForListOfAllSameValues() {
        ListNode list = linkedList.createLinkedList(List.of(1, 1));
        ListNode result = solution.removeNodes(list);
        ListNode expected = linkedList.createLinkedList(List.of(1, 1));
        Assertions.assertTrue(linkedList.compareLinkedLists(result, expected));
    }

    @Test
    void shouldRemoveHead() {
        ListNode list = linkedList.createLinkedList(List.of(1, 2));
        ListNode result = solution.removeNodes(list);
        ListNode expected = linkedList.createLinkedList(List.of(2));
        Assertions.assertTrue(linkedList.compareLinkedLists(result, expected));
    }

    @Test
    void shouldRemoveMiddleNode() {
        ListNode list = linkedList.createLinkedList(List.of(2, 1, 2));
        ListNode result = solution.removeNodes(list);
        ListNode expected = linkedList.createLinkedList(List.of(2, 2));
        Assertions.assertTrue(linkedList.compareLinkedLists(result, expected));
    }

    @Test
    void shouldRemoveHeadAndMiddleNodes() {
        ListNode list = linkedList.createLinkedList(List.of(1, 1, 2));
        ListNode result = solution.removeNodes(list);
        ListNode expected = linkedList.createLinkedList(List.of(2));
        Assertions.assertTrue(linkedList.compareLinkedLists(result, expected));
    }

    @Test
    void shouldWorkWithLongList() {
        ListNode list = linkedList.createLinkedList(List.of(1, 2, 5, 2, 4));
        ListNode result = solution.removeNodes(list);
        ListNode expected = linkedList.createLinkedList(List.of(5, 4));
        Assertions.assertTrue(linkedList.compareLinkedLists(result, expected));
    }
}