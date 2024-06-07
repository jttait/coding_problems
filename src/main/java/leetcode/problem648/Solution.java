package leetcode.problem648;

import java.util.List;

public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String dictionaryEntry : dictionary) {
            TrieNode current = root;
            for (int i = 0; i < dictionaryEntry.length(); i++) {
                Character c = dictionaryEntry.charAt(i);
                if (current.getChildren().containsKey(c)) {
                    current = current.getChildren().get(c);
                } else {
                    current.getChildren().put(c, new TrieNode());
                    current = current.getChildren().get(c);
                }
            }
            current.setTerminal(true);
        }

        String[] sentenceWords = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String sentenceWord : sentenceWords) {
            String wordRoot = getRoot(sentenceWord, root);
            result.append(wordRoot).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private String getRoot(String word, TrieNode current) {
        int wordLength = word.length();
        int i = 0;
        while (!current.getIsTerminal() && i < wordLength) {
            Character c = word.charAt(i);
            if (current.getChildren().isEmpty()) {
                return word;
            }
            if (current.getChildren().containsKey(c)) {
                current = current.getChildren().get(c);
                i++;
            } else {
                return word;
            }
        }
        return word.substring(0, i);
    }
}
