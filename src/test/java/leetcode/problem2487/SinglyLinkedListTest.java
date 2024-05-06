package leetcode.problem2487;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class SinglyLinkedListTest {
    private SinglyLinkedList linkedList;

    @BeforeEach
    void setUp() {
        this.linkedList = new SinglyLinkedList();
    }

    @Test
    void shouldCreateLinkedListWithOneNode() {
        ListNode result = linkedList.createLinkedList(List.of(1));
        List<Integer> resultValues = new ArrayList<>();
        while (result != null) {
            resultValues.add(result.getVal());
            result = result.getNext();
        }
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(resultValues, expected);
    }

    @Test
    void shouldCreateLinkedListWithTwoNodes() {
        ListNode result = linkedList.createLinkedList(List.of(1, 2));
        List<Integer> resultValues = new ArrayList<>();
        while (result != null) {
            resultValues.add(result.getVal());
            result = result.getNext();
        }
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(resultValues, expected);
    }

    @Test
    void shouldCreateLinkedListWithThreeNodes() {
        ListNode result = linkedList.createLinkedList(List.of(1, 2, 3));
        List<Integer> resultValues = new ArrayList<>();
        while (result != null) {
            resultValues.add(result.getVal());
            result = result.getNext();
        }
        List<Integer> expected = List.of(1, 2, 3);
        Assertions.assertEquals(resultValues, expected);
    }

    @Test
    void shouldBeTrueForSameLinkedList() {
        ListNode node1 = linkedList.createLinkedList(List.of(1, 2));
        ListNode node2 = linkedList.createLinkedList(List.of(1, 2));
        Assertions.assertTrue(linkedList.compareLinkedLists(node1, node2));
    }

    @Test
    void shouldBeFalseForSameLinkedList() {
        ListNode node1 = linkedList.createLinkedList(List.of(1, 2));
        ListNode node2 = linkedList.createLinkedList(List.of(1, 1));
        Assertions.assertFalse(linkedList.compareLinkedLists(node1, node2));
    }
}