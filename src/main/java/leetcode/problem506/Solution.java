package leetcode.problem506;

import java.util.PriorityQueue;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Athlete> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            Athlete athlete = new Athlete(i, score[i]);
            priorityQueue.add(athlete);
        }

        String[] result = new String[score.length];
        int rank = 1;
        while (!priorityQueue.isEmpty()) {
            int index = priorityQueue.poll().index();
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}
