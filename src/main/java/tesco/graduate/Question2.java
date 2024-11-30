package tesco.graduate;

import java.util.List;

import static tesco.graduate.Question1.sum;

public class Question2 {
    public static int average(List<Integer> list) {
        return sum(list) / list.size();
    }
}
