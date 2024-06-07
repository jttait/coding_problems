package leetcode.problem648;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<Character, TrieNode> children;
    private boolean isTerminal;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isTerminal = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }

    public boolean getIsTerminal() {
        return this.isTerminal;
    }
}
