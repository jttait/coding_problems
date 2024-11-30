package tesco.graduate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tesco.graduate.Question1.sum;

class Question1Test {
    @Test
    void shouldBe1forListOf1() {
        List<Integer> list = List.of(1);
        int result = sum(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forListOf1and1() {
        List<Integer> list = List.of(1, 1);
        int result = sum(list);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe0forEmptyList() {
        List<Integer> list = List.of();
        int result = sum(list);
        Assertions.assertEquals(0, result);
    }
}