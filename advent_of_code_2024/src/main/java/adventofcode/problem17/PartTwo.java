package adventofcode.problem17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartTwo {
    private final List<Long> results;

    public PartTwo() {
        this.results = new ArrayList<>();
    }

    public long findLowestRegisterA(List<Integer> program) {
        Collections.reverse(program);
        recursion(0, 8, 0, program);
        return Collections.min(this.results);
    }

    private void recursion(long m, long n, int idx, List<Integer> program) {
        for (long a = m; a < n; a++) {
            if (decompile(a) == program.get(idx)) {
                if (idx == program.size() - 1) {
                    this.results.add(a);
                } else {
                    recursion(a * 8, (a+1) * 8, idx + 1, program);
                }
            }
        }
    }

//    0,3,5,4,3,0
//    private int decompile(int a) {
//        a >>= 3;
//        int out = a & 7;
//        return out;
//    }

//  2,4 1,1 7,5 4,0 0,3 1,6 5,5 3,0
    private long decompile(long a) {
        long b = a & 7;
        b ^= 1;
        long c = a >> b;
        b ^= c;
        b ^= 6;
        return b & 7;
    }
}
