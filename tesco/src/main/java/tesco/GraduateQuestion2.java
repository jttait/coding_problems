package tesco;

import java.util.List;

import static tesco.GraduateQuestion1.sum;

public class GraduateQuestion2 {
    public static int average(List<Integer> list) {
        return sum(list) / list.size();
    }
}
