package adventofcode.year2024.problem9;

import java.util.*;

public class PartOne {
    public long compact(String diskMap) {
        char[] array = diskMap.toCharArray();
        Stack<Integer> files = new Stack<>();
        List<Integer> compressed = new ArrayList<>();
        int fileId = 0;
        for (int i = 0; i < array.length; i++) {
            int count = array[i] - '0';
            if (i % 2 == 0) {
                for (int j = 0; j < count; j++) {
                    files.push(fileId);
                    compressed.add(fileId);
                }
                fileId++;
            } else {
                for (int j = 0; j < count; j++) {
                    compressed.add(null);
                }
            }
        }
        int compressedLength = files.size();
        for (int i = 0; i < compressed.size(); i++) {
            if (compressed.get(i) == null) {
                compressed.set(i, files.pop());
            }
        }
        long result = 0;
        for (int i = 0; i < compressedLength; i++) {
            result += compressed.get(i) * i;
        }
        return result;
    }
}
