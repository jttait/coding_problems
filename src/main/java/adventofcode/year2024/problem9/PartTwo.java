package adventofcode.year2024.problem9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PartTwo {
    Stack<ContiguousFile> contiguousFiles;
    List<Gap> gaps;

    public PartTwo() {
        this.contiguousFiles = new Stack<>();
        this.gaps = new ArrayList<>();
    }

    public long compact(String diskMap) {
        char[] array = diskMap.toCharArray();
        List<ContiguousFile> movedContiguousFiles = new ArrayList<>();
        populateContiguousFilesAndGaps(array);
        while (!this.contiguousFiles.isEmpty()) {
            ContiguousFile contiguousFile = contiguousFiles.pop();
            boolean moved = false;
            for (Gap gap : this.gaps) {
                if (gap.getSize() >= contiguousFile.size() && gap.getStart() < contiguousFile.start() && !moved) {
                    movedContiguousFiles.add(new ContiguousFile(contiguousFile.fileId(), gap.getStart(), contiguousFile.size()));
                    gap.setStart(gap.getStart() + contiguousFile.size());
                    gap.setSize(gap.getSize() - contiguousFile.size());
                    moved = true;
                }
            }
            if (!moved) {
                movedContiguousFiles.add(new ContiguousFile(contiguousFile.fileId(), contiguousFile.start(), contiguousFile.size()));
            }
        }
        Collections.reverse(movedContiguousFiles);
        long result = 0;
        for (ContiguousFile contiguousFile : movedContiguousFiles) {
            long index = contiguousFile.start();
            for (int i = 0; i < contiguousFile.size(); i++) {
                result += contiguousFile.fileId() * index;
                index++;
            }
        }
        return result;
    }

    private void populateContiguousFilesAndGaps(char[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int digit = array[i] - '0';
            if (i % 2 == 0) {
                this.contiguousFiles.add(new ContiguousFile(i/2, index, digit));
            } else if (digit > 0) {
                this.gaps.add(new Gap(index, digit));
            }
            index += digit;
        }
    }
}
