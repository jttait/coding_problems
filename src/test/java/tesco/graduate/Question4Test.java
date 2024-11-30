package tesco.graduate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tesco.graduate.Question4.lowestMissing;

class Question4Test {
    @Test
    void shouldBe1forListOf2and3() {
        List<Integer> list = List.of(2, 3);
        int result = lowestMissing(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2forListOf1() {
        List<Integer> list = List.of(1);
        int result = lowestMissing(list);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2forListOf1and3() {
        List<Integer> list = List.of(1, 3);
        int result = lowestMissing(list);
        Assertions.assertEquals(2, result);
    }
}