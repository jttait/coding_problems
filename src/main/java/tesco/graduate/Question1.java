package tesco.graduate;

import java.util.List;

public class Question1 {
    public static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
