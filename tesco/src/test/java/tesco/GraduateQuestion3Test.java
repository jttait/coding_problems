package tesco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tesco.GraduateQuestion3.mode;

class GraduateQuestion3Test {
    @Test
    void shouldBe1forListOf1() {
        List<Integer> list = List.of(1);
        int result = mode(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe1forListOf1and2() {
        List<Integer> list = List.of(1, 2);
        int result = mode(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forListOf1and2and2() {
        List<Integer> list = List.of(1, 2, 2);
        int result = mode(list);
        Assertions.assertEquals(2, result);
    }
}