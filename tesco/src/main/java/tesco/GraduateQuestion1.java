package tesco;

import java.util.List;

public class GraduateQuestion1 {
    public static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
