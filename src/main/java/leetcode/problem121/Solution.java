package leetcode.problem121;

public class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            result = Math.max(result, profit);
            if (right == left + 1) {
                right++;
            } else if (right + 1 < prices.length && prices[right+1] > prices[right]) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }
}
