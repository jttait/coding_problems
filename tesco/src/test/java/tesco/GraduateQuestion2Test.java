package tesco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tesco.GraduateQuestion2.average;


class GraduateQuestion2Test {
    @Test
    void shouldBe1forListOf1() {
        List<Integer> list = List.of(1);
        int result = average(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forListOf1and1() {
        List<Integer> list = List.of(1, 1);
        int result = average(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forListOf1and2() {
        List<Integer> list = List.of(1, 2);
        int result = average(list);
        Assertions.assertEquals(1, result);
    }
}