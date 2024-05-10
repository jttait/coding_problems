package leetcode.problem786;

import java.util.PriorityQueue;

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<DivisionResult> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                priorityQueue.add(new DivisionResult(arr[i], arr[j]));
            }
        }
        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        DivisionResult kth = priorityQueue.poll();
        return new int[]{kth.getFirstValue(), kth.getSecondValue()};
    }
}
