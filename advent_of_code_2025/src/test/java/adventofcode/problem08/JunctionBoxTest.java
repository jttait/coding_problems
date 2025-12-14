package adventofcode.problem08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JunctionBoxTest {
    @Test
    void shouldBe5for345triangle() {
        JunctionBox jb1 = new JunctionBox(0,0,0);
        JunctionBox jb2 = new JunctionBox(3, 4, 0);
        double result = jb1.distanceBetween(jb2);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    void shouldBe5for345triangleOnXPlane() {
        JunctionBox jb1 = new JunctionBox(0,0,0);
        JunctionBox jb2 = new JunctionBox(0, 3, 4);
        double result = jb1.distanceBetween(jb2);
        Assertions.assertEquals(5.0, result);
    }
}