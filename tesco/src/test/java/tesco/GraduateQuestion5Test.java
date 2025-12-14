package tesco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tesco.GraduateQuestion5.highestPrime;


class GraduateQuestion5Test {
    @Test
    void shouldBe1forListOf1() {
        List<Integer> list = List.of(1);
        int result = highestPrime(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forListOf2() {
        List<Integer> list = List.of(2);
        int result = highestPrime(list);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3forListOf2and3() {
        List<Integer> list = List.of(3);
        int result = highestPrime(list);
        Assertions.assertEquals(3, result);
    }
}