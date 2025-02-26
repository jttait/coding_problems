package adventofcode.year2024.problem11;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PartOne {

    public long stoneAfterBlinks(List<Long> stones, int numBlinks) {
        Deque<Long> queue = new LinkedList<>();
        for (Long stone : stones) {
            queue.addFirst(stone);
        }
        for (int blink = 0; blink < numBlinks; blink++) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                long num = queue.removeFirst();
                int numDigits = String.valueOf(num).length();
                if (num == 0) {
                    queue.addLast(1L);
                } else if (numDigits % 2 == 0) {
                    String string = String.valueOf(num);
                    queue.addLast(Long.parseLong(string.substring(0, string.length()/2)));
                    queue.addLast(Long.parseLong(string.substring(string.length()/2)));
                } else {
                    queue.addLast(num * 2024);
                }
            }
        }
        return queue.size();
    }
}
