package leetcode.problem1813;

public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] array1 = sentence1.split("\\s+");
        String[] array2 = sentence2.split("\\s+");
        if (array1.length == array2.length) {
            return sentence1.equals(sentence2);
        }

        String[] shortest;
        String[] longest;
        if (array1.length >= array2.length) {
            longest = array1;
            shortest = array2;
        } else {
            longest = array2;
            shortest = array1;
        }

        return isShortestAcombinationOfPrefixAndSuffixOfLongest(shortest, longest);
    }

    private boolean isShortestAcombinationOfPrefixAndSuffixOfLongest(String[] shortest, String[] longest) {
        int shortestIndex = 0;
        int longestIndex = 0;
        while (shortestIndex < shortest.length && shortest[shortestIndex].equals(longest[longestIndex])) {
            shortestIndex++;
            longestIndex++;
        }
        longestIndex = longest.length - shortest.length + shortestIndex;
        while (longestIndex < longest.length && shortest[shortestIndex].equals(longest[longestIndex])) {
            shortestIndex++;
            longestIndex++;
        }
        return shortestIndex == shortest.length;
    }
}
