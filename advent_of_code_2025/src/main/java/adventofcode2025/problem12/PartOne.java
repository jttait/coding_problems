package adventofcode2025.problem12;

import java.util.List;

public class PartOne {
    private final Tree tree;
    private final List<Integer> presentSizes;

    public PartOne(Tree tree, List<Integer> presentSizes) {
        this.tree = tree;
        this.presentSizes = presentSizes;
    }

    public boolean canShapesFitInGrid() {
        int gridSize = tree.gridHeight() * tree.gridWidth();
        int presentsSize = 0;
        for (int i = 0; i < tree.presents().size(); i++) {
            presentsSize += tree.presents().get(i) * presentSizes.get(i);
        }
        return presentsSize <= gridSize;
    }
}
